package org.example.algorithms.arrays.challenge2;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        insertionSort(intArray, 0);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void insertionSort(int[] intArray, int start) {

        if (start >= intArray.length) {
            return;
        }
        int newElement = intArray[start];
        int i;

        for (i = start; i > 0 && intArray[i - 1] > newElement; i--) {
            intArray[i] = intArray[i - 1];
        }

        intArray[i] = newElement;
        insertionSort(intArray, ++start);
    }
}
