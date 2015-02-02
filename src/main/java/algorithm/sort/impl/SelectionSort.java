package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class SelectionSort extends AbstractSortingAlgorithm implements SortingAlgorithm {

    @Override
    public int[] sort(int[] inputArray) {
        int currentLowest = 0;
        int lowestIndex = 0;

        for (int i = 0; i < inputArray.length; i++) {
            currentLowest = inputArray[i];
            lowestIndex = i;

            for (int j = i; j < inputArray.length; j++) {
                if (currentLowest > inputArray[j]) {
                    currentLowest = inputArray[j];
                    lowestIndex = j;
                }
            }

            swapElements(inputArray, i, lowestIndex);
        }

        return inputArray;
    }
}
