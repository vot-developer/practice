package org.algorithms.coding_patterns.educative.bitwise_xor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlippingImageTest {

    @Test
    void flipAndInvertImage1() {
        int[][] result = FlippingImage.flipAndInvertImage(new int[][]{{1, 0, 1}, {1, 1, 1}, {0, 1, 1}});
        assertArrayEquals(new int[]{0, 1, 0}, result[0]);
        assertArrayEquals(new int[]{0, 0, 0}, result[1]);
        assertArrayEquals(new int[]{0, 0, 1}, result[2]);
    }
}