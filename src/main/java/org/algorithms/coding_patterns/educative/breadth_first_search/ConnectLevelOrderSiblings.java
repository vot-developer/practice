package org.algorithms.coding_patterns.educative.breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, connect each node with its level order successor.
The last node of each level should point to a null node.
 */
public class ConnectLevelOrderSiblings {
    //time - O(n), space - O(n)
    public static void connect(TreeNodeNext root) {
        Queue<TreeNodeNext> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNodeNext prev = null;
            for (int i = 0; i < size; i++){
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

class TreeNodeNext {
    int val;
    TreeNodeNext left;
    TreeNodeNext right;
    TreeNodeNext next;

    TreeNodeNext(int x) {
        val = x;
        left = right = next = null;
    }
}
