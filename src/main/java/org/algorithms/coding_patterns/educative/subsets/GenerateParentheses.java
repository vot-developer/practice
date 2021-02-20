package org.algorithms.coding_patterns.educative.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
 */
public class GenerateParentheses {
    //time - O(n*2^n), space - O(n*2^n)
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<ParString> queue = new LinkedList<>();
        ParString first = new ParString();
        first.left = 1;
        first.sb.append('(');
        queue.add(first);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                ParString p = queue.poll();
                if (p.left == num && p.right == num)
                    result.add(p.sb.toString());
                if (p.left < num){
                    ParString left = new ParString(p);
                    left.sb.append('(');
                    left.left++;
                    queue.offer(left);
                }
                if (p.left > p.right){
                    ParString right = new ParString(p);
                    right.sb.append(')');
                    right.right++;
                    queue.offer(right);
                }
            }
        }

        return result;
    }

    public static List<String> generateDP(int n) {
        List<String> result = new ArrayList<>();
        char[] s = new char[2*n];
        doDP(s, 0, 0, 0, n, result);
        return result;
    }

    private static void doDP(char[] s, int index, int leftCount, int rightCount, int n, List<String> result){
        if (index == s.length) {
            result.add(new String(s));
            return;
        }

        if (leftCount < n) {
            s[index] = '(';
            doDP(s, index + 1, leftCount + 1, rightCount, n, result);
        }

        if (rightCount < leftCount){
            s[index] = ')';
            doDP(s, index + 1, leftCount, rightCount + 1, n, result);
        }
    }
}

class ParString {
    int left;
    int right;
    StringBuilder sb;

    public ParString() {
        this.sb = new StringBuilder();
    }

    public ParString(ParString parString) {
        this.sb = new StringBuilder(parString.sb);
        this.left = parString.left;
        this.right = parString.right;
    }
}
