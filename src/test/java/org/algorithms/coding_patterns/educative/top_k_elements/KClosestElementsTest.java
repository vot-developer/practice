package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KClosestElementsTest {

    @Test
    void findClosestElements1() {
        List<Integer> result = KClosestElements.findClosestElements(new int[]{5, 6, 7, 8, 9}, 3, 7);
        assertArrayEquals(new Integer[]{6, 7, 8}, result.toArray());
    }

    @Test
    void findClosestElements2() {
        List<Integer> result = KClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, result.toArray());
    }

    @Test
    void findClosestElements3() {
        List<Integer> result = KClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, result.toArray());
    }

    @Test
    void findClosestElements4() {
        List<Integer> result = KClosestElements.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9);
        assertArrayEquals(new Integer[]{10}, result.toArray());
    }

    @Test
    void findClosestElements5() {
        List<Integer> result = KClosestElements.findClosestElements(new int[]{3, 5, 8, 10}, 2, 15);
        assertArrayEquals(new Integer[]{8, 10}, result.toArray());
    }

    @Test
    void findClosestElements6() {
        List<Integer> result = KClosestElements.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5);
        assertArrayEquals(new Integer[]{3, 3, 4}, result.toArray());
    }
}