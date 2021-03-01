package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
 */
public class KLargestNumbers {
    //time - O(n log k), space - O(k)
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);

        for (int i = k; i < nums.length; i++){
            if (pq.peek() < nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return new ArrayList<>(pq);
    }
}
