package algorithm.sort.impl;

import algorithm.sort.DefaultSortingTest;
import algorithm.sort.SortingAlgorithm;

/**
 * Created by Francisco Yllera.
 */
public class InsertionSortTest extends DefaultSortingTest {

    @Override
    protected SortingAlgorithm getSortingAlgorithm() {
        return new InsertionSort();
    }
}
