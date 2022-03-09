package com.lxs._22_2_22_P._09;

import java.util.Deque;
import java.util.LinkedList;

/***
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 */
public class Solution_09 {
    private Deque deque1, deque2;

    public static void main(String[] args) {
        Solution_09 solution_09 = new Solution_09();
        solution_09.appendTail(3);
        solution_09.appendTail(4);
        solution_09.appendTail(5);
        int res1 = solution_09.deleteHead();
        solution_09.appendTail(6);
        int res2 = solution_09.deleteHead();
    }

    public Solution_09() {
        deque1 = new LinkedList<Integer>();
        deque2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        deque1.push(value);
    }

    public int deleteHead() {
        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                deque2.push(deque1.pop());
            }
        }
        if (deque2.isEmpty()){
            return -1;
        } else {
            int ans = (int)deque2.pop();
            return ans;
        }
    }
}
