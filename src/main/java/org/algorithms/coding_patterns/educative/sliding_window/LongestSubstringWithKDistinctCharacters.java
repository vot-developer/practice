package org.algorithms.coding_patterns.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
public class LongestSubstringWithKDistinctCharacters {

    public static int findLength(String str, int k) {
        int start = 0, maxLength = 0;
        Map<Character, Integer> counts = new HashMap<>();

        for (int end = 0; end < str.length(); end++){
            increment(counts, str, end);
            while (counts.get(str.charAt(end)) > k)
                decrement(counts, str, start++);

            maxLength = Math.max(end - start, maxLength);
        }

        return maxLength;
    }

    private static void increment(Map<Character, Integer> counts, String str, int i) {
        char c = str.charAt(i);
        if (counts.containsKey(c))
            counts.put(c, counts.get(c) + 1);
        else
            counts.put(c, 1);
    }

    private static void decrement(Map<Character, Integer> counts, String str, int i) {
        char c = str.charAt(i);
        if (counts.containsKey(c) && counts.get(c) > 0)
            counts.put(c, counts.get(c) - 1);
        else
            counts.put(c, 0);
    }
}
