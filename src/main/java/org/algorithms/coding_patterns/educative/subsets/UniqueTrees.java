package org.algorithms.coding_patterns.educative.subsets;

import java.util.ArrayList;
import java.util.List;

/*
Given a number 'n', write a function to return all structurally unique Binary Search Trees (BST) that can store values 1 to 'n'?
 */
public class UniqueTrees {
    //time - O(n * 2^n), space - O(n * 2^n)
    public static List<TreeNode> findUniqueTrees(int n) {
        if (n <= 0)
            return new ArrayList<>();
        return findUniqueTreesRecursive(1, n);
    }

    private static List<TreeNode> findUniqueTreesRecursive(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);//for do loop by other side
            return result;
        }

        if (start == end){
            result.add(new TreeNode(start));
            return result;
        }

        for (int i = start; i <= end; i++){
            List<TreeNode> left = findUniqueTreesRecursive(start, i - 1);
            List<TreeNode> right = findUniqueTreesRecursive(i + 1, end);
            for (TreeNode l : left)
                for (TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
        }
        return result;
    }
}
