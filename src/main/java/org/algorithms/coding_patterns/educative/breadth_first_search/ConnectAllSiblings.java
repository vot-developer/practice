package org.algorithms.coding_patterns.educative.breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, connect each node with its level order successor. The last node of each level should point to the first node of the next level.
 */
public class ConnectAllSiblings {
    //time - O(n), space - O(n)
    public static void connect(TreeNodeNext root) {
        Queue<TreeNodeNext> queue = new LinkedList<>();
        queue.add(root);
        TreeNodeNext prev = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeNext node = queue.poll();
                if (prev != null)
                    prev.next = node;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                prev = node;
            }
        }
    }
}
