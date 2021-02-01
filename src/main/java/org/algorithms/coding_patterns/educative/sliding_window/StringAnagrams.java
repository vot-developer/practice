package org.algorithms.coding_patterns.educative.sliding_window;

import java.util.ArrayList;
import java.util.List;

/*
Given a string and a pattern, find all anagrams of the pattern in the given string.
 */
public class StringAnagrams {

    //time - O(n), space - O(R)
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        if (str.length() < pattern.length())
            return resultIndices;

        int[] count = new int[26];
        for (int i = 0; i < pattern.length(); i++) {
            count[pattern.charAt(i) - 'a']++;
            count[str.charAt(i) - 'a']--;
        }
        if (isAllNull(count)) resultIndices.add(0);

        for (int i = pattern.length(); i < str.length(); i++){
            count[str.charAt(i - pattern.length()) - 'a']++;
            count[str.charAt(i) - 'a']--;
            if (isAllNull(count)) resultIndices.add(i - pattern.length() + 1);
        }

        return resultIndices;
    }

    private static boolean isAllNull(int[] count) {
        for (int i = 0; i < count.length; i++)
            if (count[i] != 0) return false;
        return true;
    }
}
