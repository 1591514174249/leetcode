package com.lxs._22_2_28._45;

import java.util.Arrays;
import java.util.Stack;

public class Solution_45 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        int res = jump(nums);
        int[][] array = {{0, 0}, {0, 1}, {0, -1}};
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int reach = 0;
        int nextReach = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            nextReach = Math.max(i + nums[i], nextReach);
            if (nextReach >= nums.length - 1) return (step + 1);

            if (i == reach) {
                step++;
                reach = nextReach;
            }
        }
        return step;
    }
}
