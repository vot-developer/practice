package org.algorithms.coding_patterns.educative.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordConcatenationTest {

    @Test
    void findWordConcatenation() {
        assertArrayEquals(new Integer[]{0, 3}, WordConcatenation.findWordConcatenation(
                "catfoxcat", new String[]{"cat", "fox"}).toArray());
        assertArrayEquals(new Integer[]{3}, WordConcatenation.findWordConcatenation(
                "catcatfoxfox", new String[]{"cat", "fox"}).toArray());
        assertArrayEquals(new Integer[]{0, 9}, WordConcatenation.findWordConcatenation(
                "barfoothefoobarman", new String[]{"foo","bar"}).toArray());
        assertArrayEquals(new Integer[]{}, WordConcatenation.findWordConcatenation(
                "wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}).toArray());
    }
}