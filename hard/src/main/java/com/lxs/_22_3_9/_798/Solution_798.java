package com.lxs._22_3_9._798;

public class Solution_798 {
    public static void main(String[] args) {

    }

    public static int bestRotation(int[] nums) {
        int[] diff = getDiff(nums);

        int ans = 0;
        int max = diff[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > max) {
                max = diff[i];
                ans = i;
            }
        }
        return ans;
    }

    private static int[] getDiff(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++){

            ans[(i + 1 + len - nums[i]) % len]--;
            ans[(i + 1) % len]++;

            if (nums[i] <= i){
                ans[0]++;
            }
        }
        return ans;
    }
}
