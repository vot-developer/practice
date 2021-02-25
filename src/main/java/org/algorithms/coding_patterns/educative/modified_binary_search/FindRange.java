package org.algorithms.coding_patterns.educative.modified_binary_search;

/*
Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
The range of the ‘key’ will be the first and last position of the ‘key’ in the array.

Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
 */
public class FindRange {
    //time - O(log n), space - O(1)
    public static int[] findRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int index = findTarget(nums, target);
        if (index == -1)
            return result;

        int left = findLeft(nums, target, index);
        int right = findRight(nums, target, index);
        return new int[]{left, right};
    }

    private static int findRight(int[] nums, int target, int start) {
        int end = nums.length - 1;
        int result = start;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target)
                end = mid - 1;
            else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }

    private static int findLeft(int[] nums, int target, int end) {
        int start = 0;
        int result = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target)
                start = mid + 1;
            else {
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }

    private static int findTarget(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target)
                end = mid - 1;
            if (nums[mid] < target)
                start = mid + 1;
        }

        return -1;
    }
}
