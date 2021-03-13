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
Given a directed graph, find the topological ordering of its vertices.
 */
public class TopologicalSort {
    //time - O(E+V), space - O(V)
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0)
            return sortedOrder;

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }

        for (int[] vs : edges) {
            int v = vs[0];
            int w = vs[1];
            inDegree.put(w, inDegree.get(w) + 1);
            graph.get(v).add(w);
            graph.get(w).add(v);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < vertices; i++)
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

        if (sortedOrder.size() != vertices) // topological sort is not possible as the graph has a cycle
            return new ArrayList<>();

        return sortedOrder;
    }
}
