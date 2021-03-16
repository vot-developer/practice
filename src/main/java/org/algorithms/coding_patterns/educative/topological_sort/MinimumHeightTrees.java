package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
We are given an undirected graph that has characteristics of a k-ary tree.
In such a graph, we can choose any node as the root to make a k-ary tree.
The root (or the tree) with the minimum height will be called Minimum Height Tree (MHT).
There can be multiple MHTs for a graph. In this problem, we need to find all those roots which give us MHTs.
Write a method to find all MHTs of the given graph and return a list of their roots.
 */
public class MinimumHeightTrees {
    //time - O(V + E), space - O(V)
    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (nodes <= 0)
            return result;

        if (nodes == 1) {
            result.add(0);
            return result;
        }

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0], w = edges[i][1];
            graph.get(v).add(w);
            graph.get(w).add(v);
            inDegree.put(v, inDegree.get(v) + 1);
            inDegree.put(w, inDegree.get(w) + 1);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 1)
                leaves.add(entry.getKey());

        int count = nodes;
        while (count > 2) {
            int leavesSize = leaves.size();
            count -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int v = leaves.poll();
                List<Integer> children = graph.get(v);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 1)
                        leaves.add(child);
                }
            }
        }

        result.addAll(leaves);
        return result;
    }
}
