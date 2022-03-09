package com.lxs._22_2_25_P._746;

import java.util.*;

public class Solution_746 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();


    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int cur = 0, pre = 0;
        for (int i = 0; i <= len; i++) {
            int next = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
            pre = cur;
            cur = next;
        }
        return cur;
    }


    /*
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
     */
}
