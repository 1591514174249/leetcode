package com.lxs._22_3_8._Offer13;

public class Solution_13 {
    private static int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int ans = movingCount(2, 3, 1);
        System.out.println(ans);
    }

    public static int movingCount(int m, int n, int k) {
        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        int res = dfs(0, 0, m, n, k, visited);
        return res;
    }

    private static int dfs(int row, int col, int m, int n, int k, boolean[][] visited) {
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || (row / 10 + row % 10 + col / 10 + col % 10) > k)
            return 0;


        visited[row][col] = true;
        return dfs(row + 1, col, m, n, k, visited) + dfs(row - 1, col, m, n, k, visited) + dfs(row, col + 1, m, n, k, visited) + dfs(row, col - 1, m, n, k, visited) + 1;
    }
}
