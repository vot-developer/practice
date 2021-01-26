package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDeletionsToMakeSequenceSortedTest {
    private MinimumDeletionsToMakeSequenceSorted deletions;

    @BeforeEach
    void setUp() {
        deletions = new MinimumDeletionsToMakeSequenceSorted();
    }

    @Test
    void naive() {
        assertEquals(2, deletions.naive(new int[]{4, 2, 3, 6, 10, 1, 12}));
        assertEquals(2, deletions.naive(new int[]{3, 5, 0, 1, 2, 6, 7, 10, 12}));
        assertEquals(1, deletions.naive(new int[]{-4, 10, 3, 7, 15}));
        assertEquals(3, deletions.naive(new int[]{3, 2, 1, 0}));
    }

    @Test
    void bottomToUp() {
        assertEquals(2, deletions.bottomToUp(new int[]{4, 2, 3, 6, 10, 1, 12}));
        assertEquals(2, deletions.bottomToUp(new int[]{3, 5, 0, 1, 2, 6, 7, 10, 12}));
        assertEquals(1, deletions.bottomToUp(new int[]{-4, 10, 3, 7, 15}));
        assertEquals(3, deletions.bottomToUp(new int[]{3, 2, 1, 0}));
    }
}