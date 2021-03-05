package org.algorithms.coding_patterns.educative.deep_first_search;

import java.util.HashMap;
import java.util.Map;

/*
Given a binary tree and a number 'S', find all paths in the tree such that the sum of all the node values of each path equals 'S'.
Please note that the paths can start or end at any node but all paths must follow direction from parent to child
 */
public class CountAllPathSum {
    //pattern - dp, time - O(n^2), space - O(n)
    public static int countPathsDP(TreeNode node, int sum) {
        return doCountDP(node, sum, false);
    }

    private static int doCountDP(TreeNode node, int sum, boolean isCounting){
        if (node == null)
            return 0;

        int result = (node.val == sum ? 1 : 0)
                + doCountDP(node.right, sum - node.val, true)
                + doCountDP(node.left, sum - node.val, true);
        if (!isCounting)
            result += doCountDP(node.right, sum, false)  + doCountDP(node.left, sum, false);
        return result;
    }

    //time - O(n), space - O(n)
    public static int countPaths(TreeNode node, int sum) {
        Map<Integer, Integer> sumPrefixes = new HashMap();
        sumPrefixes.put(0, 1); //if 'prefixSum - target' = 0 -> it's 1.
        return doCount(node, 0, sum, sumPrefixes);
    }

    private static int doCount(TreeNode node, int currSum, int target, Map<Integer, Integer> sumPrefixes) {
        if (node == null)
            return 0;

        currSum += node.val;
        int result = sumPrefixes.getOrDefault(currSum - target, 0); //found target sum by remove prefix path
        sumPrefixes.put(currSum, sumPrefixes.getOrDefault(currSum, 0) + 1); //save sum for current path (prefix)


        result += doCount(node.left, currSum, target, sumPrefixes)
                + doCount(node.right, currSum, target, sumPrefixes);
        sumPrefixes.put(currSum, sumPrefixes.get(currSum) - 1); //backtrack
        return result;
    }
}
