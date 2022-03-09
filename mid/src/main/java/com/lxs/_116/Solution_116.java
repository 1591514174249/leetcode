package com.lxs._116;

import java.util.LinkedList;
import java.util.Queue;

/*
    给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
    则将 next 指针设置为 NULL。

    初始状态下，所有next 指针都被设置为 NULL。
 */

public class Solution_116 {


    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // 初始化队列，并将第一层结点介入队列中
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的 while 指的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有结点
            for (int i = 0; i < size; i++) {
                // poll() 移除队列头的元素并且返回，如果队列为空则返回null
                Node node = queue.poll();
                // 连接
                if (i < size - 1) {
                    // peek() 返回队列头元素但不移除，如果队列为空，则返回null
                    node.next = queue.peek();
                }

                // 拓展下一层结点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

}
