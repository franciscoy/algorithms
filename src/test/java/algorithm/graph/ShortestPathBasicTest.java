package algorithm.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathBasicTest extends GraphTest{

    ShortestPathBasic shortestPathBasic = new ShortestPathBasic();

    @Test
    public void whenFindingShortestPathInAcyclicGraphReturnCorrect() {
        assertEquals(3, shortestPathBasic.findShortestPath(getAdjacencyArrayListForBasicGraph(),1,4));
    }

    @Test
    public void whenFindingShortestPathInCyclicGraphReturnCorrect() {
        assertEquals(2, shortestPathBasic.findShortestPath(getAdjacencyArrayListForCyclicGraph(),1,5));
    }

    @Test
    public void whenFindingShortestPathInAcyclicMultiGraphReturnCorrect() {
        assertEquals(3, shortestPathBasic.findShortestPath(getAdjacencyArrayListForMultiGraph(),1,4));
    }

    @Test
    public void whenFindingShortestPathInUnconnectedGraphReturnFailure() {
        assertEquals(-1, shortestPathBasic.findShortestPath(getAdjacencyArrayListForUnconnectedCyclicGraph(),1,7));
    }

    @Test
    public void whenFindingShortestPathToNonExistingVertexInAcyclicGraphReturnCorrect() {
        assertEquals(-1, shortestPathBasic.findShortestPath(getAdjacencyArrayListForBasicGraph(),1,6));
    }
}