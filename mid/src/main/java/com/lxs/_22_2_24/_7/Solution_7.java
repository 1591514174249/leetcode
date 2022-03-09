package com.lxs._22_2_24._7;

public class Solution_7 {
    public static void main(String[] args) {
        int res = reverse(123);
        System.out.println(res);
    }

    public static int reverse(int x) {
        long n = 0;
        while (x != 0){
            n = n * 10 + x % 10;
            x /= 10;
        }
        if (n > (1 << 31) - 1 || n < -(1 >> 31)){
            return 0;
        }
        return (int)n;
    }
}
