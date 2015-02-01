package algorithm.sort.impl;

import algorithm.sort.DefaultSortingTest;
import algorithm.sort.SortingAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class BubbleSortTest extends DefaultSortingTest {
    @Override
    protected SortingAlgorithm getSortingAlgorithm() {
        return new BubbleSort();
    }
}
