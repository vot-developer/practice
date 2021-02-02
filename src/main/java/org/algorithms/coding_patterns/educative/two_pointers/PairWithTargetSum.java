package org.algorithms.coding_patterns.educative.two_pointers;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 */
public class PairWithTargetSum {
    //time - O(n), space - O(1)
    public static int[] search(int[] arr, int targetSum) {
        int l = 0, r = arr.length - 1;

        while (l <= r){
            if (arr[l] + arr[r] > targetSum)
                r--;
            else if (arr[l] + arr[r] < targetSum)
                l++;
            else
                return new int[] { l, r };
        }

        return new int[] { -1, -1 };
    }

    //time - O(n), space - O(n)
    public static int[] searchAlternative(int[] arr, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            int target = targetSum - arr[i];
            if (map.containsKey(target) && i != map.get(target))
                return new int[]{map.get(target), i};
            else
                map.put(arr[i], i);
        }

        return new int[] { -1, -1 };
    }
}
