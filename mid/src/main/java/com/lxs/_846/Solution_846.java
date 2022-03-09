package com.lxs._846;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
    Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，
    并且由 groupSize 张连续的牌组成。

    给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。
    如果她可能重新排列这些牌，返回 true ；否则，返回 false 。

 */
public class Solution_846 {
    public static void main(String[] args) {
        int[] hard = {1, 1, 2, 2, 3, 3};
        boolean result = isNStraightHand(hard, 3);
        System.out.println(result);
    }

    public static boolean isNStraightHand(int[] hard, int groupSize) {
        int len = hard.length;
        if (len % groupSize != 0) {
            return false;
        }

        Arrays.sort(hard);
        Map<Integer, Integer> ctn = new HashMap<>();
        for (int val : hard) {
            ctn.put(val, ctn.getOrDefault(val, 0) + 1);
        }
        for (int val : hard) {
            if (!ctn.containsKey(val)) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int num = val + i;
                if (!ctn.containsKey(num)) {
                    return false;
                }
                ctn.put(num, ctn.get(num) - 1);
                if (ctn.get(num) == 0) {
                    ctn.remove(num);
                }
            }
        }
        return true;
    }
}
