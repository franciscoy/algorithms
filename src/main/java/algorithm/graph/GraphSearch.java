package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;

/**
 * Created by Francisco Yllera.
 */
public interface GraphSearch {
    public int findVertex(AdjacencyList adjacencyList, int rootVertex, int vertexToFind);
}
