package org.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
Multithreaded Merge Sort
 */
public class MultiThreadedMergeSort {

    public void merge(int[] arr, int start, int end) {
        if (start == end)
            return;

        int mid = start + ((end - start) / 2);

        Thread worker1 = new Thread(() -> {
            merge(arr, start, mid);
        });

        Thread worker2 = new Thread(() -> {
            merge(arr, mid + 1, end);
        });

        worker1.start();
        worker2.start();

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
        }

        int[] aux = new int[end - start + 1];
        int i = start, j = mid + 1;
        for (int k = 0; k <= (end - start); k++){
            if (j > end || arr[i] < arr[j])
                aux[k] = arr[i++];
            else
                aux[k] = arr[j++];
        }

        for (int k = 0; k < aux.length; k++)
            arr[start + k] = aux[k];
    }

    public static void main(String args[]) {
        int[] input = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        printArray(input, "Before: ");
        MultiThreadedMergeSort mergeSort = new MultiThreadedMergeSort();
        mergeSort.merge(input, 0, input.length - 1);
        printArray(input, "After:  ");
    }


    private static void printArray(int[] input, String msg) {
        System.out.println();
        System.out.print(msg + " ");
        for (int i = 0; i < input.length; i++)
            System.out.print(" " + input[i] + " ");
        System.out.println();
    }
}
