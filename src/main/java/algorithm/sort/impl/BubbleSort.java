package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class BubbleSort extends AbstractSortingAlgorithm implements SortingAlgorithm{

    @Override
    public int[] sort(int[] inputArray) {
    boolean swapped = true;
    while (swapped == true) {
        swapped = false;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] > inputArray[i + 1]) {
                swapElements(inputArray, i, i+1);
                swapped = true;
            }
        }
    }
        return inputArray;
    }
}
