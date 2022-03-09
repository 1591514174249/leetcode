package com.lxs._1567;
/*
    给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。

    一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。

    请你返回乘积为正数的最长子数组长度。

 */

public class Solution_1567 {

    /*
    子数组乘积为正数，即要求该段子数组中没有0且负数的个数为偶数，这样我们可以用三个变量：
        pos:该段正数个数
        neg:负数个数
        first:第一个负数出现的下标，初始化 -1

        来记录需要的数量，然后对数组进行遍历：
        1.如果当前neg % 2 = 0，说明该段组数组的所有元素相乘为正，
        那么ans = max(ans, pos + neg)。
        2.如果当前neg % 2 != 0，我们可以贪心的进行选取组数组，只要去掉该段字数组的一个负数便可以使负数个数为偶数，
        即乘积为正，这时，即从第一个负数开始，后面的位置到当前位置所有数的乘积可以为正，
        此时:ans = max(ans, 当前位置下标 - fisrt).
        3.如果当前数为0，则将所有标记初始化，因为0不可能包含在任何字数组中，是使得乘积为正。
     */
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        // 负、正数个数 第一个负数出现的位置
        int neg = 0, pos = 0, fisrt = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // 遇到0所有标记初始化
                pos = 0;
                neg = 0;
                fisrt = -1;
            } else if (nums[i] > 0) {
                pos++;
            } else {
                // 记录该段第一个负数出现的位置
                if (fisrt == -1) {
                    fisrt = i;
                }
                neg++;
            }
            if (neg % 2 == 0) {
                // 该段所有数乘积为正
                ans = Math.max(ans, pos + neg);
            } else {
                // 从第一个负数出现的位置后面到当前位置的乘积为正
                ans = Math.max(ans, i - fisrt);
            }
        }
        return ans;
    }
}
