package com.lxs._22_3_15._2044;

public class Solution_2044 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        int res = countMaxOrSubsets(nums);
        System.out.println(res);
    }

    public static int countMaxOrSubsets(int[] nums) {
        if (nums.length == 1) return 1;

        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxVal |= nums[i];
        }

        return dfs(0, nums, 0, maxVal);
    }

    private static int dfs(int curIndex, int[] nums, int curValue, int maxVal) {
        if (curIndex == nums.length) return curValue == maxVal ? 1 : 0;

        return dfs(curIndex + 1, nums, curValue, maxVal) +
                dfs(curIndex + 1, nums, curValue | nums[curIndex], maxVal);
    }
}
