package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubstringTest {
    private LongestCommonSubstring lcs;

    @BeforeEach
    void setUp() {
        lcs = new LongestCommonSubstring();
    }

    @Test
    void naive() {
        assertEquals(2, lcs.naive("abdca", "cbda"));
        assertEquals(2, lcs.naive("abdca", "cbbda"));
        assertEquals(3, lcs.naive("passport", "ppsspt"));
    }

    @Test
    void topToDown() {
        assertEquals(2, lcs.topToDown("abdca", "cbda"));
        assertEquals(2, lcs.topToDown("abdca", "cbbda"));
        assertEquals(3, lcs.topToDown("passport", "ppsspt"));
    }

    @Test
    void bottomToUp() {
        assertEquals(2, lcs.bottomToUp("abdca", "cbda"));
        assertEquals(2, lcs.bottomToUp("abdca", "abcba"));
        assertEquals(2, lcs.bottomToUp("abdca", "cbbda"));
        assertEquals(3, lcs.bottomToUp("passport", "ppsspt"));
    }

    @Test
    void bottomToUpSpaceImproved() {
        assertEquals(2, lcs.bottomToUpSpaceImproved("abdca", "cbda"));
        assertEquals(2, lcs.bottomToUpSpaceImproved("abdca", "abcba"));
        assertEquals(2, lcs.bottomToUpSpaceImproved("abdca", "cbbda"));
        assertEquals(3, lcs.bottomToUpSpaceImproved("passport", "ppsspt"));
    }
}