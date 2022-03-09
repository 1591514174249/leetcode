package com.lxs._22_2_25_P._191;

public class Solution_191 {
    public static void main(String[] args) {
        int n = -3;
        int ans = hammingWeight(n);
        System.out.println(ans);
    }

    // 算术右移 >>  ：舍弃最低位，高位用符号位填补;
    // 逻辑右移 >>> ：舍弃最低位，高位用 0 填补.
    public static int hammingWeight(int n) {
        int ans = 0;
        while (n != 0){
            ans += n & 1;
            n >>>= 1;
        }
        return ans;
    }
}
