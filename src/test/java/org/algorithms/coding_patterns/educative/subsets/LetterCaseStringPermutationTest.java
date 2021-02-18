package org.algorithms.coding_patterns.educative.subsets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCaseStringPermutationTest {

    @Test
    void findLetterCaseStringPermutations() {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        assertEquals(4, result.size());
        assertEquals("ad52", result.get(0));
        assertEquals("Ad52", result.get(1));
        assertEquals("aD52", result.get(2));
        assertEquals("AD52", result.get(3));
    }
}