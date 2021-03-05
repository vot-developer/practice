package org.algorithms.coding_patterns.educative.modified_binary_search;

/*
Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater
than a given 'key'.

Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter.
This also means that the smallest letter in the given array is greater than the last letter of the array and is also
the first letter of the array.
 */
public class NextLetter {
    //time - O(log n), space - O(n)
    public static char searchNextLetter(char[] letters, char key) {
        int start = 0;
        int end = letters.length - 1;
        if (key >= letters[end])
            return letters[start];

        while (start <= end) {
            if (start == end){
                if (key != letters[start])
                    return letters[start];
                else
                    return letters[start + 1];
            }

            int mid = start + (end - start) / 2;
            if (key < letters[mid])
                end = mid; //! mid without '-1' - that could be ceil
            else // key >= letters[mid]
                start = mid + 1;
        }

        return letters[0];
    }
}
