package org.algorithms.coding_patterns.educative.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array has some numbers appearing twice, find all these duplicate numbers without using any extra space.
 */
public class FindAllDuplicate {
    //time - O(n), space - O(1)
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            int expectedIndex = nums[index] - 1;
            if (nums[index] != nums[expectedIndex])
                swap(index, expectedIndex, nums);
            else
                index++;
        }

        for (int i = 0; i < nums.length; i++)
            if (i != nums[i] - 1)
                duplicateNumbers.add(nums[i]);

        return duplicateNumbers;
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
