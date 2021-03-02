package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a sorted number array and two integers 'K' and 'X', find 'K' closest numbers to 'X' in the array.
Return the numbers in the sorted order. 'X' is not necessarily present in the array.
 */
public class KClosestElements {

    //time - O(log n + k * log k), space - O(k)
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);
        Comparator<Integer> comparator = (a, b) -> compare(a, b, x);
        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator.reversed());
        pq.offer(arr[index]);

        int left = index - 1;
        int i = 0;
        while (left >= 0 && i++ < k)
            pq.offer(arr[left--]);

        int right = index + 1;
        i = 0;
        while (right < arr.length && i++ < k)
            pq.offer(arr[right++]);

        while(pq.size() > k)
            pq.poll();

        List<Integer> result =  new ArrayList<>(pq);
        Collections.sort(result);
        return result;
    }

    private static int compare(int a, int b, int x){
        int aDist = Math.abs(a - x);
        int bDist = Math.abs(b - x);
        if (aDist == bDist)
            return a - b;
        return aDist - bDist;
    }

    private static int binarySearch(int[] arr, int x){
        int start = 0, end = arr.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == x)
                return mid;

            if (arr[mid] < x)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}
