package com.lxs._22_2_28;

import java.util.Queue;

public class Solution_918 {
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        int res = maxSubarraySumCircular(nums);
        System.out.println(res);
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        int sum = 0;
        int slow = -1;
        int fast = 0;
        while (slow < fast % len) {
            if (sum > 0) {
                sum += nums[fast];
                fast++;
            } else {
                sum = nums[fast];
                slow++;
                fast++;
            }
            if (res < sum){
                res = sum;
                slow++;
            }
        }

        return res;
    }
}
