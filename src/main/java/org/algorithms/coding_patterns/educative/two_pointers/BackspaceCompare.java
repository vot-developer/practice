package org.algorithms.coding_patterns.educative.two_pointers;

public class BackspaceCompare {
    //time - O(n1 + n2), space - O(1)
    public static boolean compare(String str1, String str2) {
        int end1 = str1.length() - 1;
        int end2 = str2.length() - 1;
        while (end1 >= 0 || end2 >= 0) {
            end1 = getComparableIndex(str1, end1);
            end2 = getComparableIndex(str2, end2);
            if (end1 < 0 || end2 < 0)
                break;
            if (str1.charAt(end1--) != str2.charAt(end2--))
                return false;
        }

        if (end1 != end2)
            return false;

        return true;
    }

    private static int getComparableIndex(String s, int i) {
        int shift = 0;
        while (i >= 0 &&(s.charAt(i) == '#' || shift > 0)) {
            if (s.charAt(i) == '#')
                shift++;
            else if (shift > 0)
                shift--;
            i--;
        }
        return i;
    }
}
