package com.lxs._22_3_10._33;

public class Solution_33 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int res = search(nums, 0);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int n = nums.length - 1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target < nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
