package algorithm.sort;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Francisco Yllera.
 */
public abstract class DefaultSortingTest {
    private SortingAlgorithm sortingAlgorithm;
    private static final int[] ONE_ELEMENT_DATASET = {1};
    private static final int[] UNSORTED_DATASET = {2,3,10,10,6,1,25,44,7};
    private static final int[] SORTED_DATASET = {1,2,3,6,7,10,10,25,44};

    protected abstract SortingAlgorithm getSortingAlgorithm();

    {
        this.sortingAlgorithm = getSortingAlgorithm();
    }

    @Test
    public void testCorrectReturnWhenArrayContainsOneElement() {
        assertEquals(this.sortingAlgorithm.sort(ONE_ELEMENT_DATASET), ONE_ELEMENT_DATASET);
    }

    @Test
    public void testCorrectSortingOfUnsortedArray() {
        assertArrayEquals(this.sortingAlgorithm.sort(UNSORTED_DATASET), SORTED_DATASET);
    }


}
