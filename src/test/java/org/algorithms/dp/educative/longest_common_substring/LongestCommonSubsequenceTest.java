package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {
    private LongestCommonSubsequence lcs;

    @BeforeEach
    void setUp() {
        lcs = new LongestCommonSubsequence();
    }

    @Test
    void naive() {
        assertEquals(3, lcs.naive("abdca", "cbda"));
        assertEquals(3, lcs.naive("abdca", "cbbda"));
        assertEquals(4, lcs.naive("abdca", "abcba"));
        assertEquals(5, lcs.naive("passport", "ppsspt"));
    }

    @Test
    void topToDown() {
        assertEquals(3, lcs.topToDown("abdca", "cbda"));
        assertEquals(3, lcs.topToDown("abdca", "cbbda"));
        assertEquals(4, lcs.topToDown("abdca", "abcba"));
        assertEquals(5, lcs.topToDown("passport", "ppsspt"));
    }

    @Test
    void bottomToUp() {
        assertEquals(3, lcs.bottomToUp("abdca", "cbda"));
        assertEquals(3, lcs.bottomToUp("abdca", "cbbda"));
        assertEquals(4, lcs.bottomToUp("abdca", "abcba"));
        assertEquals(5, lcs.bottomToUp("passport", "ppsspt"));
    }

    @Test
    void bottomToUpSpaceImproved() {
        assertEquals(3, lcs.bottomToUpSpaceImproved("abdca", "cbda"));
        assertEquals(3, lcs.bottomToUpSpaceImproved("abdca", "cbbda"));
        assertEquals(4, lcs.bottomToUpSpaceImproved("abdca", "abcba"));
        assertEquals(5, lcs.bottomToUpSpaceImproved("passport", "ppsspt"));
    }
}