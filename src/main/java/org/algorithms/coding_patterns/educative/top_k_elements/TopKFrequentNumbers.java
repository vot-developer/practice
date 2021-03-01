package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given an unsorted array of numbers, find the top 'K' frequently occurring numbers in it.
 */
public class TopKFrequentNumbers {
    //time - O(n * log k), space - O(k)
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> freq.get(i)));
        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);

        for (int i = k; i < freq.size(); i++)
            if (pq.peek() < nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }

        return new ArrayList<>(pq);
    }
}
