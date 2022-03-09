package com.lxs._206;

public class Solution_206 {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);


        ListNode result = reverseList1(node1);
        System.out.println(result);
    }


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 1. 保存临时变量
            ListNode next = curr.next;
            // 2. 改变链表
            curr.next = prev;
            // 3. 迭代当前指向
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
