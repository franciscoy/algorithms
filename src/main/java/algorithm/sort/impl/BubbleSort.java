package algorithm.sort.impl;

import algorithm.AbstractAlgorithm;
import algorithm.sort.SortingAlgorithm;

import static algorithm.utils.ArrayPrintUtils.printArr;

/**
 * Created by Francisco Yllera.
 */
public class BubbleSort extends AbstractAlgorithm implements SortingAlgorithm{

    @Override
    public int[] sort(int[] inputArray) {
    boolean swapped = true;
    while (swapped == true) {
        swapped = false;
        for (int i = 0; i < inputArray.length - 1; i++) {
            int currentValue = inputArray[i];
            if (currentValue > inputArray[i + 1]) {
                inputArray[i] = inputArray[i + 1];
                inputArray[i + 1] = currentValue;
                swapped = true;
            }
        }
    }
        return inputArray;
    }
}
