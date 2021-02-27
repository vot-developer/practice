package org.algorithms.coding_patterns.educative.bitwise_xor;

/*
In a non-empty array of integers, every number appears twice except for one, find that single number.
 */
public class SingleNumber {
    //time - O(n), space - O(1)
    public static int findSingleNumber(int[] arr) {
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++)
            sum ^= arr[i];

        return sum;
    }
}
