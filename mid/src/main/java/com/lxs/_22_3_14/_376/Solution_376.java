package com.lxs._22_3_14._376;

import java.util.Arrays;

public class Solution_376 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        int res = wiggleMaxLength(nums);
        System.out.println(res);
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        if (nums.length == 2 && nums[0] != nums[1]) return 2;

        int len = nums.length;
        int[] sub = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            sub[i] = nums[i + 1] - nums[i];
        }

        int[] dp = new int[len - 1];
        Arrays.fill(dp, 1);
        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < len - 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (sub[i] * sub[j] < 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    break;
                } else {
                    dp[i] = dp[j];
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen + 1;
    }
}
