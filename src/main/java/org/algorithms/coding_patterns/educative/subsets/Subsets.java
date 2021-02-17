package org.algorithms.coding_patterns.educative.subsets;

import java.util.ArrayList;
import java.util.List;

/*
Given a set with distinct elements, find all of its distinct subsets.
 */
public class Subsets {
    //time - O(n * 2^n), space - (n * 2^n)  (2^n - total of subsets)
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>()); //empty set

        for (int num : nums){
            int size = subsets.size();
            for (int i = 0; i < size; i++){
                List<Integer> set = new ArrayList<>(subsets.get(i)); //O(n)
                set.add(num);
                subsets.add(set);
            }
        }

        return subsets;
    }
}
