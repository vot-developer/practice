package org.algorithms.coding_patterns.educative.bitwise_xor;

/*
Every non-negative integer N has a binary representation, for example, 8 can be represented as “1000” in binary and 7 as “0111” in binary.

The complement of a binary representation is the number in binary that we get when we change every 1 to a 0 and every 0 to a 1. For example, the binary complement of “1010” is “0101”.

For a given positive number N in base-10, return the complement of its binary representation as a base-10 integer.
 */
public class CalculateComplement {
    //time - O(n), space - O(1)
    public static int bitwiseComplement(int n) {
        if (n == 0)
            return 1;

        int highestBit = 1;
        while (highestBit <= n)
            highestBit = highestBit << 1; //like allOnes *= 2; for get number like 100...00 more than 'n'

        return n^(highestBit - 1); //number ^ complement = all_bits_set => number ^ number ^ complement = number ^ all_bits_set
    }

    public static int bitwiseComplement2(int n) {
        return ~n + (Integer.highestOneBit(n) << 1);
    }
}
