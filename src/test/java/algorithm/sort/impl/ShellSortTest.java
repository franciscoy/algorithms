package algorithm.sort.impl;

import algorithm.sort.DefaultSortingTest;
import algorithm.sort.SortingAlgorithm;

/**
 * Created by fyllera on 2/2/15.
 */
public class ShellSortTest extends DefaultSortingTest {

    @Override
    protected SortingAlgorithm getSortingAlgorithm() {
        return new ShellSort();
    }
}
