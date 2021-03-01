package org.algorithms.coding_patterns.educative.top_k_elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequencySortTest {

    @Test
    void sortCharacterByFrequency() {
        assertEquals("rrggmmPiano", FrequencySort.sortCharacterByFrequency("Programming"));
        assertEquals("bbbaac", FrequencySort.sortCharacterByFrequency("abcbab"));
    }
}