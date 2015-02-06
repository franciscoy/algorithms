package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class InsertionSort extends AbstractSortingAlgorithm implements SortingAlgorithm {

    @Override
    public int[] sort(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            for (int j = i; j > 0 && inputArray[j-1] > inputArray[j]; j--) {
                swapElements(inputArray, j, j-1);
            }
        }

        return inputArray;
    }
}
