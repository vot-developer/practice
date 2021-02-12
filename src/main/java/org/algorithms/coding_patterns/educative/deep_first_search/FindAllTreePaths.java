package org.algorithms.coding_patterns.educative.deep_first_search;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a number ‘S’,
find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 */
public class FindAllTreePaths {
    //time - O(n^2), space - O(n * log n (h))
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        doFindPaths(root, sum, new ArrayList<>(), allPaths);
        return allPaths;
    }

    private static void doFindPaths(TreeNode root, int sum, List<Integer> path, List<List<Integer>> allPaths){
        if (root == null)
            return;

        path.add(root.val);

        if (root.val == sum && root.left == null && root.right == null)
            allPaths.add(new ArrayList<>(path));

        doFindPaths(root.left, sum - root.val, path, allPaths);
        doFindPaths(root.right, sum - root.val, path, allPaths);

        path.remove(path.size() - 1);
    }
}
