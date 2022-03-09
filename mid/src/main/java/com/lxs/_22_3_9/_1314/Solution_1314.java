package com.lxs._22_3_9._1314;

public class Solution_1314 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        int[][] res = matrixBlockSum(mat, k);
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + mat[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 左上角坐标
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);

                // 右下角坐标
                int r2 = Math.min(i + k, m - 1);
                int c2 = Math.min(j + k, n - 1);

                res[i][j] = dp[r2 + 1][c2 + 1] - dp[r1][c2 + 1] - dp[r2 + 1][c1] + dp[r1][c1];
            }
        }
        return res;
    }
}
