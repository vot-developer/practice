package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.
 */
public class RearrangeString {
    //time - O(n * log n), space - O(n)
    public static String rearrangeString(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray())
            freq[c - 'a']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.<Integer>comparingInt(i -> freq[i]).reversed());
        for (int i = 0; i < freq.length; i++)
            if (freq[i] > 0)
                pq.offer(i);

        if ((str.length() & 1) == 0 && freq[pq.peek()] > str.length() / 2)
            return "";
        if (freq[pq.peek()] > 1 + str.length() / 2)
            return "";

        StringBuilder sb = new StringBuilder();

        int prev = -1;
        while (!pq.isEmpty()) {
            int i = pq.poll();
            sb.append((char) (i + 'a'));
            freq[i]--;

            if (prev > -1 && freq[prev] > 0)
                pq.offer(prev);
            prev = i;
        }

        return sb.toString();
    }
}
