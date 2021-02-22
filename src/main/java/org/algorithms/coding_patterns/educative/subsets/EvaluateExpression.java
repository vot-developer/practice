package org.algorithms.coding_patterns.educative.subsets;

import java.util.ArrayList;
import java.util.List;

/*
Given an expression containing digits and operations (+, -, *),
find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
 */
public class EvaluateExpression {
    //time - O(n*2^n), space - O(n*2^n)
    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();
        if (input.length() == 1) {
            result.add(Integer.parseInt(input));
            return result;
        }

        for (int i = 1; i < input.length(); i+=2){
            List<Integer> left = diffWaysToEvaluateExpression(input.substring(0, i));
            List<Integer> right = diffWaysToEvaluateExpression(input.substring(i + 1));
            char c = input.charAt(i);
            for (Integer l : left)
                for (Integer r : right){
                    switch (c){
                        case '+' :
                            result.add(l + r);
                            break;
                        case '-' :
                            result.add(l - r);
                            break;
                        default:
                            result.add(l * r);
                    }
                }
        }

        return result;
    }
}
