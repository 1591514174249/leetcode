package com.lxs._22_2_28._55;

public class Solution_55 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 0, 1};
        boolean flag = canJump(nums);
        System.out.println(flag);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        for (int i = nums.length - 2; i != -1; i--){
            if (nums[i] == 0){
                int j = 0;
                for (j = i - 1; j != -1; j--){
                    if (nums[j] > i - j) break;
                }
                if (j == -1) return false;
            }
        }
        return true;
    }
}
