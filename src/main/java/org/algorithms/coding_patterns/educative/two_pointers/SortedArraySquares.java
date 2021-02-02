package org.algorithms.coding_patterns.educative.two_pointers;

/*
Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 */
public class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int l = 0, r = arr.length - 1, k = arr.length - 1;
        while (k >= 0){
            if (Math.abs(arr[l]) > Math.abs(arr[r]))
                squares[k--] = (int) Math.pow(arr[l++], 2);
            else
                squares[k--] = (int) Math.pow(arr[r--], 2);
        }
        return squares;
    }
}
