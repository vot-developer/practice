package org.algorithms.dp.educative.unbounded_knapsack;

public class UnboundedKnapsack {

    //time - O(2^n), space - O(n)
    public int naive(int[] profits, int[] weights, int capacity) {
        return doNaive(profits, weights, capacity, 0);
    }

    private int doNaive(int[] profits, int[] weights, int capacity, int index) {
        if (capacity == 0 || index == profits.length)
            return 0;

        int prof1 = 0;
        if (capacity >= weights[index])
            prof1 = profits[index] + doNaive(profits, weights, capacity - weights[index], index); //add something
        int prof2 = doNaive(profits, weights, capacity, index + 1); //add nothing

        return Math.max(prof1, prof2);
    }

    //time - O(n * capacity), space - O(n * capacity)
    public int topToDown(int[] profits, int[] weights, int capacity) {
        return doTopToDown(new Integer[profits.length][capacity + 1], profits, weights, capacity, 0);
    }

    private int doTopToDown(Integer[][] cache, int[] profits, int[] weights, int capacity, int index) {
        if (capacity == 0 || index == profits.length)
            return 0;

        if (cache[index][capacity] != null)
            return cache[index][capacity];

        int prof1 = 0;
        if (capacity >= weights[index])
            prof1 = profits[index] + doNaive(profits, weights, capacity - weights[index], index); //add something
        int prof2 = doNaive(profits, weights, capacity, index + 1); //add nothing

        cache[index][capacity] = Math.max(prof1, prof2);
        return cache[index][capacity];
    }

    //time - O(n * capacity), space - O(n * capacity)
    public int bottomToUp(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] aux = new int[n][capacity + 1];

        for (int i = 0; i < n; i++)
            aux[i][0] = 0;

        for (int s = 1; s <= capacity; s++)
            aux[0][s] = profits[0] * s;

        int prof1, prof2;
        for (int i = 1; i < n; i++)
            for (int s = 1; s <= capacity; s++) {
                prof1 = aux[i - 1][s]; //add nothing
                prof2 = 0;
                if (s >= weights[i])
                    prof2 = profits[i] + aux[i - 1][s - weights[i]]; //add something
                aux[i][s] = Math.max(prof1, prof2);
            }

        return aux[n - 1][capacity];
    }
}
