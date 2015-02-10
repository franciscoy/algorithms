package algorithm.count;

import static algorithm.utils.ArrayUtils.copyArray;

/**
 * Created by Francisco Yllera.
 */
public class CountInversionByMergeSort implements CountInversion {

    /**
     * Returns the counting inversions from an array using Mergesort.
     *
     * @param inputArray
     * @return the count of inversions.
     */
    public int count(int[] inputArray) {
        if (inputArray.length <= 1) {
            return 0;
        }

        int firstArrayIndex = (inputArray.length / 2) + (inputArray.length % 2);
        int[] firstArray = copyArray(inputArray, 0, firstArrayIndex);
        int[] secondArray = copyArray(inputArray, firstArrayIndex, inputArray.length);

        return count(firstArray) + count(secondArray) + mergeAndCountInversions(firstArray, secondArray, inputArray);
    }

    /**
     * Based on the merge function from mergeSort O(n), but adding the count for inversions.
     * Since arrays are ordered and the left array should have smaller elements than the right one,
     * If an left elem is bigger than the right one, its an inversion, and the rest of the elements from the left
     * are inversions too, remember that they are ordered therefore bigger than the right element.
     *
     * @param leftArray
     * @param rightArr
     * @param mergedArray
     * @return inversion count in the merge between left and right arrays.
     */
    public int mergeAndCountInversions(int[] leftArray, int[] rightArr, int[] mergedArray) {
        int firstIndex = 0, secondIndex = 0, count = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            if (secondIndex >= rightArr.length || (firstIndex < leftArray.length && rightArr[secondIndex] > leftArray[firstIndex])) {
                mergedArray[i] = leftArray[firstIndex];
                firstIndex++;
            } else {
                //since elems are ordered, if the left array element is bigger, the rest(firstArr.length - firstIndex) are also bigger
                if (leftArray.length > firstIndex) {
                    count+= leftArray.length - firstIndex;
                }
                mergedArray[i] = rightArr[secondIndex];
                secondIndex++;
            }
        }

        return count;
    }
}
