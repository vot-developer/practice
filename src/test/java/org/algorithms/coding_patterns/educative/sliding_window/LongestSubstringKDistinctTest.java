package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringKDistinctTest {

    @Test
    void findLength() {
        assertEquals(4, LongestSubstringKDistinct.findLength("araaci", 2));
        assertEquals(2, LongestSubstringKDistinct.findLength("araaci", 1));
        assertEquals(5, LongestSubstringKDistinct.findLength("cbbebi", 3));
        assertEquals(3, LongestSubstringKDistinct.findLength("eceba", 2));
    }
}