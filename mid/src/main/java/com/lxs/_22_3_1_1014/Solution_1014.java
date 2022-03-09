package com.lxs._22_3_1_1014;

public class Solution_1014 {
    public static void main(String[] args) {
        int[] values = {2, 2, 2};
        int res = maxScoreSightseeingPair(values);
    }

    public static int maxScoreSightseeingPair(int[] values) {
        int maxSeen = 0;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 1; j < values.length; j++) {
                maxSeen = Math.max(maxSeen, values[i] + values[j] + i - j);
            }
        }
        return maxSeen;
    }
}
