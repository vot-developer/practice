package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given an array of numbers and a number 'K',
we need to remove 'K' numbers from the array such that we are left with maximum distinct numbers.
 */
public class MaximumDistinctElements {
    //time - O(n * log n), space - O(n)
    public static int findMaximumDistinctElements(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(freq::get));

        int countDistinct = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet())
            if (e.getValue() > 1)
                pq.offer(e.getKey());
            else
                countDistinct++;

        while (k > 0 && pq.size() > 0) {
            int num = pq.poll();
            int numFreq = freq.get(num);
            if (numFreq - 1 <= k)
                countDistinct++;
            k -= numFreq - 1;
        }
        if (k <= 0)
            return countDistinct;
        return countDistinct - k;
    }
}
