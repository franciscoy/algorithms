package algorithm.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountConnectedComponentsBFSTest extends GraphTest{

    CountConnectedComponentsBFS countConnectedComponentsBFS = new CountConnectedComponentsBFS();

    @Test
    public void whenCountingFromConnectedGraphReturnOne() {
        assertEquals(1, countConnectedComponentsBFS.countConnectedComponents(getAdjacencyArrayListForCyclicGraph()));
    }

    @Test
    public void whenCountingFromUnconnectedGraphReturnCorrect() {
        assertEquals(2, countConnectedComponentsBFS.countConnectedComponents(getAdjacencyArrayListForUnconnectedCyclicGraph()));
    }

    @Test
    public void whenCountingFromTotallyUnconnectedGraphReturnVerticesCount() {
        assertEquals(5, countConnectedComponentsBFS.countConnectedComponents(getAdjacencyArrayListForTotallyUnconnectedCyclicGraph()));
    }
}