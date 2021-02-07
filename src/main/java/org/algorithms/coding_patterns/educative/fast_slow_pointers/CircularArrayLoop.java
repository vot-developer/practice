package org.algorithms.coding_patterns.educative.fast_slow_pointers;

/*
We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular index.
Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
You should assume that the array is circular which means two things:

1. If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
2. If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
Write a method to determine if the array has a cycle.
The cycle should have more than one element and should follow one direction which means
the cycle should not contain both forward and backward movements.
 */
public class CircularArrayLoop {
    //time - O(n), space - O(1)
    public static boolean loopExists(int[] arr) {
        if (arr.length == 1)
            return false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;

            int fast = stepNext(i, arr);
            int slow = i;
            while (arr[fast] * arr[i] > 0 && arr[stepNext(fast, arr)] * arr[i] > 0) { //while sign of values doesn't change
                if (slow == fast) {
                    if (slow == stepNext(slow, arr))
                        break; //one element loop is not loop
                    else
                        return true;
                }
                fast = stepNext(fast, arr);
                fast = stepNext(fast, arr);
                slow = stepNext(slow, arr);
            }

            //loop checked - mark it by 0 values :
            int current = i;
            int prev = i;
            int prevValue = arr[i];
            while (arr[current]*prevValue > 0){
                prevValue = arr[current];
                prev = current;
                current = stepNext(current, arr);
                arr[prev] = 0;
            }
        }
        return false;
    }

    private static int stepNext(int i, int[] arr) {
        int next = i + arr[i];
        if (next >= arr.length)
            next %= arr.length;
        else if (next < 0)
            next = next % arr.length + arr.length;
        return next;
    }
}
