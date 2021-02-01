package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StringAnagramsTest {

    @Test
    void findStringAnagrams() {
        assertArrayEquals(new Integer[]{1, 2},
                StringAnagrams.findStringAnagrams("ppqp", "pq").toArray());
        assertArrayEquals(new Integer[]{2, 3, 4},
                StringAnagrams.findStringAnagrams("abbcabc", "abc").toArray());
    }
}