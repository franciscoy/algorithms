package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;

import java.util.Random;

import static algorithm.utils.ArrayUtils.printArr;

/**
 * Created by Francisco Yllera.
 */
public class QuickSort extends AbstractSortingAlgorithm implements SortingAlgorithm {

    Random random = new Random();

    /**
     * Quick sort by divide and conquer.
     * Partition elements left and right to a randomly selected pivot, therefore sorting the pivot.
     * Then recursively sorting the left and right pivots in their positions;
     * Avg case O(n log n), worst case O(n^2), but with the random pivots most of the time its avg case.
     * @param inputArray
     * @return sorted array
     */
    @Override
    public int[] sort(int[] inputArray) {
        if (inputArray.length < 2) {
            return inputArray;
        }
        return sortDivideAndConquer(inputArray, 0, inputArray.length - 1);
    }

    protected int[] sortDivideAndConquer(int[] inputArray, int startIndex, int endIndex) {
        if(endIndex - startIndex == 0 || endIndex < startIndex) {
            return null;
        }

        int pivot = choosePivot(startIndex, endIndex);
        pivot = partitionByPivot(inputArray, startIndex, endIndex, pivot);
        sortDivideAndConquer(inputArray, startIndex, pivot - 1);
        sortDivideAndConquer(inputArray, pivot + 1, endIndex);

        return inputArray;
    }

    /**
     * Partition the array by a random pivot, the elements lower than the pivot's value go to the left,
     * the bigger to the right, they don't need to be ordered.
     * Since it scans the array once it's, O(n).
     * @param inputArray
     * @param startIndex
     * @param endIndex
     * @param pivotIndex
     * @return the pivot position, so than the next calls partition both sides of it.
     */
    protected int partitionByPivot(int[] inputArray, int startIndex, int endIndex, int pivotIndex) {
        if (pivotIndex > startIndex) {
            swapElements(inputArray, pivotIndex, startIndex);
        }
        int pivotPosition = pivotIndex;
        int orderedBound = startIndex + 1;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if(inputArray[i] <= inputArray[startIndex]) {
                swapElements(inputArray, i, orderedBound);
                orderedBound++;
            }
        }
        if (orderedBound > 1) {
            swapElements(inputArray, startIndex, orderedBound - 1);
            pivotPosition = orderedBound - 1;
        }
        return pivotPosition;
    }

    /**
     * Random pivot generation.
     * @param startIndex
     * @param endIndex
     * @return array index when the pivot will be.
     */
    protected int choosePivot(int startIndex, int endIndex) {
        return random.nextInt(endIndex - startIndex + 1) + startIndex;
    }
}
