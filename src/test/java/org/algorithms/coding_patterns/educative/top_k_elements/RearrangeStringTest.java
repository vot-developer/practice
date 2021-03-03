package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RearrangeStringTest {

    @Test
    void rearrangeString1() {
        assertEquals("papap", RearrangeString.rearrangeString("aappp"));
    }

    @Test
    void rearrangeString2() {
        assertEquals("gmrgmronaip", RearrangeString.rearrangeString("programming"));
    }

    @Test
    void rearrangeString3() {
        assertEquals("", RearrangeString.rearrangeString("aapa"));
    }

    @Test
    void rearrangeString4() {
        assertEquals("vlvov", RearrangeString.rearrangeString("vvvlo"));
    }

    @Test
    void rearrangeString5() {
        assertEquals("krktkwkrktkzkakpkqk", RearrangeString.rearrangeString("kkkkzrkatkwpkkkktrq"));
    }
}