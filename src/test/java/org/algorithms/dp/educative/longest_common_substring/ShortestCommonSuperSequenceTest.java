package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestCommonSuperSequenceTest {
    private ShortestCommonSuperSequence superSequence;

    @BeforeEach
    void setUp() {
        superSequence = new ShortestCommonSuperSequence();
    }

    @Test
    void naive() {
        assertEquals(5, superSequence.naive("abcf", "bdcf"));
        assertEquals(15, superSequence.naive("dynamic", "programming"));
    }

    @Test
    void topToDown() {
        assertEquals(5, superSequence.topToDown("abcf", "bdcf"));
        assertEquals(15, superSequence.topToDown("dynamic", "programming"));
    }

    @Test
    void bottomToUp() {
        assertEquals(5, superSequence.bottomToUp("abcf", "bdcf"));
        assertEquals(15, superSequence.bottomToUp("dynamic", "programming"));
    }
}