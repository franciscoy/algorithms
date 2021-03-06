package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class ShellSort extends AbstractSortingAlgorithm implements SortingAlgorithm {

    @Override
    public int[] sort(int[] inputArray) {
        int gap = inputArray.length / 2;
        while (gap > 0) {
            for (int i = 0; i < (inputArray.length - gap); i++) {
                for (int j = i; j + gap < inputArray.length ; j = j + gap) {
                    if (inputArray[j] > inputArray[j + gap]) {
                        swapElements(inputArray, j, j+ gap);
                    }
                }
            }
            gap /= 2;
        }
        return inputArray;
    }
}
