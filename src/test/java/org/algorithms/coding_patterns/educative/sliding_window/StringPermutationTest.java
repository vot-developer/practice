package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringPermutationTest {

    @Test
    void findPermutation() {
        assertTrue(StringPermutation.findPermutation("oidbcaf", "abc"));
        assertFalse(StringPermutation.findPermutation("odicf", "dc"));
        assertTrue(StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        assertTrue(StringPermutation.findPermutation("aaacb", "abc"));
    }
}