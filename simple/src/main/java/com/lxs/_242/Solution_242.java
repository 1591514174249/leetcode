package com.lxs._242;
/*
        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

        注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。

 */
public class Solution_242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
        int[] ctn1 = new int[26];
        int[] ctn2 = new int[26];

        int len1 = s.length();
        int len2 = t.length();

        if(len1 != len2){
            return false;
        }

        for (int i = 0; i < len1; i++) {
            char ch1 = s.charAt(i);
            ctn1[ch1 - 'a']++;

            char ch2 = t.charAt(i);
            ctn2[ch2 - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            if (ctn1[i] != ctn2[i]){
                return false;
            }
        }
        return true;
    }
}
