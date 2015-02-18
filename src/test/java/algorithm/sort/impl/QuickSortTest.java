package algorithm.sort.impl;

import algorithm.sort.DefaultSortingTest;
import algorithm.sort.SortingAlgorithm;
import org.junit.Test;

import static algorithm.utils.ArrayUtils.printArr;
import static org.junit.Assert.*;

public class QuickSortTest  extends DefaultSortingTest {

    QuickSort qs = new QuickSort();

    @Override
    protected SortingAlgorithm getSortingAlgorithm() {
        return new QuickSort();
    }

    @Test
    public void testPartitionByPivotWhenFullArrayByHalf() throws Exception {
        int[] testArray = {3,8,5,1,6,2,7,4};
        int[] partitionedArray = {4,5,1,3,2,6,7,8};

        assertEquals(5, qs.partitionByPivot(testArray, 0, testArray.length - 1, 4));
        assertArrayEquals(partitionedArray, testArray);
    }

    @Test
    public void testPartitionByPivotWhenFullArrayByFirstElement() throws Exception {
        int[] testArray = {3,8,5,1,6,2,7,4};
        int[] partitionedArray = {2,1,3,8,6,5,7,4};

        assertEquals(2, qs.partitionByPivot(testArray, 0, testArray.length - 1, 0));
        assertArrayEquals(partitionedArray, testArray);
    }

    @Test
    public void testPartitionByPivotWhenSecondHalfArrayByHalf() throws Exception {
        int[] testArray = {3,8,5,1,6,2,7,4};
        int[] partitionedArray = {3,8,5,1,4,2,6,7};

        assertEquals(7, qs.partitionByPivot(testArray, 4, testArray.length - 1, 6));
        assertArrayEquals(partitionedArray, testArray);
    }

    @Test
    public void testPartitionByPivotWhenSecondHalfArrayByLast() throws Exception {
        int[] testArray = {3,8,5,1,6,2,7,4};
        int[] partitionedArray = {3,8,5,1,2,4,7,6};

        assertEquals(5, qs.partitionByPivot(testArray, 4, testArray.length - 1, testArray.length - 1));
        assertArrayEquals(partitionedArray, testArray);
    }

    @Test
    public void testChoosePivot() throws Exception {
        int pivot = qs.choosePivot(0, 2);
        assertTrue(pivot >= 0 && pivot <= 2);
    }
}