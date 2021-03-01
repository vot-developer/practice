package org.algorithms.coding_patterns.educative.top_k_elements;

import java.util.PriorityQueue;

/*
Given N ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
The cost of connecting two ropes is equal to the sum of their lengths.
 */
public class ConnectRopes {
    //time - O(n * log n), space - O(n)
    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < ropeLengths.length; i++)
            pq.add(ropeLengths[i]);

        int result = 0, temp;
        while (pq.size() > 1) {
            temp = pq.poll() + pq.poll();
            result += temp;
            pq.add(temp);
        }

        return result;
    }
}
