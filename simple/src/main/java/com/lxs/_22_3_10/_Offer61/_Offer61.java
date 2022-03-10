package com.lxs._22_3_10._Offer61;

import java.util.Arrays;

public class _Offer61 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 3, 5};
        boolean res = isStraight(nums);
        System.out.println(res);
    }

    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCnt = 0;
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == 0){
                zeroCnt++;
            } else {
                if (nums[i] == nums[i + 1]) return false;
                if (nums[i] + 1 != nums[i + 1]) diff += nums[i + 1] - nums[i] - 1;
            }
        }
        return zeroCnt >= diff;
    }
}
