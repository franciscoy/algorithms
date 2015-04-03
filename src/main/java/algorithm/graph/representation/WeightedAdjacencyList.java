package algorithm.graph.representation;

import algorithm.graph.representation.impl.WeightedEdge;

import java.util.List;
import java.util.Map;

/**
 * Created by Francisco Yllera.
 */
public interface WeightedAdjacencyList {
    public Map<Integer, List<WeightedEdge>> getVertices();
    public void removeVertex(int vertex);
    public void addVertex(int vertex);
    public List<WeightedEdge> getNeighbors(int vertex);
    public void addNeighbor(int vertex, int vertex2, int weight);
}
