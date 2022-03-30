package com.lxs._22_3_30._1606;

import java.util.*;

public class Solution_1606 {
    public static void main(String[] args) {
        int[] arrival = {1, 2, 3, 4, 5};
        int[] load = {5, 2, 3, 3, 3};
        Solution_1606 s = new Solution_1606();
        List<Integer> res = s.busiestServers(3, arrival, load);
        System.out.println(res.toString());
    }


    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // 维护空闲的服务器
        TreeSet<Integer> available = initAvailable(k);
        // 存放第 i 台服务器使用个数
        int[] count = new int[k];
        // 维护每台服务器结束工作的时间
        PriorityQueue<int[]> busy = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int len = arrival.length;
        for (int i = 0; i < len; i++) {
            int curTime = arrival[i];

            // maintain busy (-> available)
            while (!busy.isEmpty() && busy.peek()[0] <= curTime) {
                available.add(busy.poll()[1]);
            }
            // find server (maintain busy, available, count)
            if (available.isEmpty()) continue;

            // 用于查找大于或等于参数列表中给定元素的元素。
            Integer server = available.ceiling(i % k);

            // 如果找不到，那么直接取 available 中的第一个元素即可，即从头开始
            if (server == null) server = available.first();

            available.remove(server);
            busy.offer(new int[]{curTime + load[i], server});
            count[server]++;
        }

        return findAns(count);
    }

    public TreeSet<Integer> initAvailable(int k) {
        TreeSet<Integer> ans = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            ans.add(i);
        }
        return ans;
    }

    public List<Integer> findAns(int[] count) {
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                ans.add(i);
            } else if (max < count[i]) {
                max = count[i];
                ans = new ArrayList<>(Arrays.asList(i));
            }
        }
        return ans;
    }

}
