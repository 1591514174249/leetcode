package com.lxs._22_2_23_P._Offer07;

public class Solution_07 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode res = buildTree(preorder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                TreeNode root = new TreeNode(preorder[0]);
                if (i != 0) {
                    int[] linorder = new int[i];
                    int[] lpreorder = new int[i];
                    for (int j = 0; j < i; j++) {
                        linorder[j] = inorder[j];
                        lpreorder[j] = preorder[j + 1]; // 前序遍历, 第一个节点是根节点
                    }
                    root.left = buildTree(lpreorder, linorder);
                }
                if (i != inorder.length - 1) {
                    int len = inorder.length;
                    int[] linorder = new int[len - i - 1];
                    int[] lpreorder = new int[len - i - 1];
                    for (int j = i + 1; j < len; j++) {
                        linorder[j - i - 1] = inorder[j];
                        lpreorder[j - i - 1] = preorder[j];
                    }
                    root.right = buildTree(lpreorder, linorder);
                }
                return root;
            }
        }
        return null;
    }
}
