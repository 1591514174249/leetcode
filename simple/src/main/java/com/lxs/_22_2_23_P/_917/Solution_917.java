package com.lxs._22_2_23_P._917;

public class Solution_917 {
    public static void main(String[] args) {
        String s = "ab-cd";
        String res = reverseOnlyLetters(s);
        System.out.println(res);
    }

    public static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            while (left < right && (chars[left] < 65 || chars[left] > 90) && (chars[left] < 97 || chars[left] > 122)){
                left++;
            }
            while (left < right && (chars[right] < 65 || chars[right] > 90) && (chars[right] < 97 || chars[right] > 122)){
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
