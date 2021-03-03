package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.PriorityQueue;

/*
Given an array, find the sum of all numbers between the K1'th and K2'th smallest elements of that array.
 */
public class SumOfElements {
    //time - O(n * log n), space - O(n)
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums)
            pq.offer(num);
        for (int i = 0; i < k1; i++)
            pq.poll();

        int sum = 0;
        for (int i = k1 + 1; i < k2; i++)
            sum += pq.poll();

        return sum;
    }
}
