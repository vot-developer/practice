package org.algorithms.coding_patterns.educative.bitwise_xor;

/*
In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once.
Find the two numbers that appear only once.
 */
public class TwoSingleNumbers {
    public static int[] findSingleNumbers(int[] nums) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;

        // get the rightmost bit that is '1'
        diff &= -diff;

        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[] { num1, num2 };
    }
}
