package algorithm.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeepFirstSearchTest extends AbstractSearchTest{

    @Override
    public GraphSearch getGraphSearch() {
        return new DeepFirstSearch();
    }

    @Test
    public void whenRecursiveSearchingVertexInAnAcyclicGraphReturnCorrect() {
        assertEquals(4, new DeepFirstSearch().recursiveFindVertex(getAdjacencyArrayListForBasicGraph(), 1, 4));
    }

    @Test
    public void whenRecursiveSearchingVertexInACyclicGraphReturnCorrect() {
        assertEquals(5, new DeepFirstSearch().recursiveFindVertex(getAdjacencyArrayListForCyclicGraph(), 1, 5));
    }

    @Test
    public void whenRecursiveSearchingVertexInAnUnconnectedCyclicGraphReturnFailure() {
        assertEquals(-1, new DeepFirstSearch().recursiveFindVertex(getAdjacencyArrayListForUnconnectedCyclicGraph(), 1, 7));
    }

    @Test
    public void whenRecursiveSearchingNonExistingVertexInACyclicGraphReturnFailure() {
        assertEquals(-1, new DeepFirstSearch().recursiveFindVertex(getAdjacencyArrayListForCyclicGraph(), 1, 7));
    }
}