package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;
import algorithm.graph.representation.impl.AdjacencyArrayList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Francisco Yllera.
 */
public class CountConnectedComponentsBFS {

    /**
     * Find the number of connected components in a graph by BFS
     * For each non-inspected vertex do bfs inspecting all connected ones to him.
     *
     * O(n+m), linear
     * @param adjacencyList
     * @return number of connected components in the graph
     */
    public int countConnectedComponents(AdjacencyList adjacencyList) {
        HashSet<Integer> verticesInspected = new HashSet<>();
        int countConnectedComponents = 0;
        for (int currentVertex : adjacencyList.getVertices().keySet()) {
            if (verticesInspected.contains(currentVertex)) {
                continue;
            }

            Queue<Integer> verticesToInspect = new LinkedList<>();

            verticesToInspect.add(currentVertex);
            verticesInspected.add(currentVertex);
            while (!verticesToInspect.isEmpty()) {
                int vertex = verticesToInspect.poll();
                for (int neighbour : adjacencyList.getNeighbors(vertex)) {
                    if (verticesInspected.contains(neighbour)){
                        continue;
                    }
                    verticesToInspect.add(neighbour);
                    verticesInspected.add(neighbour);
                }
            }

            countConnectedComponents++;
        }
        return countConnectedComponents;
    }
}
