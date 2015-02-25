package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Francisco Yllera.
 */
public abstract class AbstractSearchTest extends GraphTest{
    public abstract GraphSearch getGraphSearch();

    @Test
    public void whenSearchingVertexInAnAcyclicGraphReturnCorrect() {
        assertEquals(4, getGraphSearch().findVertex(getAdjacencyArrayListForBasicGraph(), 1, 4));
    }

    @Test
    public void whenSearchingVertexInACyclicGraphReturnCorrect() {
        assertEquals(5, getGraphSearch().findVertex(getAdjacencyArrayListForCyclicGraph(), 1, 5));
    }

    @Test
    public void whenSearchingVertexInAnUnconnectedCyclicGraphReturnFailure() {
        assertEquals(-1, getGraphSearch().findVertex(getAdjacencyArrayListForUnconnectedCyclicGraph(), 1, 7));
    }

    @Test
    public void whenSearchingNonExistingVertexInACyclicGraphReturnFailure() {
        assertEquals(-1, getGraphSearch().findVertex(getAdjacencyArrayListForCyclicGraph(), 1, 7));
    }
}
