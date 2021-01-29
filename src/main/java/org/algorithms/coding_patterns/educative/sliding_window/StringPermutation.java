package org.algorithms.coding_patterns.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
Given a string and a pattern, find out if the string contains any permutation of the pattern.
 */
public class StringPermutation {
    //time - O(n), space - O(k)
    public static boolean findPermutation(String str, String pattern) {
        int patternCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (int start = 0, end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == 0)
                    patternCount++;
            }

            if (end + 1 > pattern.length()) {
                char r = str.charAt(start++);
                if (map.containsKey(r)) {
                    if (map.get(r) == 0)
                        patternCount--;
                    map.put(r, map.get(r) + 1);
                }
            }

            if (patternCount == map.size())
                return true;
        }
        return false;
    }
}
