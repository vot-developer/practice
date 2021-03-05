package org.algorithms.coding_patterns.educative.fast_slow_pointers;

/*
Any number will be called a happy number if, after repeatedly replacing it with a number
equal to the sum of the square of all of its digits, leads us to number '1'.
All other (not-happy) numbers will never reach '1'.
Instead, they will be stuck in a cycle of numbers which does not include '1'.
 */
public class HappyNumber {
    //time - O(log n), space - O(1)
    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int next(int num){
        int sum = 0;
        while(num != 0){
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }
        return sum;
    }
}
