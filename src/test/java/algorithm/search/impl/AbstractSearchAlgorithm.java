package algorithm.search.impl;

import algorithm.search.SearchAlgorithm;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Francisco Yllera.
 */
public abstract class AbstractSearchAlgorithm {

    public abstract SearchAlgorithm getSearchAlgorithm();
    SearchAlgorithm searchAlgorithm = getSearchAlgorithm();

    int elementPresent = 50;
    int elementPresentPosition = 14;
    int elementNotPresent = 51;
    int[] elementArray = {1,2,3,4,5,6,6,7,8,9,10,20,30,40,50};
    int[] oneElementArray = {50};

    @Test
    public void whenSearchingElementPresentInArrayReturnIt() {
        assertEquals(elementPresentPosition, searchAlgorithm.search(elementArray, elementPresent));
    }

    @Test
    public void whenSearchingElementPresentInOneElementArrayReturnIt() {
        assertEquals(0, searchAlgorithm.search(oneElementArray, elementPresent));
    }

    @Test
    public void whenSearchingElementNotPresentInArrayReturnMinusOne() {
        assertEquals(-1, searchAlgorithm.search(elementArray, elementNotPresent));
    }

    @Test
    public void whenSearchingElementNotPresentInOneElementArrayReturnMinusOne() {
        assertEquals(-1, searchAlgorithm.search(oneElementArray, elementNotPresent));
    }
}
