package datastructure;

import java.util.ArrayList;

/**
 * Created by Francisco Yllera.
 */
public class MinHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    /**
     * Get the smallest value of the Heap
     * O(1)
     * @return
     */
    public int findMin() {
        return heap.get(0);
    }

    /**
     * Get the Heap size
     * @return
     */
    public int size() {
        return heap.size();
    }

    /**
     * Insert an element to the Heap.
     * O(log n)
     * @param element
     */
    public void insert(int element) {
        heap.add(element);
        int index = heap.size() - 1;

        while (element < getParent(index) && index > 0) {
            heap.set(index, getParent(index));
            heap.set(getParentIndex(index), element);
            index = getParentIndex(index);
        }
    }

    /**
     * Remove the smallest element of the Heap
     * O(log n)
     * @return the smallest element
     */
    public int extractMin() {
        int smallerChild = heap.get(0);
        heap.set(0, heap.get(heap.size() -1));
        heap.remove(heap.size() -1);

        int index = 0;
        int childrenCount = getChildrenCount(index);
        while (childrenCount > 0) {
            int childToSwapIndex = (childrenCount == 2) ? getSmallerChildIndex(index) : getIndexFromChild(index, 1);
            int indexVal = heap.get(index);

            if (indexVal > heap.get(childToSwapIndex)) {
                heap.set(index, heap.get(childToSwapIndex));
                heap.set(childToSwapIndex, indexVal);
                index = childToSwapIndex;
                childrenCount = getChildrenCount(index);
            } else {
                break;
            }
        }
        return smallerChild;
    }

    protected int getSmallerChildIndex(int index) {
        return heap.get(getIndexFromChild(index, 1)) < heap.get(getIndexFromChild(index, 2)) ? getIndexFromChild(index, 1) : getIndexFromChild(index, 2);
    }

    protected int getChildrenCount(int index) {
        if (getIndexFromChild(index, 2) < heap.size()) {
            return 2;
        } else if (getIndexFromChild(index, 1) < heap.size()) {
            return 1;
        }
        return 0;
    }

    protected int getIndexFromChild(int index, int child) {
        return (2 * index) + child;
    }

    protected int getParent(int index) {
        return heap.get(getParentIndex(index));
    }

    protected int getParentIndex(int index) {
        return (index - 1)/2;
    }
}
