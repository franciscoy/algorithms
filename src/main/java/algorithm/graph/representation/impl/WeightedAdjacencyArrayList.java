package algorithm.graph.representation.impl;

import algorithm.graph.representation.WeightedAdjacencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Francisco Yllera.
 */
public class WeightedAdjacencyArrayList implements WeightedAdjacencyList {
    private Map<Integer, List<WeightedEdge>> adjacencyList = new HashMap<>();

    @Override
    public Map<Integer, List<WeightedEdge>> getVertices() {
        return adjacencyList;
    }

    @Override
    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex);
    }

    @Override
    public void addVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<WeightedEdge>());
        }
    }

    @Override
    public List<WeightedEdge> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    @Override
    public void addNeighbor(int vertex, int vertex2, int weight) {
        if (!adjacencyList.containsKey(vertex)) {
            List<WeightedEdge> neighborList = new ArrayList<>();
            adjacencyList.put(vertex, neighborList);
        }

        adjacencyList.get(vertex).add(new WeightedEdge(vertex, vertex2, weight));
    }
}