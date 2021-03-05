package org.algorithms.coding_patterns.educative.k_way_merge;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an N * N matrix where each row and column is sorted in ascending order,
find the Kth smallest element in the matrix.
 */
public class KthSmallestInSortedMatrix {
    //time - O(k * log n), space - O(n)
    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(Comparator.comparingInt(e -> matrix[e.rowId][e.columnId]));
        for (int i = 0; i < matrix.length; i++)
            pq.offer(new Entry(i));

        int count = 0;
        while (!pq.isEmpty()){
            Entry e = pq.poll();
            count++;
            if (count == k)
                return matrix[e.rowId][e.columnId];

            if (matrix[e.rowId].length > e.columnId + 1)
                pq.offer(new Entry(e.rowId, e.columnId + 1));
        }
        return -1;
    }


    private static class Entry {
        int columnId;
        int rowId;

        public Entry(int rowId) {
            this.rowId = rowId;
        }

        public Entry(int rowId, int columnId) {
            this.columnId = columnId;
            this.rowId = rowId;
        }
    }
}

