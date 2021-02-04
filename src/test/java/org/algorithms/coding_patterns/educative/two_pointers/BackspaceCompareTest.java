package org.algorithms.coding_patterns.educative.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackspaceCompareTest {

    @Test
    void compare() {
        assertTrue(BackspaceCompare.compare("xy#z", "xzz#"));
        assertFalse(BackspaceCompare.compare("xy#z", "xyz#"));
        assertTrue(BackspaceCompare.compare("xp#", "xyz##"));
        assertTrue(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
        assertTrue(BackspaceCompare.compare("ab##", "c#d#"));
    }
}