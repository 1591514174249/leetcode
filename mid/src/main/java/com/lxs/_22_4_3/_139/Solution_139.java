package com.lxs._22_4_3._139;

import java.util.LinkedList;
import java.util.List;

public class Solution_139 {
    public static void main(String[] args) {
        Solution_139 s139 = new Solution_139();
        String s = "leetcode";
        List<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");

        boolean flag = s139.wordBreak(s, list);
        System.out.println(flag);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (wordDict.contains(str) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }

}
