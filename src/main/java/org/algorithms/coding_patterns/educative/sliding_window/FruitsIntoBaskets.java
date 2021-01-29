package org.algorithms.coding_patterns.educative.sliding_window;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of characters where each character represents a fruit tree, you are given two baskets,
and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but you can’t skip a tree once you have started.
You will pick one fruit from each tree until you cannot, i.e.,
you will stop when you have to pick from a third fruit type.
 */
public class FruitsIntoBaskets {

    //time - O(n), space - O(K) -> O(2) -> O(1)
    public static int findLength(char[] arr) {
        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (int start = 0, end = 0; end < arr.length; end++){
            set.add(arr[end]);
            while (set.size() > 2)
                set.remove(arr[start++]);
            max = Math.max(end - start + 1, max);
        }
        return max;
    }
}
