package algorithm.search.impl;

import algorithm.sort.impl.QuickSort;

/**
 * Created by Francisco Yllera.
 */
public class QuickSelect extends QuickSort{

    /**
     * Divide and Conquer algorithm.
     * Find the smallest kth order statistic element in the array, starting with 0.
     * It uses partition by a random pivot like quick sort.
     * T(n) = 1(n/2) + O(n)
     * Assuming the random pivot tends to cut nearly by the half, with master method =>
     * Avg. upper bound = O(n)
     * @param inputArray
     * @param kth
     * @return the value of kth order statistic element
     */
    public int findKthOrderStatistic(int[] inputArray, int kth) {
        return findKthOrderStatistic(inputArray, 0, inputArray.length - 1, kth);
    }

    private int findKthOrderStatistic(int[] inputArray, int startIndex, int endIndex, int kth) {
        if (inputArray.length == 1) {
            return inputArray[startIndex];
        }
        int pivot = choosePivot(startIndex, endIndex);
        pivot = partitionByPivot(inputArray, startIndex, endIndex, pivot);
        if (pivot == kth) {
            return inputArray[pivot];
        } else if (pivot < kth) {
            return findKthOrderStatistic(inputArray, pivot + 1, endIndex, kth);
        } else {
            return findKthOrderStatistic(inputArray, startIndex, pivot - 1, kth);
        }
    }
}
