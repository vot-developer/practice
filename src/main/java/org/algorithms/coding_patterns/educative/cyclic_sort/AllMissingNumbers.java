package org.algorithms.coding_patterns.educative.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

/*
We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
 */
public class AllMissingNumbers {
    //time - O(n), space - O(1)
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            int expectedIndex = nums[index] - 1;
            if (nums[expectedIndex] != nums[index])
                swap(index, expectedIndex, nums);
            else
                index++;
        }

        for (int i = 0; i < nums.length; i++)
            if (i != nums[i] - 1)
                missingNumbers.add(i + 1);

        return missingNumbers;
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
