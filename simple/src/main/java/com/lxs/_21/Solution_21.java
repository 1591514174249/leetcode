package com.lxs._21;
/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

public class Solution_21 {
    public static void main(String[] args) {
        ListNode list13 = new ListNode(4);
        ListNode list12 = new ListNode(2, list13);
        ListNode list1 = new ListNode(1, list12);

        ListNode list23 = new ListNode(4);
        ListNode list22 = new ListNode(3, list23);
        ListNode list2 = new ListNode(1, list22);

        ListNode result = mergeTwoLists(list1, list2);
        System.out.println(result);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);

        ListNode newList = result;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                newList.next = list2;
                list2 = list2.next;
            } else {
                newList.next = list1;
                list1 = list1.next;
            }

            newList = newList.next;
        }
        newList.next = list1 == null ? list2 : list1;

        return result.next;
    }

    public static ListNode mergeTwoList2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
