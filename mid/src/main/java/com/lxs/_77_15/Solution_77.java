package com.lxs._77_15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_77 {

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        List<List<Integer>> res = combine(n, k);
        System.out.println(res);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k){
            return result;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, result);
        return result;
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> result) {
        // 递归终止的条件是 ： path的长度等于 k
        if (path.size() == k){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        // 遍历可能的所有的搜索起点
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            // 向路径变量中添加一个数
            path.addLast(i);
            dfs(n, k, i + 1, path, result);
            path.removeLast();
        }
    }
}
