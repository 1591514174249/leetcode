package com.lxs._22_3_15._72;

import java.util.ArrayList;
import java.util.List;

public class Solution_72 {
    public static void main(String[] args) {
        String word1 = "ace";
        String word2 = "abcde";
        int res = minDistance(word1, word2);
        System.out.println(res);
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++){
            dp[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
