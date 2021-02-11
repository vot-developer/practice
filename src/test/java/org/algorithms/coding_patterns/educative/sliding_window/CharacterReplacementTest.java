package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterReplacementTest {

    @Test
    void findLength() {
        assertEquals(5, CharacterReplacement.findLength("aabccbb", 2));
        assertEquals(4, CharacterReplacement.findLength("abbcb", 1));
        assertEquals(3, CharacterReplacement.findLength("abccde", 1));
        assertEquals(5, CharacterReplacement.findLength("baaab", 2));
    }
}