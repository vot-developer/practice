package org.algorithms.coding_patterns.educative.modified_binary_search;

/*
Given an array of numbers which is sorted in ascending order and is rotated 'k' times around a pivot, find 'k'.

You can assume that the array does not have any duplicates.
 */
public class RotationCountOfRotatedArray {
    //time - O(log n), space - O(1)
    public static int countRotations(int[] nums) {
        int start = 0, end = nums.length - 1;
        if (nums[start] < nums[end])
            return 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (start == mid){
                return nums[start] > nums[end] ? end : start;
            }
            if (nums[mid] < nums[start])
                end = mid;
            else
                start = mid;
        }
        return start != nums.length - 1 ? start + 1 : 0;
    }
}
