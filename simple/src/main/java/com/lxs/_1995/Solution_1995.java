package com.lxs._1995;

import java.util.HashMap;
import java.util.Map;

public class Solution_1995 {
    public static void main(String[] args) {

    }

    // 直接枚举
    public static int countQuadruplets(int[] nums) {
        int count = 0;
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    for (int d = c + 1; d < nums.length; d++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // 哈希表
    public static int countQuadruplets1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int c = n - 2; c >= 2; c--) {
            cnt.put(nums[c + 1], cnt.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += cnt.get(nums[a] + nums[b] + nums[c]);
                }
            }
        }
        return ans;
    }

    // 哈希表
    public static int countQuadruplets2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int b = n - 3; b >= 1; b++) {
            for (int d = b + 2; d < n; d++) {
                cnt.put(nums[d] - nums[b + 1], cnt.getOrDefault(nums[d] - nums[b - 1], 0) + 1);
            }
            for (int a = 0; a < b; a++) {
                ans += cnt.getOrDefault(nums[a] + nums[b],0);
            }
        }
        return ans;
    }
}
