package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;
import algorithm.graph.representation.impl.AdjacencyArrayList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Francisco Yllera.
 */
public class BreadthFirstSearch {

    /**
     * Graph search by neighbor's layers.
     * Uses a FIFO list (Queue) to maintain an order of the next vertices to be inspected
     *      a Set to check if vertex has been inspected.
     *
     * Search by adjacency if any of the neighbors is the one to be found.
     *
     * O(n+m), linear complexity.
     * @param adjacencyList
     * @param rootVertex
     * @param vertexToFind
     * @return vertex if found, -1 if not.
     */
    public int findVertex(AdjacencyList adjacencyList, int rootVertex, int vertexToFind) {
        if (rootVertex == vertexToFind) {
            return vertexToFind;
        }
        HashSet<Integer> verticesInspected = new HashSet<>();
        Queue<Integer> verticesToInspect = new LinkedList<>();

        verticesToInspect.add(rootVertex);
        verticesInspected.add(rootVertex);
        while (!verticesToInspect.isEmpty()) {
            int vertex = verticesToInspect.poll();
            for (int neighbour : adjacencyList.getNeighbors(vertex)) {
                if (verticesInspected.contains(neighbour)){
                    continue;
                }
                if (neighbour == vertexToFind) {
                    return neighbour;
                }
                verticesToInspect.add(neighbour);
                verticesInspected.add(neighbour);
            }
        }

        return -1;
    }
}
