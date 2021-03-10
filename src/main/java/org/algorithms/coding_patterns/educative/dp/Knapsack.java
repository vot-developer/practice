package org.algorithms.coding_patterns.educative.dp;

/*
Given the weights and profits of 'N' items, we are asked to put these items in a knapsack with a capacity 'C.'
The goal is to get the maximum profit out of the knapsack items.
Each item can only be selected once, as we don’t have multiple quantities of any item.
 */
//see org.algorithms.dp.educative.knapsack.Knapsack
public class Knapsack {
    //time - O(2^n), space - O(n)
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return doDP(profits, weights, capacity, 0);
    }

    private int doDP(int[] profits, int[] weights, int capacity, int index){
        if (index == profits.length || capacity <= 0)
            return 0;

        int prof1 = 0;
        if (capacity >= weights[index]) //add something
            prof1 = profits[index] + doDP(profits, weights, capacity - weights[index], index + 1);
        int prof2 = doDP(profits, weights, capacity, index + 1); //do nothing
        return Math.max(prof1, prof2);
    }
}
