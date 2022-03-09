package com.lxs._4;

import java.util.Arrays;

public class Solution_4 {
    public static void main(String[] args) {
        double[] nums1 = {1, 2, 3, 4, 5};
        double[] nums2 = {0, 2, 4, 7, 8};

        double result = findMedianSortedArrays1(nums1, nums2);
        System.out.println(result);
    }

    // 暴力解法
    public static double findMedianSortedArrays1(double[] nums1, double[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        double[] num = new double[n1 + n2];
        for (int i = 0; i < n1; i++) {
            num[i] = nums1[i];
        }
        for (int i = n1; i < n1 + n2; i++) {
            num[i] = nums2[i - n1];
        }

        Arrays.sort(num);

        if ((n1 + n2) % 2 == 0) {
            return (num[(n1 + n2) / 2 - 1] + num[(n1 + n2) / 2 + 1]) / 2;
        } else {
            return num[(n1 + n2) / 2];
        }
    }

    // 双指针
//    public static double findMedianSortedArrays2(double[] nums1, double[] nums2) {
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//
//        int l1 = 0;
//        int l2 = 0;
//        int count = 0;
//        while (l1 < n1 && l2 < n2) {
//            if ((n1 + n2) % 2 == 0){
//                if (nums1[l1] <= nums2[l2]) {
//                    l1++;
//                    count++;
//                } else {
//                    l2++;
//                    count++;
//                }
//            } else {
//
//            }
//
//        }
//    }

    // 第 k 小数
    public int getKthElement(int[] nums1, int[] nums2, int k){
        int l1 = nums1.length, l2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true){
            // 边界情况
            if (index1 == l1){
                return nums2[index2 + k - 1];
            }
            if (index2 == l2){
                return nums1[index1 + k - 1];
            }
            if (k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, l1) - 1;
            int newIndex2 = Math.min(index2 + half, l2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2){
                k -= (newIndex1 - index1 + 1);  // newIndex1 - index1 + 1 相当于 half
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
