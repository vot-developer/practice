package org.algorithms.coding_patterns.educative.k_way_merge;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array of 'K' sorted LinkedLists, merge them into one sorted list.
 */
public class MergeKSortedLists {
    //time - O(n * log k), space - O(k)
    public static ListNode merge(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (ListNode listNode : lists)
            pq.offer(listNode);

        ListNode result = null;
        ListNode current = null;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (result == null) {
                result = node;
                current = node;
            } else {
                current.next = node;
                current = node;
            }
            if (node.next != null)
                pq.offer(node.next);
        }
        return result;
    }
}
