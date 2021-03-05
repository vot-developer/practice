package org.algorithms.coding_patterns.educative.cyclic_sort;

/*
We are given an unsorted array containing 'n' numbers taken from the range 1 to 'n'.
The array originally contained all the numbers from 1 to 'n', but due to a data error,
one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.
 */
public class FindCorruptNums {
    //time - O(n), space - O(1)
    public static int[] findNumbers(int[] nums) {
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
                return new int[]{i + 1, nums[i]};

        return new int[]{-1, -1};
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
