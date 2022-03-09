package com.lxs._22_2_25.Offer_53;

public class Solution_53 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int res = search(nums, 8);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int count = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            // 确定右边界
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        for (; l < n && target == nums[l++];) {
            count++;
        }
        return count;
    }
}
