package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumDeletionsAndInsertionsToTransformTest {
    private MinimumDeletionsAndInsertionsToTransform transform;

    @BeforeEach
    void setUp() {
        transform = new MinimumDeletionsAndInsertionsToTransform();
    }

    @Test
    void naive() {
        assertEquals(1, transform.naive("abc", "fbc"));
        assertEquals(2, transform.naive("abdca", "cbda"));
        assertEquals(3, transform.naive("passport", "ppsspt"));
    }

    @Test
    void topToDown() {
        assertEquals(1, transform.topToDown("abc", "fbc"));
        assertEquals(2, transform.topToDown("abdca", "cbda"));
        assertEquals(3, transform.topToDown("passport", "ppsspt"));
    }

    @Test
    void bottomToUp() {
        assertEquals(1, transform.bottomToUp("abc", "fbc"));
        assertEquals(2, transform.bottomToUp("abdca", "cbda"));
        assertEquals(3, transform.bottomToUp("passport", "ppsspt"));
    }

    @Test
    void bottomToUpSpaceImproved() {
        assertEquals(1, transform.bottomToUpSpaceImproved("abc", "fbc"));
        assertEquals(2, transform.bottomToUpSpaceImproved("abdca", "cbda"));
        assertEquals(3, transform.bottomToUpSpaceImproved("passport", "ppsspt"));
    }
}