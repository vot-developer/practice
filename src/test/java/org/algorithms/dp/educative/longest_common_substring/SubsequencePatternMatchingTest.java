package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsequencePatternMatchingTest {
    private SubsequencePatternMatching matching;

    @BeforeEach
    void setUp() {
        matching = new SubsequencePatternMatching();
    }

    @Test
    void naive() {
        assertEquals(2, matching.naive("baxmx", "ax"));
        assertEquals(4, matching.naive("tomorrow", "tor"));
    }

    @Test
    void topToDown() {
        assertEquals(2, matching.topToDown("baxmx", "ax"));
        assertEquals(4, matching.topToDown("tomorrow", "tor"));
    }

    @Test
    void bottomToUp() {
        assertEquals(2, matching.bottomToUp("baxmx", "ax"));
        assertEquals(4, matching.bottomToUp("tomorrow", "tor"));
    }
}