package algorithm.sort.impl;

import algorithm.sort.DefaultSortingTest;
import algorithm.sort.SortingAlgorithm;

public class HeapSortTest extends DefaultSortingTest {

    @Override
    protected SortingAlgorithm getSortingAlgorithm() {
        return new HeapSort();
    }
}