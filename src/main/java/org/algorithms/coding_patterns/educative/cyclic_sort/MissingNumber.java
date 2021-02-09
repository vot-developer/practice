package org.algorithms.coding_patterns.educative.cyclic_sort;

/*
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
 */
public class MissingNumber {
    //time - O(n), space - O(1)
    public static int findMissingNumber(int[] nums) {
        int index = 0;
        while (index < nums.length){
            int expectedIndex = nums[index];
            if (expectedIndex < nums.length && expectedIndex != index)
                swap(index, expectedIndex, nums);
            else
                index++;
        }
        for (int i = 0; i < nums.length; i++)
            if (i != nums[i])
                return i;

        return -1;
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
