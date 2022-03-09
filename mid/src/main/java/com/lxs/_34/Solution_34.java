
/*
在排序数组中查找元素的第一个和最后一个位置
 */
package com.lxs._34;

import java.util.Arrays;

public class Solution_34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums, 6);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0){
            return new int[]{-1, -1};
        }
        if (n == 1){
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int left = 0;
        int right = n - 1;
        int l = 0;
        int r = 0;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                l = mid - 1;
                r = mid + 1;
                while (l >= 0 && nums[l] == target){
                    l--;
                }
                while (r < n && nums[r] == target){
                    r++;
                }
                return new int[]{l + 1, r - 1};
            } else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
