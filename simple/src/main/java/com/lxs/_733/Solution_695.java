package com.lxs._733;
/*
给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

*/

public class Solution_695 {

    /*
        我们想知道网格中每个连通形状的面积，然后取最大值。

        如果我们在一个土地上，以 44 个方向探索与之相连的每一个土地（以及与这些土地相连的土地），那么探索过的土地总数将是该连通形状的面积。

        为了确保每个土地访问不超过一次，我们每次经过一块土地时，将这块土地的值置为 00。这样我们就不会多次访问同一土地。
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public static int dfs (int[][] grid, int i, int j){
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1){
            return 0;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        grid[i][j] = 0;
        int ans = 1;

        for (int k = 0; k < 4; k++){
            ans += dfs(grid, i + dx[k], j + dy[k]);
        }

        return ans;
    }
}
