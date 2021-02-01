package org.algorithms.coding_patterns.educative.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string and a list of words, find all the starting indices of substrings in the given string
that are a concatenation of all the given words exactly once without any overlapping of words.
It is given that all words are of the same length.
 */
public class WordConcatenation {

    //time - O(n * words.length), space - O(words size)
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        int length = words[0].length();
        List<Integer> resultIndices = new ArrayList<>();

        Map<String, Integer> frequencies = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++)
            frequencies.put(words[i], frequencies.getOrDefault(words[i], 0) + 1);

        for (int i = 0; i <= str.length() - words.length * length; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                int nextWordIndex = i + j * length;

                String word = str.substring(nextWordIndex, nextWordIndex + length);
                if (!frequencies.containsKey(word))
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                if (wordsSeen.get(word) > frequencies.getOrDefault(word, 0))
                    break;

                if (j + 1 == words.length)
                    resultIndices.add(i);
            }
        }

        return resultIndices;
    }
}
