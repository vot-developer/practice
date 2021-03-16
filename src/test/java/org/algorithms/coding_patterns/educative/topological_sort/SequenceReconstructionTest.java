package org.algorithms.coding_patterns.educative.topological_sort;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SequenceReconstructionTest {

    @Test
    void canConstruct1() {
        boolean result = SequenceReconstruction.canConstruct(new int[]{1, 2, 3, 4},
            Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 4)));
        assertTrue(result);
    }

    @Test
    void canConstruct2() {
        boolean result = SequenceReconstruction.canConstruct(new int[]{1, 2, 3, 4},
            Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(2, 4)));
        assertFalse(result);
    }

    @Test
    void canConstruct3() {
        boolean result = SequenceReconstruction.canConstruct(new int[]{3, 1, 4, 2, 5},
            Arrays.asList(Arrays.asList(3, 1, 5), Arrays.asList(1, 4, 2, 5)));
        assertTrue(result);
    }

    @Test
    void canConstruct4() {
        boolean result = SequenceReconstruction.canConstruct(new int[]{1, 2, 3},
            Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(2, 3)));
        assertTrue(result);
    }

    @Test
    void canConstruct5() {
        boolean result = SequenceReconstruction.canConstruct(new int[]{1, 2, 3},
            Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3)));
        assertFalse(result);
    }

    @Test
    void canConstruct6() {
        boolean result = SequenceReconstruction.canConstruct(new int[]{1},
            new ArrayList<>());
        assertFalse(result);
    }
}