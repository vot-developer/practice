package org.algorithms.coding_patterns.educative.k_way_merge;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Given 'K' sorted arrays, find the smallest range that includes at least one number from each of the 'K' lists.
 */
public class SmallestRange {
    //time - O(n * log n). space - O(k)
    public static int[] findSmallestRange(List<List<Integer>> nums) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new Entry(0, i, nums.get(i).get(0)));
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }

        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];
        while(!pq.isEmpty()){
            Entry e = pq.poll();
            int val = e.val;
            if (maxValue - val < minLength){
                minLength = maxValue - val;
                result[0] = val;
                result[1] = maxValue;
            }
            if (nums.get(e.listId).size() - 1 == e.index)
                break;
            int newVal = nums.get(e.listId).get(e.index + 1);
            pq.offer(new Entry(e.index + 1, e.listId, newVal));
            maxValue = Math.max(maxValue, newVal);
        }

        return result;
    }

    private static class Entry {
        final int index;
        final int listId;
        final int val; //with store val - better performance

        public Entry(int index, int listId, int val) {
            this.index = index;
            this.listId = listId;
            this.val = val;
        }
    }
}

