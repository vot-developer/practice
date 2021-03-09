package org.algorithms.coding_patterns.educative.k_way_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestRangeTest {

    @Test
    void findSmallestRange() {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 5, 8));
        lists.add(Arrays.asList(4, 12));
        lists.add(Arrays.asList(7, 8, 10));
        int[] result = SmallestRange.findSmallestRange(lists);
        assertArrayEquals(new int[]{4, 7}, result);
    }
}