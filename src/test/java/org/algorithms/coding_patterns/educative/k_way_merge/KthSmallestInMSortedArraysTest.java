package org.algorithms.coding_patterns.educative.k_way_merge;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestInMSortedArraysTest {

    @Test
    void findKthSmallest() {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        assertEquals(4, KthSmallestInMSortedArrays.findKthSmallest(lists, 5));
    }
}