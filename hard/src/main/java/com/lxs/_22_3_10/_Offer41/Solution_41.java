package com.lxs._22_3_10._Offer41;

import java.util.PriorityQueue;

public class Solution_41 {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }


}

class MedianFinder {

    PriorityQueue<Integer> left;  // 大顶堆
    PriorityQueue<Integer> right; // 小顶堆

    public MedianFinder() {
        left = new PriorityQueue<>((x, y) -> y - x); // (x,y)->y-x 等同于 Collections.reverseOrder()
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if (left.size() + 1 < right.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if (right.size() > left.size()) return right.peek();
        return (double) (left.peek() + right.peek()) / 2;
    }


}
