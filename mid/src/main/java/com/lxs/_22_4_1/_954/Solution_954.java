package com.lxs._22_4_1._954;

import java.util.TreeMap;

public class Solution_954 {
    public static void main(String[] args) {
        int[] arr = {-1, -3, -2, -4, 1, 5, 3};
        TreeMap<Integer, Integer> valToCnt = new TreeMap<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });
        for (int val : arr) {
            valToCnt.put(val, valToCnt.getOrDefault(val, 0) + 1);
        }

        for (int val : valToCnt.keySet()) {
            System.out.println(val + "," + valToCnt.get(val));
        }
    }


    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> valToCnt = getValToCnt(arr);

        for (int val : valToCnt.keySet()) {
            int doubleVal = val * 2;

            if (valToCnt.get(val) == 0) continue;

            if (valToCnt.getOrDefault(doubleVal, 0) < valToCnt.get(val)) return false;

            valToCnt.put(doubleVal, valToCnt.get(doubleVal) - valToCnt.get(val));
        }

        return true;
    }

    private TreeMap<Integer, Integer> getValToCnt(int[] arr) {
        TreeMap<Integer, Integer> res = new TreeMap<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });
        for (int i = 0; i < arr.length; i++) {
            res.put(arr[i], res.getOrDefault(arr[i], 0) + 1);
        }
        return res;
    }

}
