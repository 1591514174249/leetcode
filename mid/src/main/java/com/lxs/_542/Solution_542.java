package com.lxs._542;

/*
    给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，
    其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。

    两个相邻元素间的距离为 1 。

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_542 {
    public static void main(String[] args) {
        int[][] target = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = updateMatrix(target);

    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] dest = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();

        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];

            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k][0];
                int nj = j + dirs[k][1];
                if (ni >= 0 && ni < m && nj > 0 && nj < n && !seen[ni][nj]) {
                    dest[ni][nj] = dest[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return dest;
    }
}
