package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Design a class to efficiently find the Kth largest element in a stream of numbers.

The class should have the following two things:

The constructor of the class should accept an integer array containing initial numbers from the stream and an integer 'K'.
The class should expose a function add(int num) which will store the given number and return the Kth largest number.
 */
public class KthLargestNumberInStream {
    private final int k;
    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    //time - O(n * log k), space - O(k)
    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        for (int i = 0; i < nums.length; i++){
            if (pq.size() < k)
                pq.offer(nums[i]);
            else if (pq.peek() < nums[i]){
                pq.offer(nums[i]);
                pq.poll();
            }
        }
    }

    //time - O(log k), space - O(k)
    public int add(int num) {
        if (pq.size() < k)
            pq.offer(num);
        else if (pq.peek() < num) {
            pq.poll();
            pq.offer(num);
        }
        return pq.peek();
    }
}
