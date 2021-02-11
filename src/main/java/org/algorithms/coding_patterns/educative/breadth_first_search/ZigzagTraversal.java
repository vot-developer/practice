package org.algorithms.coding_patterns.educative.breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, populate an array to represent its zigzag level order traversal.
You should populate the values of all nodes of the first level from left to right,
then right to left for the next level and keep alternating in the same manner for the following levels.
 */
public class ZigzagTraversal {
    //time - O(n), space - O(1)
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            boolean isDirectOrder = result.size() % 2 == 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isDirectOrder)
                    level.add(node.val);
                else
                    level.add(0, node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
