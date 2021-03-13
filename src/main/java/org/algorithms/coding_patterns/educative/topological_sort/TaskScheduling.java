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
There are 'N' tasks, labeled from '0' to 'N-1'. Each task can have some prerequisite tasks which need to be completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.
 */
public class TaskScheduling {
    //time - O(E+V), space - O(V)
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        int countTasks = 0;
        if (tasks <= 0)
            return true;

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
            countTasks++;
            for (int w : graph.get(v)) {
                inDegree.put(w, inDegree.get(w) - 1);
                if (inDegree.get(w) == 0)
                    sources.offer(w);
            }
        }

        return countTasks == tasks;
    }
}
