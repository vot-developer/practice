package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
There are 'N' tasks, labeled from '0' to 'N-1'. Each task can have some prerequisite tasks which need to be completed 
before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a method to print all 
possible ordering of tasks meeting all prerequisites.
 */
public class AllTaskSchedulingOrders {

    public static List<List<Integer>> printOrders(int tasks, int[][] prerequisites) {
        Queue<List<Integer>> sortedOrders = new LinkedList<>();
        if (tasks <= 0)
            return new ArrayList<>(sortedOrders);
        sortedOrders.offer(new ArrayList<>());

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>(tasks);
        for (int i = 0; i < tasks; i++) {
            graph.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }

        for (int[] vs : prerequisites) {
            int v = vs[0];
            int w = vs[1];
            inDegree.put(w, inDegree.get(w) + 1);
            graph.get(v).add(w);
            graph.get(w).add(v);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < tasks; i++)
            if (inDegree.get(i) == 0)
                sources.offer(i);

        while (!sources.isEmpty()) {
            int size = sources.size();
            List<Integer> order = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Integer v = sources.poll();
                order.add(v);
                for (int w : graph.get(v)) {
                    inDegree.put(w, inDegree.get(w) - 1);
                    if (inDegree.get(w) == 0)
                        sources.offer(w);
                }
            }

            List<List<Integer>> permute = permute(order);
            int resultSize = sortedOrders.size();
            for (int r = 0; r < resultSize; r++) {
                List<Integer> sortedOrder = sortedOrders.poll();
                for (int i = 0; i < permute.size(); i++) {
                    List<Integer> result = new ArrayList<>(sortedOrder);
                    result.addAll(permute.get(i));
                    sortedOrders.offer(result);
                }
            }
        }

        return new ArrayList<>(sortedOrders);
    }

    private static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        for (int num : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> set = queue.poll();
                int setSize = set.size();
                for (int j = 0; j <= setSize; j++) {
                    List<Integer> perm = new ArrayList<>(set);
                    perm.add(j, num);
                    if (perm.size() == nums.size())
                        result.add(perm);
                    else
                        queue.offer(perm);
                }
            }
        }
        return result;
    }
}
