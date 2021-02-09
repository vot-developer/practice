package org.algorithms.coding_patterns.educative.cyclic_sort;

/*
We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from 1 to ‘n’
based on their creation sequence.
This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.

Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) and without any extra space.
For simplicity, let’s assume we are passed an integer array containing only the sequence numbers,
though each number is actually an object.
 */
public class CyclicSort {
    //time - O(n), space - O(1)
    public static void sort(int[] nums) {
        int index = 0;
        while (index < nums.length){
            int expectedIndex = nums[index] - 1;
            if (expectedIndex != index)
                swap(index, expectedIndex, nums);
            else
                index++;
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
