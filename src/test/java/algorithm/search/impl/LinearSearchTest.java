package algorithm.search.impl;

import algorithm.search.SearchAlgorithm;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LinearSearchTest extends AbstractSearchAlgorithm{

    @Override
    public SearchAlgorithm getSearchAlgorithm() {
        return new LinearSearch();
    }

    int[] elementArray = {10,3,2,15,4,5,6,8,20,30,40,50,1,7};
    int elementPresentIndex = 11;

    @Test
    public void whenSearchingElementPresentInUnorderedArrayReturnIt() {
        assertEquals(elementPresentIndex, searchAlgorithm.search(elementArray, elementPresent));
    }
}