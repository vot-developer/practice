package org.algorithms.coding_patterns.educative.subsets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    @Test
    void generateValidParentheses1() {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        assertEquals(2, result.size());
        assertEquals("(())", result.get(0));
        assertEquals("()()", result.get(1));
    }

    @Test
    void generateValidParentheses2() {
        List<String> result = GenerateParentheses.generateValidParentheses(3);
        assertEquals(5, result.size());
        assertEquals("((()))", result.get(0));
        assertEquals("(()())", result.get(1));
        assertEquals("(())()", result.get(2));
        assertEquals("()(())", result.get(3));
        assertEquals("()()()", result.get(4));
    }

    @Test
    void generateDp1() {
        List<String> result = GenerateParentheses.generateDP(2);
        assertEquals(2, result.size());
        assertEquals("(())", result.get(0));
        assertEquals("()()", result.get(1));
    }

    @Test
    void generateDp2() {
        List<String> result = GenerateParentheses.generateDP(3);
        assertEquals(5, result.size());
        assertEquals("((()))", result.get(0));
        assertEquals("(()())", result.get(1));
        assertEquals("(())()", result.get(2));
        assertEquals("()(())", result.get(3));
        assertEquals("()()()", result.get(4));
    }
}