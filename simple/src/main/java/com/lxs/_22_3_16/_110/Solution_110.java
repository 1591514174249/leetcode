package com.lxs._22_3_16._110;

import java.util.LinkedList;

public class Solution_110 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);

        node1.left = node2;
        node2.left = node4;
        node4.left = node6;
        node1.right = node3;
        node3.right = node5;
        node5.right = node7;

        boolean flag = isBalanced(node1);
        System.out.println(flag);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            int left = dfs(node.left);
            int right = dfs(node.right);

            if (Math.abs(right - left) > 1) return false;

            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
        }

        return true;
    }

    public static int dfs(TreeNode node) {
        if (node == null) return 1;

        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}
