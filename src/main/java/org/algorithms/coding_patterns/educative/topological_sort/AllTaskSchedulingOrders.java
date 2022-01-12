package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
There are 'N' tasks, labeled from '0' to 'N-1'. Each task can have some prerequisite tasks which need to be completed 
before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a method to print all 
possible ordering of tasks meeting all prerequisites.
 */
public class AllTaskSchedulingOrders {

    public static List<List<Integer>> printOrders(int tasks, int[][] prerequisites) {

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        List<List<Integer>> ans = new ArrayList<>();
        createAllTopologicalSorts(tasks, graph, inDegree, sources, new ArrayList<>(), ans);
        return ans;
    }

    private static void createAllTopologicalSorts(int tasks, HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> inDegree,
                                                  Queue<Integer> sources, List<Integer> sortedOrder, List<List<Integer>> ans) {
        if (sortedOrder.size() == tasks)
            ans.add(new ArrayList<>(sortedOrder));

        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                // only remove the current source, all other sources should remain in the queue for the next call
                sourcesForNextCall.remove(vertex);
                List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        sourcesForNextCall.add(child); // save the new source for the next call
                }

                // recursive call to print other orderings from the remaining (and new) sources
                createAllTopologicalSorts(tasks, graph, inDegree, sourcesForNextCall, sortedOrder, ans);

                // backtrack, remove the vertex from the sorted order and put all of its children back to consider
                // the next source instead of the current vertex
                sortedOrder.remove(vertex);
                for (int child : children)
                    inDegree.put(child, inDegree.get(child) + 1);
            }
        }
    }

    // makes a deep copy of the queue
    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }
}
