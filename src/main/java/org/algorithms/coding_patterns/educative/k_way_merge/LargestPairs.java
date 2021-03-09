package org.algorithms.coding_patterns.educative.k_way_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Given two sorted arrays in descending order, find 'K' pairs with the largest sum where each pair consists of numbers from both the arrays.
 */
public class LargestPairs {
    //time - O(n*m*log k), space - O(k)
    public static List<List<Integer>> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> (i[0] + i[1])));
        for (int i = 0; i < nums1.length && i < k; i++)
            for (int j = 0; j < nums2.length && j < k; j++) {
                if (pq.size() < k)
                    pq.offer(new int[]{nums1[i], nums2[j]});
                else {
                    if (nums1[i] + nums2[j] < pq.peek()[0] + pq.peek()[1])
                        break;
                    else{
                        pq.poll();
                        pq.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] pair = pq.poll();
            result.add(new ArrayList<>(Arrays.asList(pair[0], pair[1])));
        }
        return result;
    }
}
