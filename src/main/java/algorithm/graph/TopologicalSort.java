package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;
import algorithm.graph.representation.impl.AdjacencyArrayList;

import java.util.*;

/**
 * Created by Francisco Yllera.
 */
public class TopologicalSort {

    /**
     * Sorts Topologically the vertices of a directed graph.
     * Uses DFS to find the last element from each connected component.
     * Goes to the last element, adds it to the stack and bottoming up
     * while continuing doing the same.
     *
     * O(n + m)
     * @param adjacencyList
     * @return
     */
    public Deque<Integer> sortDirectedGraph(AdjacencyList adjacencyList) {
        Deque<Integer> sortedVertices = new ArrayDeque<>();
        Set<Integer> inspectedVertices = new HashSet<>();

        for (int currentVertex : adjacencyList.getVertices().keySet()) {
            if (inspectedVertices.contains(currentVertex)) {
                continue;
            }
            inspectedVertices.add(currentVertex);
            recursiveFindVertex(adjacencyList, inspectedVertices, sortedVertices, currentVertex);
            sortedVertices.addFirst(currentVertex);
        }

        return sortedVertices;
    }

    /**
     * DFS
     * @param adjacencyList
     * @param verticesInspected
     * @param sortedVertices
     * @param currentVertex
     */
    protected void recursiveFindVertex(AdjacencyList adjacencyList, Set<Integer> verticesInspected, Deque<Integer> sortedVertices, int currentVertex) {
        for (int neighbour : adjacencyList.getNeighbors(currentVertex)) {
            if (verticesInspected.contains(neighbour)){
                continue;
            }
            verticesInspected.add(neighbour);
            recursiveFindVertex(adjacencyList, verticesInspected, sortedVertices, neighbour);
            sortedVertices.addFirst(neighbour);
        }
    }
}
