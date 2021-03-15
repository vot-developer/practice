package org.algorithms.coding_patterns.educative.topological_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienDictionaryTest {

    @Test
    void findOrder1() {
        assertEquals("bac", AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" }));
    }

    @Test
    void findOrder2() {
        assertEquals("cab", AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" }));
    }

    @Test
    void findOrder3() {
        assertEquals("ywxz", AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" }));
    }

    @Test
    void findOrder4() {
        assertEquals("z", AlienDictionary.findOrder(new String[] { "z", "z" }));
    }

    @Test
    void findOrder5() {
        assertEquals("abcd", AlienDictionary.findOrder(new String[] { "ab", "adc" }));
    }
}