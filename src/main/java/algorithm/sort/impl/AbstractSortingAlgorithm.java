package algorithm.sort.impl;

/**
 * Created by Francisco Yllera.
 */
public abstract class AbstractSortingAlgorithm {

    /**
     * Swaps the emelements of an array.
     *
     * @param  inputArray the array to swap the elements
     * @param  i the first index to be swaped
     * @param  j the second index to swap his element
     * @return  the inputArray with swaped elements
     */
    protected int[] swapElements(int[] inputArray, int i, int j) {
        int swap = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = swap;

        return inputArray;
    }
}
