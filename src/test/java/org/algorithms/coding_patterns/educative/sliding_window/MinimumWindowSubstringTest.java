package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumWindowSubstringTest {

    @Test
    void findSubstring() {
        assertEquals("abdec", MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        assertEquals("bca", MinimumWindowSubstring.findSubstring("abdbca", "abc"));
        assertEquals("", MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}