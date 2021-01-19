package org.algorithms.dp.educative;

public class Fibonacci {

    public int calculateNaive(int n) {
        if (n < 2)
            return n;

        return calculateNaive(n - 1) + calculateNaive(n - 2);
    }

    public int calculateTopBottomWithMemorize(int n){
        int[] memoize = new int[n + 1];
        return doCalculateMemorizeRecursive(n, memoize);
    }

    private int doCalculateMemorizeRecursive(int n, int[] memorize){
        if (n < 2)
            return n;

        if (memorize[n] != 0)
            return memorize[n];

        memorize[n] = doCalculateMemorizeRecursive(n - 1, memorize) + doCalculateMemorizeRecursive(n - 2, memorize);
        return memorize[n];
    }

    public int calculateDownToUp(int n){
        if (n < 2)
            return n;

        int[] numbers = new int[n + 1];
        numbers[0] = 0;
        numbers[1] = 1;

        for (int i = 2; i <= n; i++)
            numbers[i] = numbers[i - 1] + numbers[i - 2];

        return numbers[n];
    }
}
