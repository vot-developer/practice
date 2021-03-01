package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a string, sort it based on the decreasing frequency of its characters.
 */
public class FrequencySort {
    //time - O(n * log n), space - O(n)
    public static String sortCharacterByFrequency(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            freq.put(str.charAt(i), freq.getOrDefault(str.charAt(i), 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.comparingInt(i -> freq.get(i)).reversed());
        for (Map.Entry<Character, Integer> e : freq.entrySet())
            pq.offer(e.getKey());

        char[] result = new char[str.length()];
        for (int i = 0; i < result.length; ) {
            char c = pq.poll();
            for (int j = 0; j < freq.get(c); j++)
                result[i++] = c;
        }
        return new String(result);
    }
}
