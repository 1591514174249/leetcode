package com.lxs._22_2_23_P._125;

import java.util.ArrayList;
import java.util.List;

public class Solution_125 {
    public static void main(String[] args) {
        String s = "0P";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 97 && chars[i] <= 122)){
                list.add(chars[i]);
            }
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right){
            if (list.get(left) != list.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
