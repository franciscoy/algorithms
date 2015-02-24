package algorithm.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest extends GraphTest{

    private BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Test
    public void whenSearchingVertexInAnAcyclicGraphReturnCorrect() {
        assertEquals(4, breadthFirstSearch.findVertex(getAdjacencyArrayListForBasicGraph(), 1, 4));
    }

    @Test
    public void whenSearchingVertexInACyclicGraphReturnCorrect() {
        assertEquals(5, breadthFirstSearch.findVertex(getAdjacencyArrayListForCyclicGraph(), 1, 5));
    }

    @Test
    public void whenSearchingVertexInAnUnconnectedCyclicGraphReturnFailure() {
        assertEquals(-1, breadthFirstSearch.findVertex(getAdjacencyArrayListForUnconnectedCyclicGraph(), 1, 7));
    }

    @Test
    public void whenSearchingNonExistingVertexInACyclicGraphReturnFailure() {
        assertEquals(-1, breadthFirstSearch.findVertex(getAdjacencyArrayListForCyclicGraph(), 1, 7));
    }

}