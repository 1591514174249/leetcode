package com.lxs._189;

import java.util.Arrays;

public class Solution_189 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }


    public static void rotate(int[] num, int k) {
        int len = num.length;
        int[] arr = new int[len];
        for (int j = 0; j < len; j++) {
            arr[(j + k) % len] = num[j];
        }
        System.arraycopy(arr, 0, num, 0, len);
    }
}
