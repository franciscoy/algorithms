package algorithm.graph.representation;

import java.util.List;

/**
 * Created by Francisco Yllera.
 */
public interface AdjacencyList {

    public List<Integer> getNeighbors(int vertex);
    public void addNeighbor(int vertex, int vertex2);
}
