package org.algorithms.coding_patterns.educative.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a set of distinct numbers, find all of its permutations.
 */
public class Permutations {
    //time - O(n*n!), space - O(n*n!)
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        for (int num : nums){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                List<Integer> set = queue.poll();
                int setSize = set.size();
                for (int j = 0; j <= setSize; j++){
                    List<Integer> perm = new ArrayList<>(set);
                    perm.add(j, num);
                    if (perm.size() == nums.length)
                        result.add(perm);
                    else
                        queue.offer(perm);
                }
            }
        }

        return result;
    }
}
