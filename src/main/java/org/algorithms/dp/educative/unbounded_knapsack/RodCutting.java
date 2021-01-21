package org.algorithms.dp.educative.unbounded_knapsack;

public class RodCutting {

    //time O(2^n), space - O(n)
    public int naive(int[] lengths, int[] prices, int length) {
        return doNaive(lengths, prices, length, 0);
    }

    private int doNaive(int[] lengths, int[] prices, int length, int index) {
        if (length == 0 || index == lengths.length)
            return 0;

        int prof1 = 0;
        if (length >= lengths[index]) {
            prof1 = prices[index] + doNaive(lengths, prices, length - lengths[index], index); //add something
        }
        int prof2 = doNaive(lengths, prices, length, index + 1); //add nothing
        return Math.max(prof1, prof2);
    }

    //topToDown - time O(n*length), space O(n*length)

    //time O(n*length), space O(n*length)
    public int bottomToUp(int[] lengths, int[] prices, int length) {
        int n = prices.length;
        int[][] aux = new int[prices.length][length + 1];
        for (int i = 0; i < n; i++)
            aux[i][0] = 0;

        for (int s = 1; s <= length; s++)
            aux[0][s] = s * prices[0];

        for (int i = 1; i < n; i++)
            for (int s = 1; s <= length; s++) {
                int prof1 = aux[i - 1][s]; //add nothing
                int prof2 = 0;
                if (s >= lengths[i])
                    prof2 = prices[i] + aux[i][s - lengths[i]]; //add something
                aux[i][s] = Math.max(prof1, prof2);
            }

        return aux[n - 1][length];
    }
}
