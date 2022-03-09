package com.lxs._22_3_9._Offer_45;

public class Solution_45 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        String res = minNumber(nums);
        System.out.println(res);
    }

    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        quickSort(strs, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void quickSort(String[] strs, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        String povid = strs[i];
        while (i < j) {
            while ((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0 && i < j) {
                i++;
            }
            if (i < j) {
                String temp = strs[i];
                strs[i] = strs[j];
                strs[j] = temp;
            }
        }
        strs[left] = strs[i];
        strs[i] = povid;

        quickSort(strs, left, i - 1);
        quickSort(strs, i + 1, right);
    }
}
