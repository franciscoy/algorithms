package algorithm.search.impl;

import algorithm.search.SearchAlgorithm;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BinarySearchTest extends AbstractSearchAlgorithm{

    BinarySearch binarySearch = new BinarySearch();

    @Override
    public SearchAlgorithm getSearchAlgorithm() {
        return new BinarySearch();
    }

    @Test
    public void whenRecursiveSearchingElementPresentInArrayReturnIt() {
        assertEquals(elementPresentPosition, binarySearch.searchRecursive(elementArray, elementPresent));
    }

    @Test
    public void whenRecursiveSearchingElementPresentInOneElementArrayReturnIt() {
        assertEquals(0, binarySearch.searchRecursive(oneElementArray, elementPresent));
    }

    @Test
    public void whenRecursiveSearchingElementNotPresentInArrayReturnMinusOne() {
        assertEquals(-1, binarySearch.searchRecursive(elementArray, elementNotPresent));
    }

    @Test
    public void whenRecursiveSearchingElementNotPresentInOneElementArrayReturnMinusOne() {
        assertEquals(-1, binarySearch.searchRecursive(oneElementArray, elementNotPresent));
    }
}