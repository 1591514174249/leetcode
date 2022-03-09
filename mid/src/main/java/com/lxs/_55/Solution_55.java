package com.lxs._55;

public class Solution_55 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        boolean result = canJump(nums);
        System.out.println(result);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxTan = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i <= maxTan){
                maxTan = Math.max(maxTan, nums[i] + i);

                if (maxTan >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
