package org.algorithms.coding_patterns.educative.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < arr.length; end++){
            char i = arr[end];
            if (!map.containsKey(i))
                map.put(arr[end], 1);
            else
                map.put(arr[end], map.get(i) + 1);

            while (map.size() > 2) {
                char j = arr[start++];
                if (map.get(j) > 1)
                    map.put(j, map.get(j) - 1);
                else if (map.get(j) == 1)
                    map.remove(j);
            }
            max = Math.max(end - start + 1, max);
        }
        return max;
    }
}
