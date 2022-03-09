package com.lxs._155;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

    push(x) —— 将元素 x 推入栈中。
    pop()—— 删除栈顶的元素。
    top()—— 获取栈顶元素。
    getMin() —— 检索栈中的最小元素。

 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_155 {
    public static void main(String[] args) {
        Solution_155 solution_155 = new Solution_155();
        solution_155.push(-2);
        solution_155.push(0);
        solution_155.push(-3);
        solution_155.getMin();
        solution_155.pop();
        solution_155.top();
        solution_155.getMin();
    }
    public Queue queue;
    public Queue minQueue;
    public int minVal = Integer.MAX_VALUE;
    public Solution_155() {
        queue = new LinkedList();
        minQueue = new LinkedList();
        minQueue.add(minVal);
    }

    public void push(int val) {
        queue.offer(val);
        minQueue.offer(Math.min((int)minQueue.peek(), val));
    }

    public void pop() {
        queue.poll();
        minQueue.poll();
    }

    public int top() {
        return (int) queue.peek();
    }

    public int getMin() {
        return minVal;
    }



//    public int[] stack;
//    public int key = -1;
//    public int minVal;
//    public int Size = 10;
//
//    public Solution_155() {
//        stack = new int[Size];
//    }
//
//    public void push(int val) {
//        if (key >= Size - 1){
//            Size *= 2;
//            stack = Arrays.copyOf(stack, Size);
//        }
//        stack[++key] = val;
//    }
//
//    public void pop() {
//        key--;
//    }
//
//    public int top() {
//        return stack[key];
//    }
//
//    public int getMin() {
//        minVal = Integer.MAX_VALUE;
//        for (int i = key; i >= 0; i--){
//            if (stack[i] < minVal){
//                minVal = stack[i];
//            }
//        }
//        return minVal;
//    }
}
