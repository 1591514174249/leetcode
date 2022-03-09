package com.lxs._918;

/*
    环形子数组的最大和

给定一个由整数数组 A表示的环形数组 C，求 C的非空子数组的最大可能和。

在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length时C[i] = A[i]，
且当i >= 0时C[i+A.length] = C[i]）

此外，子数组最多只能包含固定缓冲区 A中的每个元素一次。（形式上，对于子数组C[i], C[i+1], ..., C[j]，
不存在i <= k1, k2 <= j其中k1 % A.length= k2 % A.length）

 */

public class Solution_918 {
    public static void main(String[] args) {
        int[] array = {-2};
        int maxVal = maxSubarraySumCircular(array);
        System.out.println(maxVal);
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxAns = dp[0];
        int minAns = dp[0];
        // 求最大数组和
        for (int i = 1; i < len; i++) {
//            if (dp[i - 1] > 0) {
//                dp[i] = dp[i - 1] + nums[i];
//            } else {
//                dp[i] = nums[i];
//            }
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxAns = Math.max(maxAns, dp[i]);
        }
        // 求最小数组和
        for (int i = 1; i < len; i++) {
//            if (dp[i - 1] <= 0) {
//                dp[i] = dp[i - 1] + nums[i];
//            } else {
//                dp[i] = nums[i];
//            }
            dp[i] = Math.min(dp[i - 1] + nums[i], nums[i]);
            minAns = Math.min(minAns, dp[i]);
            if (minAns == sum) {
                minAns = maxAns;
            }
        }

        return Math.max(maxAns, sum - minAns);
    }
}
