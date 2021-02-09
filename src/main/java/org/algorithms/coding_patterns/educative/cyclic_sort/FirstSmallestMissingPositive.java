package org.algorithms.coding_patterns.educative.cyclic_sort;

/*
Given an unsorted array containing numbers, find the smallest missing positive number in it.
 */
public class FirstSmallestMissingPositive {
    //time - O(n), space - O(1)
    public static int findNumber(int[] nums) {
        int index = 0;
        while (index < nums.length){
            int expectedIndex = nums[index] - 1;
            if (expectedIndex >= 0 && expectedIndex < nums.length && nums[index] != nums[expectedIndex])
                swap(index, expectedIndex, nums);
            else
                index++;
        }
        for (int i = 0; i < nums.length; i++)
            if (i != nums[i] - 1)
                return i + 1;

        return -1;
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
