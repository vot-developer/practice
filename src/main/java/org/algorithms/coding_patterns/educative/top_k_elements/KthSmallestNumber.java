package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an unsorted array of numbers, find Kth smallest number in it.

Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.
 */
public class KthSmallestNumber {
    //time - O(n log k), space - O(k)
    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());

        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);

        for (int i = k; i < nums.length; i++){
            if (pq.peek() > nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }
}
