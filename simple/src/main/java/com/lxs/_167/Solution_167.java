package com.lxs._167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_167 {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] result = twoSum(array, 9);

        System.out.println(Arrays.toString(result));


    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }

        throw new IllegalArgumentException("No two sum solution!");
    }
}
