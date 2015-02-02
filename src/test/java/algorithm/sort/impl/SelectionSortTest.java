package algorithm.sort.impl;

import algorithm.sort.DefaultSortingTest;
import algorithm.sort.SortingAlgorithm;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Francisco Yllera.
 */
public class SelectionSortTest extends DefaultSortingTest {
    @Override
    protected SortingAlgorithm getSortingAlgorithm() {
        return new SelectionSort();
    }

    @Test
    public void testSwappingElementsIsCorrect() {
        int[] array = {1,2,3};
        int[] swappedElementsArray = {3,2,1};

        assertArrayEquals(new BubbleSort().swapElements(array, 0, 2), swappedElementsArray);
    }
}
