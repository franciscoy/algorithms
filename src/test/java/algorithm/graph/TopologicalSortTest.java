package algorithm.graph;

import org.junit.Test;

import java.util.Deque;
import java.util.Iterator;

import static org.junit.Assert.assertArrayEquals;

public class TopologicalSortTest extends GraphTest {

    TopologicalSort topologicalSort = new TopologicalSort();

    @Test
    public void whenSortingADirectedAcyclicGraphReturnsCorrect() {
        int[] expectedArray = {5,3,4,1,2};

        assertArrayEquals(expectedArray, stackToArray(topologicalSort.sortDirectedGraph(getAdjacencyArrayListForDirectedAcyclicGraph())));
    }

    @Test
    public void whenSortingATotallyUnconnectedGraphReturnsCorrect() {
        int[] expectedArray = {5,4,3,2,1};

        assertArrayEquals(expectedArray, stackToArray(topologicalSort.sortDirectedGraph(getAdjacencyArrayListForTotallyUnconnectedGraph())));
    }

    private int[] stackToArray(Deque<Integer> stack) {
        int[] array = new int[stack.size()];
        int count = 0;
        for (Iterator<Integer> i = stack.iterator(); i.hasNext();) {
            array[count++] = i.next();
        }

        return array;
    }
}