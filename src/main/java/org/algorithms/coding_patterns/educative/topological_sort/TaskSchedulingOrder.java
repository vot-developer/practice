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
before it can be scheduled. Given the number of tasks and a list of prerequisite pairs,
write a method to find the ordering of tasks we should pick to finish all tasks.
 */
public class TaskSchedulingOrder {
    //time - O(E + V), space - O(V)
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0)
            return sortedOrder;

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
            Integer v = sources.poll();
            sortedOrder.add(v);
            for (int w : graph.get(v)) {
                inDegree.put(w, inDegree.get(w) - 1);
                if (inDegree.get(w) == 0)
                    sources.offer(w);
            }
        }

        if (sortedOrder.size() != tasks) // topological sort is not possible as the graph has a cycle
            return new ArrayList<>();

        return sortedOrder;
    }
}
