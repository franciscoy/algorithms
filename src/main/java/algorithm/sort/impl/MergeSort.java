package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;

import static algorithm.utils.ArrayUtils.copyArray;

/**
 * Created by Francisco Yllera.
 */
public class MergeSort extends AbstractSortingAlgorithm implements SortingAlgorithm {

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
