package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;
import algorithm.graph.representation.impl.AdjacencyArrayList;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class KargerMinCutTest {


    @Test
    public void whenContractingEdgeOnBasicGraphWorksOk() {
        AdjacencyList adjacencyArrayListForTest = getAdjacencyArrayListForBasicGraph();
        KargerMinCut kargerMinCut = new KargerMinCut();

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
        KargerMinCut kargerMinCut = new KargerMinCut();

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

    /**
     * Graph:
     *  V(1) - V(2) - V(3) - V(4)
     */
    public AdjacencyList getAdjacencyArrayListForBasicGraph() {
        AdjacencyArrayList adjacencyArrayList = new AdjacencyArrayList();

        adjacencyArrayList.addVertex(1);
        adjacencyArrayList.addVertex(2);
        adjacencyArrayList.addVertex(3);
        adjacencyArrayList.addVertex(4);

        adjacencyArrayList.addNeighbor(1, 2);
        adjacencyArrayList.addNeighbor(2, 1);
        adjacencyArrayList.addNeighbor(2, 3);
        adjacencyArrayList.addNeighbor(3, 2);
        adjacencyArrayList.addNeighbor(3, 4);
        adjacencyArrayList.addNeighbor(4, 3);

        return adjacencyArrayList;
    }

    /**
     * Multi Graph:
     *  V(1) = V(2) = V(3) - V(4)
     */
    public AdjacencyList getAdjacencyArrayListForMultiGraph() {
        AdjacencyArrayList adjacencyArrayList = new AdjacencyArrayList();

        adjacencyArrayList.addVertex(1);
        adjacencyArrayList.addVertex(2);
        adjacencyArrayList.addVertex(3);
        adjacencyArrayList.addVertex(4);

        adjacencyArrayList.addNeighbor(1, 2);
        adjacencyArrayList.addNeighbor(1, 2);

        adjacencyArrayList.addNeighbor(2, 1);
        adjacencyArrayList.addNeighbor(2, 1);

        adjacencyArrayList.addNeighbor(2, 3);
        adjacencyArrayList.addNeighbor(2, 3);

        adjacencyArrayList.addNeighbor(3, 2);
        adjacencyArrayList.addNeighbor(3, 2);

        adjacencyArrayList.addNeighbor(3, 4);

        adjacencyArrayList.addNeighbor(4, 3);

        return adjacencyArrayList;
    }
}