package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class InsertionSort extends AbstractSortingAlgorithm implements SortingAlgorithm {

    @Override
    public int[] sort(int[] inputArray) {
        int currentValue;

        for (int i = 1; i < inputArray.length; i++) {
            currentValue=inputArray[i];
            for (int j = i; j > 0; j--) {
                if (inputArray[j-1] > inputArray[j]) {
                    swapElements(inputArray, j, j-1);
                }
            }
        }

        return inputArray;
    }
}
