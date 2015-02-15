package algorithm.search.impl;

import algorithm.search.SearchAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class LinearSearch implements SearchAlgorithm {

    /**
     * Basic linear search, scan the whole array in search for the element.
     * O(n)
     * @param inputArray
     * @param needle
     * @return index position in array, -1 if not found.
     */
    @Override
    public int search(int[] inputArray, int needle) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == needle) {
                return i;
            }
        }
        return -1;
    }
}
