package com.lxs._22_3_3._1678;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_1678 {
    public static void main(String[] args) {
        String str = "G()(al)";
        String res = interpret(str);
        System.out.println(res);
    }
    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int n = command.length();
        int i = 0;
        while (i < n){
            if (command.charAt(i) == 'G'){
                sb.append('G');
                i++;
            } else if (command.charAt(i) == '('){
                int j = 1;
                while (command.charAt(i + j) != ')'){
                    sb.append(command.charAt(i + j));
                    j++;
                }
                if (j == 1) {
                    sb.append('o');
                }
                i = i + j + 1;
            }
        }
        return sb.toString();
    }
}
