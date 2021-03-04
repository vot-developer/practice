package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given a string and a number 'K', find if the string can be rearranged
such that the same characters are at least 'K' distance apart from each other.
 */
public class RearrangeStringKDistanceApart {
    //time - O(n * log n), space - O(n)
    public static String reorganizeString(String str, int k) {
        if (k <= 1 || str.length() == 1)
            return str;

        int[] freq = new int[26];
        for (char c : str.toCharArray())
            freq[c - 'a']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.<Integer>comparingInt(i -> freq[i]).reversed());
        for (int i = 0; i < freq.length; i++)
            if (freq[i] > 0)
                pq.offer(i);

        StringBuilder sb = new StringBuilder();
        Queue<Integer> prevQueue = new LinkedList<>();

        if (pq.size() < k)
            return "";

        while (!pq.isEmpty()) {
            int i = pq.poll();
            sb.append((char) (i + 'a'));
            freq[i]--;
            prevQueue.offer(i);

            if (prevQueue.size() >= k) {
                Integer prev = prevQueue.poll();
                if (prev != null && freq[prev] > 0)
                    pq.offer(prev);
            }
        }

        return sb.length() == str.length() ? sb.toString() : "";
    }
}
