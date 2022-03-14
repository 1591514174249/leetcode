package com.lxs._22_3_14._392;

public class Solution_392 {
    public static void main(String[] args) {
        String s = "aaaaaa";
        String t = "bbaaaa";
        boolean flag = isSubsequence(s, t);
        System.out.println(flag);
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else {
                j++;
            }
            k = i;
        }
        if (k == s.length()) return true;
        else return false;
    }
}
