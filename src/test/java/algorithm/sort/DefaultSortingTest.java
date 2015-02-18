package algorithm.sort;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Francisco Yllera.
 */
public abstract class DefaultSortingTest {
    private final int[] oneElementArray = {1};
    protected final int[] unsortedArray = {2,3,10,6,1,25,44,7};
    protected final int[] sortedArray = {1,2,3,6,7,10,25,44};

    protected final int[] unsortedArrayWithRepeatedElements = {2,3,10,10,1,6,1,25,44,2,7};
    protected final int[] sortedArrayWithRepeatedElements = {1,1,2,2,3,6,7,10,10,25,44};

    protected abstract SortingAlgorithm getSortingAlgorithm();

    @Test
    public void testCorrectReturnWhenArrayContainsOneElement() {
        assertArrayEquals(oneElementArray, getSortingAlgorithm().sort(oneElementArray));
    }

    @Test
    public void testCorrectSortingOfUnsortedArray() {
        assertArrayEquals(sortedArray, getSortingAlgorithm().sort(unsortedArray));
    }

    @Test
    public void testCorrectSortingOfUnsortedArrayWithRepeatedElements() {
        assertArrayEquals(sortedArrayWithRepeatedElements, getSortingAlgorithm().sort(unsortedArrayWithRepeatedElements));
    }
}
