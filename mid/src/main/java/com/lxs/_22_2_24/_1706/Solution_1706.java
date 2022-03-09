package com.lxs._22_2_24._1706;

import java.util.Arrays;

/**
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 *
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 *
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。
 * 如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 *
 * 返回一个大小为 n 的数组 answer ，
 * 其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 */

public class Solution_1706 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        int[] ans = findBall(grid);
        System.out.println(Arrays.toString(ans));

        String s = "abc";
        s = s.substring(0,1);
        System.out.println(s);
    }

    public static int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            int col = i; // 球的初始队列
            for (int[] row : grid) {
                int dir = row[col];
                col += dir; // 移动球
                if (col < 0 || col == n || row[col] != dir) {
                    // 前两个判断是否到达边界，后一个判断是否在V字中间
                    col = -1;
                    break;
                }
            }
            if (col >= 0) {
                ans[i] = col;
            }
        }
        return ans;
    }



    /*
    public static int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = findExit(grid, 0, i);
        }
        return ans;
    }

    private static int findExit(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // exit
        if (i == m) {
            return j;
        }

        // recur
        if (grid[i][j] == 1) {
            if (j == n - 1 || grid[i][j + 1] == -1) {
                return -1;
            }
            return findExit(grid, i + 1, j + 1);
        } else {
            if (j == 0 || grid[i][j - 1] == 1) {
                return -1;
            }
            return findExit(grid, i + 1, j - 1);
        }
    }

     */
}
