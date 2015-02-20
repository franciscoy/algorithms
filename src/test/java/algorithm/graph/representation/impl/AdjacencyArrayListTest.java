package algorithm.graph.representation.impl;

import algorithm.graph.representation.AdjacencyList;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdjacencyArrayListTest {

    @Test
    public void whenInsertingNeighborsIndividuallyThenReturnThem() {
        AdjacencyList adjacencyList = new AdjacencyArrayList();
        adjacencyList.addNeighbor(3,4);
        adjacencyList.addNeighbor(1,2);
        adjacencyList.addNeighbor(1,3);
        adjacencyList.addNeighbor(1,4);
        adjacencyList.addNeighbor(2,3);

        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(4);

        assertEquals(expectedList, adjacencyList.getNeighbors(1));
    }
}