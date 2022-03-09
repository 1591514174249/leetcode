package com.lxs._22_2_23_P.Offer_35;

public class Solution_35 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null){
            return head;
        }
        // 拷贝完之后，原链表 1->2->3 就变为1->1'->2->2'->3->3'
        for (Node node = head, copy = null; node != null; node = node.next.next) {
            copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
        }

        // 把拷贝链表的random属性添加上
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }

        // 分离拷贝节点和原节点
        Node newNode = head.next;
        for (Node node = head, temp = null; node != null && node.next != null;){
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }
        return newNode;
    }
}
