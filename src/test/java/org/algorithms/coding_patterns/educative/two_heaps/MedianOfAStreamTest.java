package org.algorithms.coding_patterns.educative.two_heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfAStreamTest {

    @Test
    void test() {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        assertEquals(2, medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        assertEquals(3, medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        assertEquals(3.5, medianOfAStream.findMedian());
    }
}