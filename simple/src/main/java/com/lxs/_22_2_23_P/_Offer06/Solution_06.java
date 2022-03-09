package com.lxs._22_2_23_P._Offer06;

import com.lxs._21.ListNode;

import java.util.*;

public class Solution_06 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(1, node2);
        int[] res = reversePoint(node3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] reversePoint(ListNode head) {
        Deque stack = new ArrayDeque();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int len = stack.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = (int) stack.pop();
        }
        return res;
    }
}
