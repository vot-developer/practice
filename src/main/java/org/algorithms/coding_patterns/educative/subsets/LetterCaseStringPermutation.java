package org.algorithms.coding_patterns.educative.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/*
Given a string, find all of its permutations preserving the character sequence but changing case.
 */
public class LetterCaseStringPermutation {
    //time - O(n*2^n!), space - O(n*2^n!)
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for (int i = 0; i < str.length(); i++){
            if (!Character.isLetter(str.charAt(i)))
                continue;

            int size = permutations.size();
            for (int j = 0; j < size; j++){
                char[] c = permutations.get(j).toCharArray();
                if (Character.isUpperCase(c[i])){
                    c[i] = Character.toLowerCase(c[i]);
                } else {
                    c[i] = Character.toUpperCase(c[i]);
                }
                permutations.add(new String(c));
            }
        }

        return permutations;
    }
}
