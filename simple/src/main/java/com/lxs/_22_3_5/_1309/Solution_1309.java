package com.lxs._22_3_5._1309;

public class Solution_1309 {
    public static void main(String[] args) {
        String s = "10#11#12";
        String res = freqAlphabets(s);
        System.out.println(res);
    }

    public static String freqAlphabets(String s) {
        if (s == null || s.length() == 0) return null;

        char[] chars = s.toCharArray();
        int n = chars.length;
        String ans = "";
        for (int i = 0; i < n;){
            if ((i + 2) < n && chars[i + 2] == '#') {
                int val = (chars[i] - '0') * 10 + (chars[i + 1] - '0') - 1;
                ans += "" + (char)(val + 'a');
                i += 3;
            } else {
                ans += "" + (chars[i] + 'a' - '1');
                i++;
            }
        }
        return ans;
    }
}
