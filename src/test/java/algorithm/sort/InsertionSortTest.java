package algorithm.sort;

/**
 * Created by Francisco Yllera.
 */
public class InsertionSortTest extends DefaultSortingTest{

    @Override
    protected SortingAlgorithm getSortingAlgorithm() {
        return new InsertionSort();
    }
}
