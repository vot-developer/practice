package org.algorithms.coding_patterns.educative.two_pointers;

import java.util.ArrayList;
import java.util.List;

/*
Given an array with positive numbers and a target number,
find all of its contiguous subarrays whose product is less than the target number.
 */
public class SubarrayProductLessThanK {
    //time - O(n^3)(n^2 on form list), space - O(n)
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int product = 1, left = 0;
        for (int right = 0; right < arr.length; right++){
            product *= arr[right];
            while (product >= target && left < arr.length)
                product /= arr[left++];

            List<Integer> list = new ArrayList<>();
            for (int i = right; i >= left; i--){
                list.add(arr[i]);
                subarrays.add(new ArrayList<>(list));
            }
        }
        return subarrays;
    }
}
