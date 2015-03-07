package datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {

    @Test
    public void whenHeapHasOneElementReturnItInFindMin(){
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        assertEquals(10, minHeap.findMin());
    }

    @Test
    public void whenHeapHasEvenElementsReturnCorrectFindMin() {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(11);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(23);
        minHeap.insert(17);
        minHeap.insert(30);

        assertEquals(5, minHeap.findMin());
    }

    @Test
    public void whenHeapHasOddElementsReturnCorrectFindMin() {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(11);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(23);
        minHeap.insert(17);

        assertEquals(5, minHeap.findMin());
    }

    @Test
    public void whenExtractMinElementsReturnCorrectFindMin() {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(11);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(23);
        minHeap.insert(17);

        minHeap.extractMin();
        assertEquals(7, minHeap.findMin());
        minHeap.extractMin();
        assertEquals(10, minHeap.findMin());
        minHeap.extractMin();
        assertEquals(11, minHeap.findMin());
    }

    @Test
    public void whenExtractMinElementsReturnCorrectElement() {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(11);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(23);
        minHeap.insert(17);

        assertEquals(5, minHeap.extractMin());
        assertEquals(7, minHeap.findMin());
    }
}