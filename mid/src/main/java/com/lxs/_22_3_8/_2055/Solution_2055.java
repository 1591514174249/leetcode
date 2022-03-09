package com.lxs._22_3_8._2055;

public class Solution_2055 {
    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] queries = {{2, 5}, {5, 9}};
        int[] res = platesBetweenCandles(s, queries);

        int[] ans = new int[2];
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] prevCandleIdx = getPrevCandleIdx(s);
        int[] nextCandleIdx = getNextCandleIdx(s);
        int[] plateCnt = getPlateCnt(s);

        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int formerIdx = nextCandleIdx[queries[i][0]];
            int latterIdx = prevCandleIdx[queries[i][1]];
            if (formerIdx == -1 || latterIdx == -1 || formerIdx > latterIdx) {
                ans[i] = 0;
            } else {
                ans[i] = plateCnt[latterIdx] - plateCnt[formerIdx];
            }
        }
        return ans;
    }

    private static int[] getPlateCnt(String s) {
        int len = s.length();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] += i == 0 ? 0 : ans[i - 1];
            if (s.charAt(i) == '*') ans[i]++;
        }
        return ans;
    }

    private static int[] getNextCandleIdx(String s) {
        int len = s.length();
        int[] ans = new int[len];
        int nextIdx = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                nextIdx = i;
            }
            ans[i] = nextIdx;
        }
        return ans;
    }

    private static int[] getPrevCandleIdx(String s) {
        int len = s.length();
        int[] ans = new int[len];
        int prevIdx = -1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '|') {
                prevIdx = i;
            }
            ans[i] = prevIdx;
        }
        return ans;
    }
}
