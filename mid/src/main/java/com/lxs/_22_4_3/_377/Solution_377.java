package com.lxs._22_4_3._377;

import java.util.*;

public class Solution_377 {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {4, 2, 1};
        int target = 4;
        Arrays.sort(nums);
        Solution_377 s = new Solution_377();
        int sum = s.combinationSum4(nums, target);
        System.out.println(sum);
    }

    public int combinationSum4(int[] nums, int target) {
        backTracking(nums, target);
        return res.size();
    }

    private void backTracking(int[] nums, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) continue;
            target -= nums[i];
            path.addLast(nums[i]);
            backTracking(nums, target);
            int temp = path.removeLast();
            target += temp;
        }

    }
}
