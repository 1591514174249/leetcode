package com.lxs._22_3_8._Offer_58;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_58 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String res = reverseWords(s);
        System.out.println(res);
    }
    public static String reverseWords(String s) {
        String str = "";
        Deque<String> queue = new ArrayDeque<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            while(i < n && s.charAt(i) != ' '){
                str += s.charAt(i);
                i++;
            }
            if (str != ""){
                queue.add(str);
            }
            str = "";
            i++;
        }
        String res = "";
        int size = queue.size();
        for (int j = 0; j < size; j++){
            res += queue.pollLast();
            if (j != size - 1) res += " ";
        }

        return res;
    }
}
