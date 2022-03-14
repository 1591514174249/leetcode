package com.lxs._22_3_14._599;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_599 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        String[] res = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(res));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        int m = list1.length;
        int n = list2.length;
        List<String> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (list1[i].equals(list2[j])) {
                    if (list.size() == 0) {
                        list.add(list1[i]);
                        index = i + j;
                    } else if (i + j < index) {
                        list.removeAll(list);
                        list.add(list1[i]);
                    } else if (i + j == index) {
                        list.add(list1[i]);
                    }
                }
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
