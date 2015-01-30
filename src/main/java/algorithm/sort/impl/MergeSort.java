package algorithm.sort.impl;

import algorithm.AbstractAlgorithm;
import algorithm.sort.SortingAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class MergeSort extends AbstractAlgorithm implements SortingAlgorithm {

    @Override
    public int[] sort(int[] inputArray) {
        if (inputArray.length <= 1) {
            return inputArray;
        }

        int firstArrayIndex = inputArray.length / 2;
        int[] firstArray = copyArray(inputArray, 0, firstArrayIndex);
        int[] secondArray = copyArray(inputArray, firstArrayIndex, inputArray.length);

        sort(firstArray);
        sort(secondArray);

        mergeOrderedArrays(firstArray, secondArray, inputArray);

        return inputArray;
    }

    /**
     * Copies an array into a new one, not including the last index.
     *
     * @param  inputArray is the populated array
     * @param  firstArrayIndex the index from which the array will be started to been copied
     * @param  lastArrayIndex the final index to copy, not included in the copied array
     * @return  an int array copied between the bounds
     */
    protected int[] copyArray(int[] inputArray, int firstArrayIndex, int lastArrayIndex) {
        int[] copiedArray = new int[lastArrayIndex - firstArrayIndex];
        int j = 0;
        for (int i = firstArrayIndex; i < lastArrayIndex; i++) {
            copiedArray[j] = inputArray[i];
            j++;
        }

        return copiedArray;
    }

    /**
     * Given two ordered arrays, fills other with the ordered elements of both.
     *
     * @param  firstArray is the populated array
     * @param  secondArray the index from which the array will be started to been copied
     * @param  mergedArray the final index to copy, not included in the copied array
     * @return  nothing, it populate's the mergedArray
     */
    protected void mergeOrderedArrays(int[] firstArray, int[] secondArray, int[] mergedArray) {
        int firstArrayIndex=0, secondArrayIndex=0, mergedArrayIndex=0;

        while (firstArrayIndex < firstArray.length && secondArrayIndex < secondArray.length) {
            mergedArray[mergedArrayIndex++] = (firstArray[firstArrayIndex] > secondArray[secondArrayIndex])
                    ? secondArray[secondArrayIndex++] : firstArray[firstArrayIndex++];
        }

        while (firstArrayIndex < firstArray.length) {
            mergedArray[mergedArrayIndex++] = firstArray[firstArrayIndex++];
        }

        while (secondArrayIndex < secondArray.length) {
            mergedArray[mergedArrayIndex++] = secondArray[secondArrayIndex++];
        }
    }
}
