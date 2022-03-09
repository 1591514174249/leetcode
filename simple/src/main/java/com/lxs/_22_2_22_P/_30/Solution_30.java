package com.lxs._22_2_22_P._30;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Solution_30 {
    private Deque stack;
    private Deque MStack;
    public static void main(String[] args) {
        Solution_30 solution_30 = new Solution_30();
        solution_30.push(46);
        solution_30.push(46);
        solution_30.push(47);
        solution_30.top();
        solution_30.pop();
        solution_30.min();
        solution_30.pop();
        solution_30.min();
        solution_30.pop();
        solution_30.push(47);
        solution_30.top();
        solution_30.min();
        solution_30.push(48);
        solution_30.top();
        solution_30.min();
        solution_30.pop();
        solution_30.min();

    }
    public Solution_30() {
        stack = new LinkedList<Integer>();
        MStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if (MStack.isEmpty()){
            MStack.push(x);
        } else if ((int)MStack.peek() >= x){
            MStack.push(x);
        }
    }

    public void pop() {
        int ans = (int)stack.pop();
        if ((int)MStack.peek() == ans){
            MStack.pop();
        }
    }

    public int top() {
        return (int)stack.peek();
    }

    public int min() {
        return (int)MStack.peek();
    }
}
