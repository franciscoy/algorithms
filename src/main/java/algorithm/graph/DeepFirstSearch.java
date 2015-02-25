package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * Created by Francisco Yllera.
 */
public class DeepFirstSearch implements GraphSearch{

    /**
     * Graph search by deep neighbour inspections.
     * Goes to the bottom until there's no neighbors left and then start to backtrack.
     * Same impl than BFS but with a Stack instead of Queue.
     *
     * Uses a LIFO list (Stack) to deep inspect the last neighbour added
     *      a Set to check if vertex has been inspected.
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
        Deque<Integer> verticesToInspect = new ArrayDeque<Integer>();

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
                verticesToInspect.addFirst(neighbour);
                verticesInspected.add(neighbour);
            }
        }

        return -1;
    }

    /**
     * Using the method call stack as the algorithm stack.
     * Same logic as the iterative algorithm.
     *
     * @param adjacencyList
     * @param rootVertex
     * @param vertexToFind
     * @return
     */
    public int recursiveFindVertex(AdjacencyList adjacencyList, int rootVertex, int vertexToFind) {
        if (rootVertex == vertexToFind) {
            return vertexToFind;
        }
        HashSet<Integer> verticesInspected = new HashSet<>();
        verticesInspected.add(rootVertex);
        return recursiveFindVertex(adjacencyList, verticesInspected, rootVertex, vertexToFind);
    }

    protected int recursiveFindVertex(AdjacencyList adjacencyList, HashSet<Integer> verticesInspected, int currentVertex, int vertexToFind) {
        for (int neighbour : adjacencyList.getNeighbors(currentVertex)) {
            if (verticesInspected.contains(neighbour)){
                continue;
            }
            if (neighbour == vertexToFind) {
                return neighbour;
            }
            verticesInspected.add(neighbour);
            return recursiveFindVertex(adjacencyList, verticesInspected, neighbour, vertexToFind);
        }
        return -1;
    }
}
