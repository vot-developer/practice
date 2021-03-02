package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted number array and two integers 'K' and 'X', find 'K' closest numbers to 'X' in the array.
Return the numbers in the sorted order. 'X' is not necessarily present in the array.
 */
public class KClosestElements {

    //time - O(log n), space - O(k)
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);
        List<Integer> result = new ArrayList<>();

        int start = index, end = index;
        while (end - start + 1 < k && (start >= 0 && end < arr.length)) {
            if (start == 0) {
                end++;
                continue;
            } else if (end >= arr.length - 1) {
                start--;
                continue;
            }

            int cmp = compare(arr[start - 1], arr[end + 1], x);
            if (cmp <= 0)
                start--;
            else
                end++;
        }

        for (int i = start; i <= end; i++)
            result.add(arr[i]);

        return result;
    }

    private static int compare(int a, int b, int x) {
        int aDist = Math.abs(a - x);
        int bDist = Math.abs(b - x);
        if (aDist == bDist)
            return a - b;
        return aDist - bDist;
    }

    private static int binarySearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
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
