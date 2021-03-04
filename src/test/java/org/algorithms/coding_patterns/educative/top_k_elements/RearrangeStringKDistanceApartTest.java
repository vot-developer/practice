package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RearrangeStringKDistanceApartTest {

    @Test
    void reorganizeString1() {
        assertEquals("mpmp", RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
    }

    @Test
    void reorganizeString2() {
        assertEquals("aba", RearrangeStringKDistanceApart.reorganizeString("aab", 2));
    }

    @Test
    void reorganizeString3() {
        assertEquals("", RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }

    @Test
    void reorganizeString4() {
        assertEquals("a", RearrangeStringKDistanceApart.reorganizeString("a", 2));
    }

    @Test
    void reorganizeString5() {
        assertEquals("", RearrangeStringKDistanceApart.reorganizeString("aaabc", 3));
    }
}