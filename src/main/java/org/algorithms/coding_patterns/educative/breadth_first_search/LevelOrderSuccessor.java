package org.algorithms.coding_patterns.educative.breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree and a node, find the level order successor of the given node in the tree.
The level order successor is the node that appears right after the given node in the level order traversal.
 */
public class LevelOrderSuccessor {
    //time - O(n), space - O(n)
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (node.val == key)
                    return queue.poll();
            }
        }
        return null;
    }
}
