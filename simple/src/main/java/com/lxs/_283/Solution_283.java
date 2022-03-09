package com.lxs._283;

import java.util.Arrays;

public class Solution_283 {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 12};
        moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = 0;
        int temp = 0;

        while (r < len){
            if (nums[r] != 0){
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
        }
    }
}
