package org.algorithms.coding_patterns.educative.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

/*
Given an unsorted array containing numbers, find the smallest missing positive number in it.
 */
public class FirstKMissingPositive {
    //time - O(n), space - O(1)
    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        int index = 0;
        while (index < nums.length){
            int expectedIndex = nums[index] - 1;
            if (expectedIndex >= 0 && expectedIndex < nums.length && nums[index] != nums[expectedIndex])
                swap(index, expectedIndex, nums);
            else
                index++;
        }
        int max = 0;
        for (int i = 0; i < nums.length && missingNumbers.size() < k; i++) {
            if (i != nums[i] - 1) {
                missingNumbers.add(i + 1);
            }
            max = Math.max(max, nums[i]);
        }

        int size = missingNumbers.size();
        for (int i = 0; i < k - size; i++)
            missingNumbers.add(max + 1 + i);
        return missingNumbers;
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
