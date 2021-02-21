package org.algorithms.coding_patterns.educative.subsets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneralizedAbbreviationTest {

    @Test
    void generateGeneralizedAbbreviation() {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        assertEquals(8, result.size());
        assertEquals("3", result.get(0));
        assertEquals("2T", result.get(1));
        assertEquals("1A1", result.get(2));
        assertEquals("1AT", result.get(3));
        assertEquals("B2", result.get(4));
        assertEquals("B1T", result.get(5));
        assertEquals("BA1", result.get(6));
        assertEquals("BAT", result.get(7));
    }

    @Test
    void generateGeneralizedAbbreviationDP() {
        List<String> result = GeneralizedAbbreviation.generateDp("BAT");
        assertEquals(8, result.size());
        assertEquals("3", result.get(0));
        assertEquals("2T", result.get(1));
        assertEquals("1A1", result.get(2));
        assertEquals("1AT", result.get(3));
        assertEquals("B2", result.get(4));
        assertEquals("B1T", result.get(5));
        assertEquals("BA1", result.get(6));
        assertEquals("BAT", result.get(7));
    }
}