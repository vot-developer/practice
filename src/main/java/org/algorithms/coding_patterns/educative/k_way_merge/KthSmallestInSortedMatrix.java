package org.algorithms.coding_patterns.educative.k_way_merge;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an N * N matrix where each row and column is sorted in ascending order,
find the Kth smallest element in the matrix.
 */
public class KthSmallestInSortedMatrix {
    //time - O(n * log n), space - O(1)
    public static int findThroughBinarySearch(int[][] matrix, int k){
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;

            int[] smallLargePair = { matrix[0][0], matrix[n - 1][n - 1] };
            int count = countLessEqual(matrix, mid, smallLargePair);
            if (count == k)
                return smallLargePair[0];
            if (count < k)
                start = smallLargePair[1]; // search higher
            else
                end = smallLargePair[0]; // search lower
        }
        return start;
    }

    private static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }

    //time - O(k * log n), space - O(n), (k - runk for find, matrix - n x n)
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

