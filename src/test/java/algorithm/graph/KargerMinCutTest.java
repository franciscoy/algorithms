package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;
import algorithm.graph.representation.impl.AdjacencyArrayList;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class KargerMinCutTest extends GraphTest{

    KargerMinCut kargerMinCut = new KargerMinCut();

    @Test
    public void whenFindingTheMinCutFromBasicGraphReturnsCorrect() {
        AdjacencyList adjacencyArrayListForTest = getAdjacencyArrayListForBasicGraph();
        int minCut = kargerMinCut.minCut(adjacencyArrayListForTest);

        assertEquals(1, minCut);
    }

    @Test
    public void whenFindingTheMinCutFromMultiGraphReturnsCorrect() {
        AdjacencyList adjacencyArrayListForTest = getAdjacencyArrayListForMultiGraph();
        int minCut = kargerMinCut.minCut(adjacencyArrayListForTest);

        assertEquals(1, minCut);
    }

    /**
     * Non-deterministic due to randomized behaviour, need to mock Random Obj.
     */
    @Test
    public void whenFindingTheMinCutFromCyclicMultiGraphReturnsCorrect() {
        AdjacencyList adjacencyArrayListForTest = getAdjacencyArrayListForCyclicMultiGraph();
        int minCut = kargerMinCut.minCut(adjacencyArrayListForTest);

        assertEquals(2, minCut);
    }

    @Test
    public void whenContractingEdgeOnBasicGraphWorksOk() {
        AdjacencyList adjacencyArrayListForTest = getAdjacencyArrayListForBasicGraph();

        kargerMinCut.contractEdge(adjacencyArrayListForTest, 1, 2);

        ArrayList<Integer> expectedVertex1Neighbors = new ArrayList<>();
        expectedVertex1Neighbors.add(3);

        ArrayList<Integer> expectedVertex3Neighbors = new ArrayList<>();
        expectedVertex3Neighbors.add(4);
        expectedVertex3Neighbors.add(1);

        ArrayList<Integer> expectedVertex4Neighbors = new ArrayList<>();
        expectedVertex4Neighbors.add(3);

        assertEquals(expectedVertex1Neighbors, adjacencyArrayListForTest.getNeighbors(1));
        assertEquals(expectedVertex3Neighbors, adjacencyArrayListForTest.getNeighbors(3));
        assertEquals(expectedVertex4Neighbors, adjacencyArrayListForTest.getNeighbors(4));
        assertEquals(null, adjacencyArrayListForTest.getNeighbors(2));
    }

    @Test
    public void whenContractingEdgeOnMultiGraphWorksOk() {
        AdjacencyList adjacencyArrayListForTest = getAdjacencyArrayListForMultiGraph();

        kargerMinCut.contractEdge(adjacencyArrayListForTest, 1, 2);

        ArrayList<Integer> expectedVertex1Neighbors = new ArrayList<>();
        expectedVertex1Neighbors.add(3);
        expectedVertex1Neighbors.add(3);

        ArrayList<Integer> expectedVertex3Neighbors = new ArrayList<>();
        expectedVertex3Neighbors.add(4);
        expectedVertex3Neighbors.add(1);
        expectedVertex3Neighbors.add(1);

        ArrayList<Integer> expectedVertex4Neighbors = new ArrayList<>();
        expectedVertex4Neighbors.add(3);

        assertEquals(expectedVertex1Neighbors, adjacencyArrayListForTest.getNeighbors(1));
        assertEquals(expectedVertex3Neighbors, adjacencyArrayListForTest.getNeighbors(3));
        assertEquals(expectedVertex4Neighbors, adjacencyArrayListForTest.getNeighbors(4));
        assertEquals(null, adjacencyArrayListForTest.getNeighbors(2));
    }
}