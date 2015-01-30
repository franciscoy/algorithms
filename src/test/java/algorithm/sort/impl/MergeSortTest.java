package algorithm.sort.impl;

import algorithm.sort.DefaultSortingTest;
import algorithm.sort.SortingAlgorithm;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Francisco Yllera.
 */
public class MergeSortTest extends DefaultSortingTest {
    private int[] ONE_ELEM_ARR = {2};
    private int[] ONE_ELEM_ARR_2 = {1};
    private int[] TWO_ELEM_EXPECTED_ARR = {1,2};

    private int[] SEVERAL_ELEM_ARR = {4,15,16,50};
    private int[] SEVERAL_ELEM_ARR_2 = {8,23,42,108};
    private int[] SEVERAL_ELEM_EXPECTED_ARR = {4,8,15,16,23,42,50,108};

    private int[] EMPTY_ELEM_ARR = {};

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
        int[] mergedArr = new int[ONE_ELEM_ARR.length + ONE_ELEM_ARR_2.length];
        mergeSort.mergeOrderedArrays(ONE_ELEM_ARR, ONE_ELEM_ARR_2, mergedArr);
        assertArrayEquals(mergedArr, TWO_ELEM_EXPECTED_ARR);

        int[] mergedArr2 = new int[ONE_ELEM_ARR.length + ONE_ELEM_ARR_2.length];
        mergeSort.mergeOrderedArrays(ONE_ELEM_ARR_2, ONE_ELEM_ARR, mergedArr2);
        assertArrayEquals(mergedArr2, TWO_ELEM_EXPECTED_ARR);
    }

    @Test
    public void testMergeOrderedElementsArrays() {
        int[] mergedArr = new int[SEVERAL_ELEM_ARR.length + SEVERAL_ELEM_ARR_2.length];
        mergeSort.mergeOrderedArrays(SEVERAL_ELEM_ARR, SEVERAL_ELEM_ARR_2, mergedArr);
        assertArrayEquals(mergedArr, SEVERAL_ELEM_EXPECTED_ARR);

        int[] mergedArr2 = new int[SEVERAL_ELEM_ARR.length + SEVERAL_ELEM_ARR_2.length];
        mergeSort.mergeOrderedArrays(SEVERAL_ELEM_ARR_2, SEVERAL_ELEM_ARR, mergedArr2);
        assertArrayEquals(mergedArr2, SEVERAL_ELEM_EXPECTED_ARR);
    }

    @Test
    public void testMergeOrderedElementsArrayWithEmptyArray() {
        int[] mergedArr = new int[SEVERAL_ELEM_ARR.length + EMPTY_ELEM_ARR.length];
        mergeSort.mergeOrderedArrays(SEVERAL_ELEM_ARR, EMPTY_ELEM_ARR, mergedArr);
        assertArrayEquals(mergedArr, SEVERAL_ELEM_ARR);

        int[] mergedArr2 = new int[EMPTY_ELEM_ARR.length + SEVERAL_ELEM_ARR.length];
        mergeSort.mergeOrderedArrays(EMPTY_ELEM_ARR, SEVERAL_ELEM_ARR, mergedArr2);
        assertArrayEquals(mergedArr2, SEVERAL_ELEM_ARR);
    }

    @Test
    public void testCopyArray() {
        int startIndex = 0;
        int lastIndex = SEVERAL_ELEM_EXPECTED_ARR.length - 2;
        int[] copiedArray = mergeSort.copyArray(SEVERAL_ELEM_EXPECTED_ARR, startIndex, lastIndex);
        int[] expectedArray = {4,8,15,16,23,42};

        assertArrayEquals(copiedArray, expectedArray);
    }
}
