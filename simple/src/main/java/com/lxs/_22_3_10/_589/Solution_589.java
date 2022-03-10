package com.lxs._22_3_10._589;

import java.util.*;

public class Solution_589 {
    private static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        List<Node> list1 = new ArrayList<>();
        list1.add(node3);
        list1.add(node2);
        list1.add(node4);
        node1.children = list1;
        List<Node> list2 = new ArrayList<>();
        list2.add(node5);
        list2.add(node6);
        node3.children = list2;

        List<Integer> res = preOrder(node1);
        System.out.println(res.toString());
    }

    public static List<Integer> preOrder(Node root) {
        List<Integer> res = new ArrayList<>();

        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) return res;
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            res.add(node.val);
            if (node.children != null) {
                Collections.reverse(node.children);
                for (Node ch : node.children) {
                    stack.addLast(ch);
                }
            }
        }
        return res;
    }
}
