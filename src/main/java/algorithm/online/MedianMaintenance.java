package algorithm.online;

import datastructure.MaxHeap;
import datastructure.MinHeap;

/**
 * Created by Francisco Yllera.
 */
public class MedianMaintenance {

    MinHeap minHeap;
    MaxHeap maxHeap;

    public MedianMaintenance() {
        this.minHeap = new MinHeap();
        this.maxHeap = new MaxHeap();
    }

    /**
     * Given a stream of numbers, find the median for each new number in O(log n):
     * It can be done using Heaps, for the left side of the array from the heap use
     * MaxHeap and the other part a MinHeap, the median will be one of those min/max.
     * If one heap has 2 more elements than the other we balance them extracting one and inserting
     * in the other.
     *
     * O(log n)
     *
     * @param value
     */
    public void insert(int value) {
        if (areHeapBalanced()) {
            if (maxHeap.size() == 0 || value < maxHeap.findMax()) {
                maxHeap.insert(value);
            } else {
                minHeap.insert(value);
            }
        } else {
            if (value < maxHeap.findMax()) {
                maxHeap.insert(value);
            } else {
                minHeap.insert(value);
            }
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.insert(minHeap.extractMin());
            } else if (maxHeap.size() > minHeap.size()) {
                minHeap.insert(maxHeap.extractMax());
            }
        }
    }

    /**
     * Get the median from the unbalanced Heap or from the avg of both
     * O(1)
     * @return
     */
    public double getMedian() {
        if (!areHeapBalanced()) {
            if (minHeap.size() == 0 || minHeap.size() < maxHeap.size()) {
                return maxHeap.findMax();
            } else {
                return minHeap.findMin();
            }
        } else {
            return ((double)maxHeap.findMax() + (double)minHeap.findMin()) / 2;
        }
    }

    protected boolean areHeapBalanced() {
        return minHeap.size() % 2 == maxHeap.size() % 2;
    }
}
