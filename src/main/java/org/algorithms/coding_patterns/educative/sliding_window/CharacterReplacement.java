package org.algorithms.coding_patterns.educative.sliding_window;

/*
Given a string with lowercase letters only, if you are allowed to replace no more than 'k' letters with any letter,
find the length of the longest substring having the same letters after replacement.
 */
public class CharacterReplacement {
    //time - O(n), space - O(R)
    public static int findLength(String s, int k) {
        int max = 0, maxRepeat = 0;
        char[] counts = new char[26];
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            counts[c - 'a']++;
            maxRepeat = Math.max(counts[c - 'a'], maxRepeat) ;

            if (end - start + 1 - maxRepeat > k)
                counts[s.charAt(start++) - 'a']--;

            max = Math.max(end - start + 1, max);
        }
        return max;
    }
}
