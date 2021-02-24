package org.algorithms.coding_patterns.educative.modified_binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextLetterTest {

    @Test
    void searchNextLetter() {
        assertEquals('h', NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        assertEquals('c', NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        assertEquals('a', NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        assertEquals('a', NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}