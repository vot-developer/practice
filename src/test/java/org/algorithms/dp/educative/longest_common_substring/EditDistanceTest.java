package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {
    private EditDistance editDistance;

    @BeforeEach
    void setUp() {
        editDistance = new EditDistance();
    }

    @Test
    void naive() {
        assertEquals(1, editDistance.naive("bat", "but"));
        assertEquals(2, editDistance.naive("abdca", "cbda"));
        assertEquals(3, editDistance.naive("passpot", "ppsspqrt"));
    }

    @Test
    void topToDown() {
        assertEquals(1, editDistance.topToDown("bat", "but"));
        assertEquals(2, editDistance.topToDown("abdca", "cbda"));
        assertEquals(3, editDistance.topToDown("passpot", "ppsspqrt"));
    }

    @Test
    void bottomToUp() {
        assertEquals(1, editDistance.bottomToUp("bat", "but"));
        assertEquals(2, editDistance.bottomToUp("abdca", "cbda"));
        assertEquals(3, editDistance.bottomToUp("passpot", "ppsspqrt"));
    }
}