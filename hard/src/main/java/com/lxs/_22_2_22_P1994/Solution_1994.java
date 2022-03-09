package com.lxs._22_2_22_P1994;

public class Solution_1994 {

    private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static int[] bads = {4, 9, 25};
    private static int MOD = 1000000007;
    // dp
    // 状态dp[i], i对应互不相同的质数的乘积
    // 转移, 考虑num中所有质因数是否被用过, 没有被用过 --> 更新使用状态和dp
    //                                     被用过 --> 跳过

    // bitmask 记录上述十个质因数是否被用过
    // bit 0/1, 0 : 没有被用过, 1 : 被用过
    // nums1, nums2 <-- getMask(nums1) & getMask(nums2) > 0 ? 有相同质因数 : 没有相同质因数
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int ans = numberOfGoodSubsets(nums);
        System.out.println(ans);
    }

    public static int numberOfGoodSubsets(int[] nums) {
        // cnt
        int[] cnt = count(nums);

        // dp
        long[] dp = new long[1 + ((1) << 10)];

        // 初始化
        dp[0] = 1L;

        // 转移
        for (int num = 2; num < 30; num++) {
            if (cnt[num] == 0 || isBadNum(num)) continue;

            // get mask
            int numMask = getMask(num);
            for (int prevMask = 0; prevMask < (1 << 10); prevMask++) {
                if ((prevMask & numMask) > 0) {
                    // 说明质因数相同, 无需更新dp
                    continue;
                }
                // update dp
                dp[prevMask | numMask] += dp[prevMask] * cnt[num];
                dp[prevMask | numMask] %= MOD;
            }
        }

        // 结果
        return getAns(dp, cnt);
    }

    private static int getAns(long[] dp, int[] cnt) {
        long ans = 0;
        for (int i = 0; i < (1 << 10); i++) {
            ans += dp[i];
            ans %= MOD;
        }
        ans += pow(2L, cnt[1]);
        ans %= MOD;

        return (int) ans;
    }

    private static long pow(long base, int k) {
        long ans = 1L;
        while (k > 0) {
            if (k % 2 == 1) {
                ans = (ans * base) % MOD;
            }
            base = (base * base) % MOD;
            k >>= 1;
        }
        return ans;
    }

    private static int getMask(int num) {
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            if (num % primes[i] == 0) {
                ans += (1 << i);
            }
        }
        return ans;
    }

    private static boolean isBadNum(int num) {
        for (int bad : bads) {
            if (num % bad == 0) {
                return true;
            }
        }
        return false;
    }

    private static int[] count(int[] nums) {
        int[] ans = new int[31];
        for (int n : nums) {
            ans[n]++;
        }
        return ans;
    }
}
