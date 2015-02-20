package algorithm.graph.representation.impl;

import algorithm.graph.representation.AdjacencyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Francisco Yllera.
 */
public class AdjacencyArrayList implements AdjacencyList{
    private Map<Integer, List<Integer>> adjacencyList;

    @Override
    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    @Override
    public void addNeighbor(int vertex, int vertex2) {
        if (!adjacencyList.containsKey(vertex)) {
            List<Integer> neighborList = new ArrayList<>();
            adjacencyList.put(vertex, neighborList);
        }

        adjacencyList.get(vertex).add(vertex2);
    }
}
