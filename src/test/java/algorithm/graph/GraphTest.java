package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;
import algorithm.graph.representation.impl.AdjacencyArrayList;

/**
 * Created by Francisco Yllera.
 */
public abstract class GraphTest {

    /**
     * Acyclic Graph:
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
     * Acyclic Multi Graph:
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

    /**
     * Cyclic Multi Graph:
     *  V(1) = V(2) = V(3) - V(4)
     *   ^--------------------^
     */
    public AdjacencyList getAdjacencyArrayListForCyclicMultiGraph() {
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

        adjacencyArrayList.addNeighbor(1, 4);

        adjacencyArrayList.addNeighbor(4, 1);

        return adjacencyArrayList;
    }

    public AdjacencyList getAdjacencyArrayListForCyclicGraph() {
        AdjacencyArrayList adjacencyArrayList = new AdjacencyArrayList();

        adjacencyArrayList.addVertex(1);
        adjacencyArrayList.addVertex(2);
        adjacencyArrayList.addVertex(3);
        adjacencyArrayList.addVertex(4);
        adjacencyArrayList.addVertex(5);

        adjacencyArrayList.addNeighbor(1, 2);
        adjacencyArrayList.addNeighbor(2, 1);

        adjacencyArrayList.addNeighbor(1, 3);
        adjacencyArrayList.addNeighbor(3, 1);

        adjacencyArrayList.addNeighbor(4, 2);
        adjacencyArrayList.addNeighbor(2, 4);

        adjacencyArrayList.addNeighbor(4, 3);
        adjacencyArrayList.addNeighbor(3, 4);

        adjacencyArrayList.addNeighbor(3, 5);
        adjacencyArrayList.addNeighbor(5, 3);

        return adjacencyArrayList;
    }

    public AdjacencyList getAdjacencyArrayListForUnconnectedCyclicGraph() {
        AdjacencyArrayList adjacencyArrayList = new AdjacencyArrayList();

        adjacencyArrayList.addVertex(1);
        adjacencyArrayList.addVertex(2);
        adjacencyArrayList.addVertex(3);
        adjacencyArrayList.addVertex(4);
        adjacencyArrayList.addVertex(5);

        adjacencyArrayList.addVertex(6);
        adjacencyArrayList.addVertex(7);

        adjacencyArrayList.addNeighbor(1, 2);
        adjacencyArrayList.addNeighbor(2, 1);

        adjacencyArrayList.addNeighbor(1, 3);
        adjacencyArrayList.addNeighbor(3, 1);

        adjacencyArrayList.addNeighbor(4, 2);
        adjacencyArrayList.addNeighbor(2, 4);

        adjacencyArrayList.addNeighbor(4, 3);
        adjacencyArrayList.addNeighbor(3, 4);

        adjacencyArrayList.addNeighbor(3, 5);
        adjacencyArrayList.addNeighbor(5, 3);

        adjacencyArrayList.addNeighbor(6, 7);
        adjacencyArrayList.addNeighbor(7, 6);

        return adjacencyArrayList;
    }

    public AdjacencyList getAdjacencyArrayListForTotallyUnconnectedGraph() {
        AdjacencyArrayList adjacencyArrayList = new AdjacencyArrayList();

        adjacencyArrayList.addVertex(1);
        adjacencyArrayList.addVertex(2);
        adjacencyArrayList.addVertex(3);
        adjacencyArrayList.addVertex(4);
        adjacencyArrayList.addVertex(5);

        return adjacencyArrayList;
    }

    public static AdjacencyList getAdjacencyArrayListForDirectedAcyclicGraph() {
        AdjacencyArrayList adjacencyArrayList = new AdjacencyArrayList();

        adjacencyArrayList.addVertex(4);
        adjacencyArrayList.addVertex(1);
        adjacencyArrayList.addVertex(3);
        adjacencyArrayList.addVertex(5);
        adjacencyArrayList.addVertex(2);

        adjacencyArrayList.addNeighbor(1, 2);
        adjacencyArrayList.addNeighbor(5, 3);
        adjacencyArrayList.addNeighbor(5, 1);
        adjacencyArrayList.addNeighbor(3, 4);

        return adjacencyArrayList;
    }
}
