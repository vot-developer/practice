package org.algorithms.coding_patterns.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
public class LongestSubstringKDistinct {

    //time - O(n), space - O(n)
    public static int findLength(String str, int k) {
        int start = 0, maxLength = 0;
        Map<Character, Integer> counts = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            while (counts.size() > k) {
                char r = str.charAt(start++);
                if (counts.get(r) > 1)
                    counts.put(r, counts.get(r) - 1);
                else
                    counts.remove(r);
            }

            maxLength = Math.max(end - start + 1, maxLength);
        }

        return maxLength;
    }
}
