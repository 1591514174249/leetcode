package com.lxs._11;

public class Solution_11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(height);
        System.out.println(result);
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int weight = 0;
        while (left <= right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            weight = Math.max(temp, weight);
        }
        return weight;
    }
}
