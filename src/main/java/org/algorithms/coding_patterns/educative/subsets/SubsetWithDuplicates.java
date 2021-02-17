package org.algorithms.coding_patterns.educative.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of numbers that might contain duplicates, find all of its distinct subsets.
 */
public class SubsetWithDuplicates {
    //time - O(n * 2^n), space - O(n * 2^n)
    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>()); //empty set

        int start, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                start = end;
            else
                start = 0;
            end = subsets.size();
            for (int j = start; j < end; j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j)); //O(n)
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
