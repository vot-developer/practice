package org.algorithms.coding_patterns.educative.two_heaps;

import java.util.Comparator;
import java.util.TreeSet;

/*
Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.
 */
public class SlidingWindowMedian {

    //time - O(n log k), space - O(k)
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b);
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed()); //ordered by max
        TreeSet<Integer> right = new TreeSet<>(comparator);

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                right.add(i);
                left.add(right.pollFirst());
                balance(left, right);
                continue;
            }

            right.add(i);
            left.add(right.pollFirst());
            balance(left, right);
            result[i - k + 1] = findMedian(nums, left, right);
            if (!right.remove(i - k + 1))
                left.remove(i - k + 1);
            balance(left, right);
        }

        return result;
    }

    private void balance(TreeSet<Integer> left, TreeSet<Integer> right){
        while (right.size() > left.size() + 1)
            left.add(right.pollFirst());
        while(right.size() < left.size())
            right.add(left.pollFirst());
    }

    private double findMedian(int[] nums, TreeSet<Integer> left, TreeSet<Integer> right) {
        if (right.size() != left.size()) return nums[right.first()];
        return nums[right.first()] / 2.0 + nums[left.first()] / 2.0;
    }
}
