package com.lxs._22_2_22_P.InterView01_03;

public class Solution_01_03 {
    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        String res = replaceSpaces(s, 13);
        System.out.println(res);
    }

    public static String replaceSpaces(String S, int length) {
        char[] ch = S.toCharArray();
        int len = ch.length - 1;

        for (int i = length - 1; i >= 0; i--) {
            if (ch[i] == ' '){
                ch[len--] = '0';
                ch[len--] = '2';
                ch[len--] = '%';
            } else {
                ch[len--] = ch[i];
            }
        }
        return new String(ch, len + 1, ch.length - len - 1);
    }
}
