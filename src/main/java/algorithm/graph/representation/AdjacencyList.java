package algorithm.graph.representation;

import java.util.List;
import java.util.Map;

/**
 * Created by Francisco Yllera.
 */
public interface AdjacencyList {

    public Map<Integer, List<Integer>> getVertices();
    public void removeVertex(int vertex);
    public void addVertex(int vertex);

    public List<Integer> getNeighbors(int vertex);
    public void addNeighbor(int vertex, int vertex2);
    public void addNeighborsList(int vertex, List<Integer> neighborsList);

    public AdjacencyList deepClone();
}
