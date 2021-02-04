package org.algorithms.coding_patterns.educative.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers and a target number,
find all unique quadruplets in it, whose sum is equal to the target number.
 */
public class QuadrupleSumToTarget {
    //time - O(n^3), space - O(1)
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();

        for (int i = 0; i < arr.length - 3; i++){
            if (i > 0 && arr[i] == arr[i-1])
                continue;
            for (int j = i + 1; j < arr.length - 2; j++){
                if (j > i + 1 && arr[j] == arr[j-1])
                    continue;

                int sum = target - arr[i] - arr[j];
                int l = j + 1, r = arr.length - 1;
                while (l < r){
                    int localSum = sum - arr[l] - arr[r];
                    if (localSum > 0){
                        l++; //add check dubles
                    } else if (localSum < 0){
                        r--;
                    } else {
                        quadruplets.add(Arrays.asList(arr[i], arr[j], arr[l], arr[r]));
                        l++;
                        r--;
                        while (l < r && arr[l] == arr[l - 1]) // skip same element to avoid duplicate quadruplets
                            l++;
                        while (l < r && arr[r] == arr[r + 1])
                            r--;
                    }
                }
            }
        }

        return quadruplets;
    }
}
