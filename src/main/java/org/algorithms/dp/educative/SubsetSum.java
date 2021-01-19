package org.algorithms.dp.educative;

public class SubsetSum {
    //time - O(2^n), space - O(n)(recursive stack)
    public boolean naive(int[] nums, int s) {
        return doNaive(nums, s, 0);
    }

    private boolean doNaive(int[] nums, int s, int index) {
        if (s == 0)
            return true;
        if (index == nums.length)
            return false;

        if (nums[index] <= s)
            if (doNaive(nums, s - nums[index], index + 1)) //add something
                return true;
        return doNaive(nums, s, index + 1);//add nothing
    }

    //time - O(n * s), space - O(n * s)
    public boolean topToDown(int[] nums, int s) {
        return topToDown(nums, s, new Boolean[nums.length][s + 1], 0);
    }

    private boolean topToDown(int[] nums, int s, Boolean[][] cache, int index) {
        if (s == 0)
            return true;
        if (index == nums.length)
            return false;

        if (cache[index][s] != null)
            return cache[index][s];

        if (nums[index] <= s) {
            if (topToDown(nums, s - nums[index], cache, index + 1)) {//add something
                cache[index][s - nums[index]] = true;
                return true;
            }
        }
        return topToDown(nums, s, cache, index + 1); //add nothing
    }

    //time - O(n * s), space - O(n * s)
    public boolean bottomToUp(int[] nums, int sum) {
        boolean[][] isSum = new boolean[nums.length][sum + 1];

        for (int i = 0; i < nums.length; i++)
            isSum[i][0] = true;

        for (int s = 1; s <= sum; s++)
            if (nums[0] == s)
                isSum[0][s] = true;

        for (int i = 1; i < nums.length; i++)
            for (int s = 1; s <= sum; s++) {
                if (isSum[i - 1][s])
                    isSum[i][s] = true; //add nothing
                else if (nums[i] <= s)
                    isSum[i][s] = isSum[i - 1][s - nums[i]]; //add something
            }
        return isSum[nums.length - 1][sum];
    }
}
