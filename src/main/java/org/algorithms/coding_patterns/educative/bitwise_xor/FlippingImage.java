package org.algorithms.coding_patterns.educative.bitwise_xor;

public class FlippingImage {
    //time - O(n), space - O(1)
    public static int[][] flipAndInvertImage(int[][] arr) {
        for (int i = 0; i < arr.length; i++){
            int size = arr[i].length / 2;
            int k = arr[i].length - 1;
            for (int j = 0; j < size; j++){
                int tmp = arr[i][j] ^ 1;
                arr[i][j] = arr[i][k] ^ 1;
                arr[i][k--] = tmp;
            }
            if ((arr[i].length & 1) == 1)
                arr[i][size] ^= 1;
        }
        return arr;
    }
}
