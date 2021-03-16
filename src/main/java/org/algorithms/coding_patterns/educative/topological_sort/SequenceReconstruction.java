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
Given a sequence originalSeq and an array of sequences, write a method to find
if originalSeq can be uniquely reconstructed from the array of sequences.

Unique reconstruction means that we need to find if originalSeq is the only sequence such that all sequences
in the array are subsequences of it.
 */
public class SequenceReconstruction {

    //time - O(n), space - O(n)
    public static boolean canConstruct(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> digraph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i : org) {
            digraph.put(i, new HashSet<>());
            indegree.put(i, 0);
        }

        //check seqs has all org values
        Set<Integer> allSeqs = new HashSet<>();

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                allSeqs.add(seq.get(i));
                if (!digraph.containsKey(seq.get(i)))
                    return false;
                if (i > 0) {
                    if (!digraph.get(seq.get(i - 1)).contains(seq.get(i))) {
                        digraph.get(seq.get(i - 1)).add(seq.get(i));
                        indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                    }
                }
            }
        }

        if (digraph.size() != allSeqs.size())
            return false;

        Queue<Integer> orderQueue = new LinkedList<>();
        List<Integer> sortedOrder = new ArrayList<>();
        for (int i : indegree.keySet())
            if (indegree.get(i) == 0)
                orderQueue.offer(i);


        while (!orderQueue.isEmpty()) {
            if (orderQueue.size() > 1)
                return false;

            int i = orderQueue.poll();
            sortedOrder.add(i);
            for (int j : digraph.get(i)) {
                indegree.put(j, indegree.get(j) - 1);
                if (indegree.get(j) == 0)
                    orderQueue.offer(j);
            }
        }

        if (sortedOrder.size() != org.length)
            return false;

        for (int i = 0; i < sortedOrder.size(); i++)
            if (sortedOrder.get(i) != org[i])
                return false;

        return true;
    }
}
