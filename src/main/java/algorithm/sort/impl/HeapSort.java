package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;
import datastructure.MinHeap;

/**
 * Created by Francisco Yllera.
 */
public class HeapSort extends AbstractSortingAlgorithm implements SortingAlgorithm {

    /**
     * Sort uginf a Min-Heap
     * @param inputArray
     * @return
     */
    @Override
    public int[] sort(int[] inputArray) {
        MinHeap minHeap = new MinHeap();

        //TODO it's better with heapify, (O(n)) instead of O(n logn)
        for (int i = 0; i < inputArray.length; i++) {
            minHeap.insert(inputArray[i]);
        }

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = minHeap.extractMin();
        }

        return inputArray;
    }
}
