package algorithm.sort.impl;

import algorithm.sort.DefaultSortingTest;
import algorithm.sort.SortingAlgorithm;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Francisco Yllera.
 */
public class MergeSortTest extends DefaultSortingTest {
    private int[] oneElemArray = {2};
    private int[] oneElemArray2 = {1};
    private int[] twoElemExpectedArray = {1,2};

    private int[] severalElemArray = {4,15,16,50};
    private int[] severalElemArray2 = {8,23,42,108};
    private int[] severalElemExpectedArray = {4,8,15,16,23,42,50,108};

    private int[] emptyElemArray = {};

    MergeSort mergeSort;

    public MergeSortTest() {
        mergeSort = new MergeSort();
    }

    @Override
    protected SortingAlgorithm getSortingAlgorithm() {
        return mergeSort;
    }

    @Test
    public void testMergeArraysOfOneElement() {
        int[] mergedArr = new int[oneElemArray.length + oneElemArray2.length];
        mergeSort.mergeOrderedArrays(oneElemArray, oneElemArray2, mergedArr);
        assertArrayEquals(mergedArr, twoElemExpectedArray);

        int[] mergedArr2 = new int[oneElemArray.length + oneElemArray2.length];
        mergeSort.mergeOrderedArrays(oneElemArray2, oneElemArray, mergedArr2);
        assertArrayEquals(mergedArr2, twoElemExpectedArray);
    }

    @Test
    public void testMergeOrderedElementsArrays() {
        int[] mergedArr = new int[severalElemArray.length + severalElemArray2.length];
        mergeSort.mergeOrderedArrays(severalElemArray, severalElemArray2, mergedArr);
        assertArrayEquals(mergedArr, severalElemExpectedArray);

        int[] mergedArr2 = new int[severalElemArray.length + severalElemArray2.length];
        mergeSort.mergeOrderedArrays(severalElemArray2, severalElemArray, mergedArr2);
        assertArrayEquals(mergedArr2, severalElemExpectedArray);
    }

    @Test
    public void testMergeOrderedElementsArrayWithEmptyArray() {
        int[] mergedArr = new int[severalElemArray.length + emptyElemArray.length];
        mergeSort.mergeOrderedArrays(severalElemArray, emptyElemArray, mergedArr);
        assertArrayEquals(mergedArr, severalElemArray);

        int[] mergedArr2 = new int[emptyElemArray.length + severalElemArray.length];
        mergeSort.mergeOrderedArrays(emptyElemArray, severalElemArray, mergedArr2);
        assertArrayEquals(mergedArr2, severalElemArray);
    }
}
