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
There is a dictionary containing words from an alien language for which we don’t know the ordering of the alphabets.
Write a method to find the correct order of the alphabets in the alien language. It is given that the input is
a valid dictionary and there exists an ordering among its alphabets.
 */
public class AlienDictionary {
    //time - O(V(R) + E), space - O(R)
    public static String findOrder(String[] words) {
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, Set<Character>> digraph = new HashMap<>();

        for (String word : words)
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                digraph.put(c, new HashSet<>());
            }

        for (int i = 1; i < words.length; i++) {
            int size = Math.min(words[i - 1].length(), words[i].length());
            // Check that word2 is not a prefix of word1.
            if (words[i - 1].length() > words[i].length() && words[i - 1].startsWith(words[i])) {
                return "";
            }
            for (int j = 0; j < size; j++) {
                char a = words[i - 1].charAt(j);
                char b = words[i].charAt(j);
                if (a != b) {
                    if (!digraph.get(a).contains(b)) {
                        digraph.get(a).add(b);
                        inDegree.put(b, inDegree.getOrDefault(b, 0) + 1);
                    }
                    break;
                }
            }
        }

        List<Character> sortedOrder = new ArrayList<>();
        Queue<Character> sources = new LinkedList<>();
        for (char c : digraph.keySet())
            if (inDegree.get(c) == 0)
                sources.offer(c);

        while (!sources.isEmpty()) {
            Character v = sources.poll();
            sortedOrder.add(v);
            for (char w : digraph.get(v)) {
                inDegree.put(w, inDegree.get(w) - 1);
                if (inDegree.get(w) == 0)
                    sources.offer(w);
            }
        }

        if (sortedOrder.size() != digraph.size()) // topological sort is not possible as the graph has a cycle
            return "";

        StringBuilder sb = new StringBuilder(sortedOrder.size());
        for (char c : sortedOrder)
            sb.append(c);
        return sb.toString();
    }
}
