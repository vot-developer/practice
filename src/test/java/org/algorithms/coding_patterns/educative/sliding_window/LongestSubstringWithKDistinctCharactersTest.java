package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithKDistinctCharactersTest {

    @Test
    void findLength() {
        assertEquals(4, LongestSubstringWithKDistinctCharacters.findLength("araaci", 2));
        assertEquals(2, LongestSubstringWithKDistinctCharacters.findLength("araaci", 1));
        assertEquals(5, LongestSubstringWithKDistinctCharacters.findLength("cbbebi", 3));
    }
}