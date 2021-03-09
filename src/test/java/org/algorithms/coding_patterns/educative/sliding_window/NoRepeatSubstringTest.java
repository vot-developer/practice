package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoRepeatSubstringTest {

    @Test
    void findLength() {
        assertEquals(3, NoRepeatSubstring.findLength("aabccbb"));
        assertEquals(2, NoRepeatSubstring.findLength("abbbb"));
        assertEquals(3, NoRepeatSubstring.findLength("abccde"));
        assertEquals(3, NoRepeatSubstring.findLength("abcabcbb"));
        assertEquals(2, NoRepeatSubstring.findLength("abba"));
    }
}