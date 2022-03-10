package com.lxs._22_3_10._63;

public class Solution_63 {
    public static void main(String[] args) {
        int[][] matix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int res = uniquePathWithObstacles(matix);
        System.out.println(res);
    }

    public static int uniquePathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            else dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            if (obstacleGrid[0][j] == 1) break;
            else dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
