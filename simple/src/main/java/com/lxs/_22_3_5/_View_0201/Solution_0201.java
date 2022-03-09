package com.lxs._22_3_5._View_0201;

import java.util.*;

public class Solution_0201 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        ListNode head = removeDuplicateNodes(node1);
        Deque<Integer> queue = new ArrayDeque<>();
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;

        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode node = head;
        while (node.next != null) {
            if (!set.add(node.next.val)){
                node.next = node.next.next;
            } else {
                node = node.next;
            }
            if (node == null) break;
        }
        return head;
    }
}
