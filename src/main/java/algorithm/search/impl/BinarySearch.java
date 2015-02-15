package algorithm.search.impl;

import algorithm.search.SearchAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class BinarySearch implements SearchAlgorithm{

    /**
     * Search for an element in an array cutting it in half while searching.
     * Iterative implementation. O(log n)
     * @param inputArray
     * @param needle
     * @return index if found, -1 if not
     */
    @Override
    public int search(int[] inputArray, int needle) {
        int start = 0;
        int end = inputArray.length - 1;
        while (start <= end) {
            int guess = (start + end)/2;
            if (inputArray[guess] == needle){
                return guess;
            }
            else if (inputArray[guess] < needle) {
                start = guess + 1;
            }
            else {
                end = guess - 1;
            }
        }
        return -1;
    }

    /**
     * Search for an element in an array cutting it in half while searching.
     * Recursive implementation. O(log n)
     * @param inputArray
     * @param needle
     * @return index if found, -1 if not
     */
    public int searchRecursive(int[] inputArray, int needle, int start, int end) {
        if (start > end) {
            return -1;
        }
        int guess = (end + start) / 2;

        if(needle == inputArray[guess]) {
            return guess;
        } else if(needle < inputArray[guess]) {
            return searchRecursive(inputArray, needle, start, guess);
        } else {
            return searchRecursive(inputArray, needle, guess + 1, end);
        }
    }

    public int searchRecursive(int[] inputArray, int needle) {
        return searchRecursive(inputArray, needle, 0, inputArray.length - 1);
    }
}
