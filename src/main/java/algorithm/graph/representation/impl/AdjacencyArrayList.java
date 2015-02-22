package algorithm.graph.representation.impl;

import algorithm.graph.representation.AdjacencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Francisco Yllera.
 */
public class AdjacencyArrayList implements AdjacencyList{
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    @Override
    public Map<Integer, List<Integer>> getVertices() {
        return adjacencyList;
    }

    @Override
    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex);
    }

    @Override
    public void addVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<Integer>());
        }
    }

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

    /**
     * Replace neighbors list from vertex with new one.
     *
     * @param vertex
     * @param neighborsList
     */
    @Override
    public void addNeighborsList(int vertex, List<Integer> neighborsList) {
        if (!adjacencyList.containsKey(vertex)) {
            addVertex(vertex);
        }
        adjacencyList.put(vertex, neighborsList);
    }

    /**
     * Works but sucks, needs to be improved.
     * @return
     */
    @Override
    public synchronized AdjacencyList deepClone() {
        AdjacencyArrayList copiedAdjacencyArrayList = new AdjacencyArrayList();

        for(Map.Entry<Integer, List<Integer>> vertex : adjacencyList.entrySet()){
            int vertexValue = vertex.getKey().intValue();
            copiedAdjacencyArrayList.addVertex(vertexValue);
            copiedAdjacencyArrayList.addNeighborsList(vertexValue, new ArrayList<>(adjacencyList.get(vertexValue)));
        }
        return copiedAdjacencyArrayList;
    }

    @Override
    public void print() {
        for(Map.Entry<Integer, List<Integer>> vertex : adjacencyList.entrySet()){
            System.out.println(vertex);
        }
    }
}
