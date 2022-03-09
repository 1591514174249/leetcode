package com.lxs._22_3_4_2104;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_2104 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3};
        long res = subArrayRanges(nums);
        System.out.println(res);
    }

    public static long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    private static long sumMax(int[] nums) {
        int len = nums.length;

        int[] prevBigger = new int[len];
        int[] nextBigger = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++){
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            prevBigger[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }
            nextBigger[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        stack.pop();
        long ans = 0L;
        for (int i = 0; i < len; i++){
            ans += (long) nums[i] * (i - prevBigger[i]) * (nextBigger[i] - i);
        }
        return ans;
    }

    private static long sumMin(int[] nums) {
        int len = nums.length;

        // 数据结构
        int[] prevSmaller = new int[len];
        int[] nextSmaller = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();

        // prevSmaller
        for (int i = 0; i < len; i++){
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }

            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        // nextSmaller
        for (int i = len - 1; i >= 0; i--){
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }

            nextSmaller[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        stack.clear();
        long ans = 0L;
        for (int i = 0; i < len; i++){
            ans += (long) nums[i] * (i - prevSmaller[i]) * (nextSmaller[i] - i);
        }

        return ans;
    }

//    public static long subArrayRanges(int[] nums) {
//        int len = nums.length;
//        long res = 0;
//        for (int i = 0; i < len; i++){
//            int max = nums[i], min = nums[i];
//            for (int j = i; j < len; j++){
//                max = Math.max(max, nums[j]);
//                min = Math.min(min, nums[j]);
//                res += (max - min);
//            }
//        }
//        return res;
//    }
}
