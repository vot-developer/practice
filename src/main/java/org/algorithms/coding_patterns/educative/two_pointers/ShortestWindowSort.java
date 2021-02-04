package org.algorithms.coding_patterns.educative.two_pointers;

/*
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 */
public class ShortestWindowSort {
    //time - O(n), space - O(1)
    public static int sort(int[] arr) {
        if (arr.length <= 1)
            return 0;

        int l = 0;
        int r = arr.length - 1;
        while(l < r && arr[l + 1] >= arr[l])
            l++;
        while (r > l && arr[r - 1] <= arr[r])
            r--;

        if (r == l)
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        while (l > 0 && arr[l - 1] > min)
            l--;
        while (r < arr.length - 1 && arr[r + 1] < max)
            r++;

        return r - l + 1;
    }
}
