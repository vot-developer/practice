package org.algorithms.dp.educative.longest_common_substring;

import java.util.HashMap;
import java.util.Map;

/*
Give three strings ‘m’, ‘n’, and ‘p’, write a method to find out if ‘p’ has been formed by interleaving ‘m’ and ‘n’.
‘p’ would be considered interleaving ‘m’ and ‘n’ if it contains all the letters from ‘m’ and ‘n’
 and the order of letters is preserved too.
 */
public class StringsInterleaving {

    //time - O(n1 + n2), space - O(n1 + n2)
    public boolean naive(String s1, String s2, String sum) {
        return doNaive(s1, s2, sum, 0, 0, 0);
    }

    private boolean doNaive(String s1, String s2, String sum, int i1, int i2, int i3) {
        if (i1 == s1.length() && i2 == s2.length() && i3 == sum.length())
            return true;
        if (i3 == sum.length())
            return false;

        if (i1 < s1.length() && s1.charAt(i1) == sum.charAt(i3))
            return doNaive(s1, s2, sum, i1 + 1, i2, i3 + 1);
        if (i2 < s2.length() && s2.charAt(i2) == sum.charAt(i3))
            return doNaive(s1, s2, sum, i1, i2 + 1, i3 + 1);

        return false;
    }

    //time - O(n1 + n2), space - O(n1 * n2 * n3)
    public boolean topToDown(String s1, String s2, String sum) {
        return doTopToDown(new HashMap<>(), s1, s2, sum, 0, 0, 0);
    }

    private boolean doTopToDown(Map<String, Boolean> dp, String s1, String s2, String sum, int i1, int i2, int i3) {
        if (i1 == s1.length() && i2 == s2.length() && i3 == sum.length())
            return true;
        if (i3 == sum.length())
            return false;

        String key = i1 + "-" + i2 + "-" + i3;
        if (dp.get(key) != null)
            return dp.get(key);

        if (i1 < s1.length() && s1.charAt(i1) == sum.charAt(i3))
            dp.put(key, doTopToDown(dp, s1, s2, sum, i1 + 1, i2, i3 + 1));
        if (i2 < s2.length() && s2.charAt(i2) == sum.charAt(i3))
            dp.put(key, doTopToDown(dp, s1, s2, sum, i1, i2 + 1, i3 + 1));
        return dp.get(key) != null ? dp.get(key) : false;
    }

    //time - O(n3), space - O(1)
    public boolean bottomToUp(String s1, String s2, String sum) {
        int i1 = 0, i2 = 0;
        for (int i3 = 0; i3 < sum.length(); i3++) {
            if (i1 < s1.length() && s1.charAt(i1) == sum.charAt(i3))
                i1++;
            else if (i2 < s2.length() && s2.charAt(i2) == sum.charAt(i3))
                i2++;
            else
                return false;
        }

        return true;
    }
}
