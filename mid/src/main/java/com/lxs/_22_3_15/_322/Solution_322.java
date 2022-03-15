package com.lxs._22_3_15._322;

import java.util.Arrays;

public class Solution_322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int res = coinChange(coins, 11);
        System.out.println(res);
    }

    public static int coinChange(int[] coins, int amount) {
        // 获取dp数组长度
        int[] dp = new int[amount + 1];

        // 数组初值
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
