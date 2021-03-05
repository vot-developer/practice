package org.algorithms.coding_patterns.educative.cyclic_sort;

/*
We are given an unsorted array containing 'n+1' numbers taken from the range 1 to 'n'.
The array has only one duplicate but it can be repeated multiple times.
Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
 */
public class FindDuplicate {
    //time - O(n), space - O(1)
    public static int findNumber(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int expectedIndex = nums[index] - 1;
            if (index != expectedIndex) {
                if (nums[index] != nums[expectedIndex])
                    swap(index, expectedIndex, nums);
                else
                    return nums[index];
            } else
                index++;
        }

        return -1;
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
