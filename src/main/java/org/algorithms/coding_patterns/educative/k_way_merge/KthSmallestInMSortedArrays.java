package org.algorithms.coding_patterns.educative.k_way_merge;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Given 'M' sorted arrays, find the K'th smallest number among all the arrays.
 */
public class KthSmallestInMSortedArrays {
    //time - O(k * log m), space - O(m)
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(Comparator.comparingInt(e -> lists.get(e.arrayId)[e.index]));
        for (int i = 0; i < lists.size(); i++)
            pq.offer(new Entry(i));

        int count = 0;
        while (!pq.isEmpty()) {
            Entry e = pq.poll();
            if (++count == k)
                return lists.get(e.arrayId)[e.index];
            pq.offer(new Entry(e.index + 1, e.arrayId));
        }
        return -1;
    }

    private static class Entry {
        int index;
        int arrayId;

        public Entry(int arrayId) {
            this.arrayId = arrayId;
        }

        public Entry(int index, int arrayId) {
            this.index = index;
            this.arrayId = arrayId;
        }
    }
}
