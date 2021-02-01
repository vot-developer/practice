package org.algorithms.coding_patterns.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
 */
public class MinimumWindowSubstring {
    //time - O(n + m), space - O(m)
    public static String findSubstring(String str, String pattern) {
        int matcher, startMatch = 0, minLength = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        matcher = map.size();

        for (int start = 0, end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == 0)
                    matcher--;
            }

            while (matcher == 0) {
                if (end - start + 1 < minLength) {
                    startMatch = start;
                    minLength = end - start + 1;
                }
                char r = str.charAt(start++);
                if (map.containsKey(r)) {
                    map.put(r, map.getOrDefault(r, 0) + 1);
                    if (map.get(r) > 0)
                        matcher++;
                }
            }
        }

        if (minLength == Integer.MAX_VALUE)
            return "";

        return str.substring(startMatch, startMatch + minLength);
    }
}
