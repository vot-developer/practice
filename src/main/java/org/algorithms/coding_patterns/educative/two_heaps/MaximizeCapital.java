package org.algorithms.coding_patterns.educative.two_heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
Given a set of investment projects with their respective profits, we need to find the most profitable projects.
We are given an initial capital and are allowed to invest only in a fixed number of projects.
Our goal is to choose projects that give us the maximum profit.
Write a function that returns the maximum total capital after selecting the most profitable projects.

We can start an investment project only when we have the required capital.
Once a project is selected, we can assume that its profit has become our capital.
 */
public class MaximizeCapital {
    //time - O((n + k) * log n), space - O(n)
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int amount = initialCapital;

        PriorityQueue<Integer> minCapital = new PriorityQueue<>(capital.length, (a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(profits.length, (a, b) -> profits[b] - profits[a]);

        for (int i = 0; i < capital.length; i++)
            minCapital.offer(i);

        for (int j = 0; j < numberOfProjects; j++){

            while (!minCapital.isEmpty() &&  capital[minCapital.peek()] <= amount)
                maxProfit.offer(minCapital.poll());

            if (maxProfit.isEmpty())
                break;

            amount+= profits[maxProfit.poll()];
        }

        return amount;
    }
}
