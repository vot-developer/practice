package org.algorithms.coding_patterns.educative.two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.
 */
public class SlidingWindowMedian {
    private PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder()); //ordered by max
    private PriorityQueue<Integer> max = new PriorityQueue<>();

    //time - O(n), space - O(k)
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                add(nums[i]);
                continue;
            }

            add(nums[i]);
            result[index++] = findMedian();
            remove(nums[i - k + 1]);
        }

        return result;
    }

    private void add(int value) {
        max.offer(value);
        min.offer(max.poll());
        if (max.size() < min.size())
            max.offer(min.poll());
    }

    private void remove(int value) {
        if (!max.remove(value)) {
            min.remove(value);
        }

        if (max.size() < min.size())
            max.offer(min.poll());
        else if (max.size() > min.size())
            min.offer(max.poll());
    }

    public double findMedian() {
        if (max.size() > min.size()) return max.peek();
        return max.peek() / 2.0 + min.peek() / 2.0;
    }
}
