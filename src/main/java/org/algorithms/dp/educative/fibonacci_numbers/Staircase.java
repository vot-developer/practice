package org.algorithms.dp.educative.fibonacci_numbers;

/*
Given a stair with 'n' steps, implement a method to count how many possible ways are there to reach the top of the
staircase, given that, at every step you can either take 1 step, 2 steps, or 3 steps.
 */
public class Staircase {

    //time - O(3^{n+l}), space - O(n + l)
    public int naive(int l) {
        return doNaive(new int[]{1, 2, 3,}, l);
    }

    private int doNaive(int[] nums, int l) {
        if (l == 0)
            return 1;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (l >= nums[i])
                count += doNaive(nums, l - nums[i]);
        }
        return count;
    }

    //time - O(l), space - O(l)
    public int topToDown(int l) {
        return doTopToDown(new Integer[l + 1], new int[]{1, 2, 3,}, l);
    }

    private int doTopToDown(Integer[] dp, int[] nums, int l) {
        if (l == 0)
            return 1;

        if (dp[l] != null)
            return dp[l];

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (l >= nums[i])
                count += doTopToDown(dp, nums, l - nums[i]);
        }
        dp[l] = count;
        return count;
    }

    //time - O(n), space - O(l)
    public int bottomToUp(int l) {
        int[] dp = new int[l + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= l; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

        return dp[l];
    }

    //time - O(n), space - O(c)
    public int bottomToUpImprovedSpace(int l) {
        int a = 1;
        int b = 1;
        int c = 2;
        int tmp = 0;
        for (int i = 3; i <= l; i++) {
            tmp = a + b + c;
            a = b;
            b = c;
            c = tmp;
        }
        return tmp;
    }
}
