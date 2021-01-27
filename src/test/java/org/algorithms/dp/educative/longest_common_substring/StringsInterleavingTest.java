package org.algorithms.dp.educative.longest_common_substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsInterleavingTest {
    private StringsInterleaving stringsInterleaving;

    @BeforeEach
    void setUp() {
        stringsInterleaving = new StringsInterleaving();
    }

    @Test
    void naive() {
        assertTrue(stringsInterleaving.naive("abd", "cef", "abcdef"));
        assertFalse(stringsInterleaving.naive("abd", "cef", "adcbef"));
        assertFalse(stringsInterleaving.naive("abc", "def", "abdccf"));
        assertTrue(stringsInterleaving.naive("abcdef", "mnop", "mnaobcdepf"));
    }

    @Test
    void topToDown() {
        assertTrue(stringsInterleaving.topToDown("abd", "cef", "abcdef"));
        assertFalse(stringsInterleaving.topToDown("abd", "cef", "adcbef"));
        assertFalse(stringsInterleaving.topToDown("abc", "def", "abdccf"));
        assertTrue(stringsInterleaving.topToDown("abcdef", "mnop", "mnaobcdepf"));
    }

    @Test
    void bottomToUp() {
        assertTrue(stringsInterleaving.bottomToUp("abd", "cef", "abcdef"));
        assertFalse(stringsInterleaving.bottomToUp("abd", "cef", "adcbef"));
        assertFalse(stringsInterleaving.bottomToUp("abc", "def", "abdccf"));
        assertTrue(stringsInterleaving.bottomToUp("abcdef", "mnop", "mnaobcdepf"));
    }
}