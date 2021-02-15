package org.algorithms.coding_patterns.educative.two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Design a class to calculate the median of a number stream. The class should have the following two methods:

- insertNum(int num): stores the number in the class
- findMedian(): returns the median of all numbers inserted in the class

If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
 */
public class MedianOfAStream {
    private PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder()); //by max
    private PriorityQueue<Integer> max = new PriorityQueue<>();

    //time - O(log n), space - O(n)
    public void insertNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size())
            max.offer(min.poll());
    }

    //time - O(log n), space - O(n)
    public double findMedian() {
        if (max.size() > min.size()) return max.peek();
        else return (max.peek() + min.peek()) / 2.0;
    }
}
