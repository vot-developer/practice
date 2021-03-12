package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Given a directed graph, find the topological ordering of its vertices.
 */
public class TopologicalSort {
    //time - O(E+V), space - O(V)
    public static List<Integer> sort(int vertices, int[][] edges) {
        Deque<Integer> stack = new LinkedList<>();
        boolean[] marked = new boolean[vertices];

        for (int v = 0; v < vertices; v++)
            dfs(v, edges, marked, stack);

        return new ArrayList<>(stack);
    }

    private static void dfs(int v, int[][] edges, boolean[] marked, Deque<Integer> stack) {
        if (marked[v])
            return;

        marked[v] = true;
        for (int w : getAdj(edges, v))
            dfs(w, edges, marked, stack);
        stack.addFirst(v);
    }

    private static List<Integer> getAdj(int[][] edges, int v) {
        List<Integer> result = new ArrayList<>();
        for (int[] verticies : edges)
            if (verticies[0] == v)
                result.add(verticies[1]);

            return result;
    }
}
