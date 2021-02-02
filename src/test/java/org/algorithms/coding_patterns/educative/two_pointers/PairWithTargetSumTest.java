package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairWithTargetSumTest {

    @Test
    void search() {
        assertArrayEquals(new int[]{1, 3}, PairWithTargetSum.search(new int[]{1, 2, 3, 4, 6}, 6));
        assertArrayEquals(new int[]{0, 2}, PairWithTargetSum.search(new int[]{2, 5, 9, 11}, 11));
    }

    @Test
    void searchAlternative() {
        assertArrayEquals(new int[]{1, 3}, PairWithTargetSum.searchAlternative(new int[]{1, 2, 3, 4, 6}, 6));
        assertArrayEquals(new int[]{0, 2}, PairWithTargetSum.searchAlternative(new int[]{2, 5, 9, 11}, 11));
    }
}