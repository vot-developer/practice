package org.algorithms.coding_patterns.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    //time - O(n), space - O(n)
    public static int findLength(String str) {
        int start = 0, maxLength = 0;
        Map<Character, Integer> symbols = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (symbols.containsKey(c))
                start = Math.max(symbols.get(c) + 1, start);

            symbols.put(c, end);

            maxLength = Math.max(end - start + 1, maxLength);
        }

        return maxLength;
    }
}
