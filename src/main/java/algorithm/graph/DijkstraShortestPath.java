package algorithm.graph;

import algorithm.graph.representation.WeightedAdjacencyList;
import algorithm.graph.representation.impl.WeightedAdjacencyArrayList;
import algorithm.graph.representation.impl.WeightedEdge;

import java.util.*;

/**
 * Created by Francisco Yllera.
 */
public class DijkstraShortestPath {

    /**
     * Naively find Dijsktr's Shortest Path without a heap.
     *
     *
     * @param adjacencyList
     * @param rootVertex
     * @param vertexToFind
     * @return
     */
    public int findShortestPath(WeightedAdjacencyList adjacencyList, int rootVertex, int vertexToFind) {
        Set<Integer> conqueredVertices = new HashSet<>();
        Map<Integer, Integer> distanceToRoot = new HashMap<>();

        conqueredVertices.add(rootVertex);
        distanceToRoot.put(rootVertex, 0);
        int shortestPath = -1;

        while (conqueredVertices.size() <  adjacencyList.getVertices().size()) {
            Map<Integer, Integer> distanceToNeighbors = new HashMap<>();
            for (Integer vertex : conqueredVertices) {
                for (WeightedEdge neighbour : adjacencyList.getNeighbors(vertex)) {
                    if (conqueredVertices.contains(neighbour.getTailVertex())) {
                        continue;
                    }

                    int distance = distanceToRoot.get(vertex) + neighbour.getDistance();
                    distanceToNeighbors.put(distance, neighbour.getTailVertex());
                }
            }

            int distanceToAdd = Integer.MAX_VALUE;
            for (Integer distance : distanceToNeighbors.keySet()) {
                if (distance < distanceToAdd) {
                    distanceToAdd = distance;
                }
            }

            int vertexToAdd = distanceToNeighbors.get(distanceToAdd);
            conqueredVertices.add(vertexToAdd);
            distanceToRoot.put(vertexToAdd, distanceToAdd);

            if(vertexToAdd == vertexToFind) {
                shortestPath = distanceToAdd;
                break;
            }
        }

        return shortestPath;
    }

    public int findShortestPathHeap(WeightedAdjacencyList adjacencyList, int rootVertex, int vertexToFind) {
        Set<Integer> conqueredVertices = new HashSet<>();
        Map<Integer, Integer> distanceToRoot = new HashMap<>();
        Map<Integer, Integer> vertexToDistance = new HashMap<>();
        PriorityQueue<Integer> minDistanceQueue = new PriorityQueue<>();
        int shortestPath=0;


        for (int vertex : adjacencyList.getVertices().keySet()) {
            if (vertex == rootVertex) {
                distanceToRoot.put(0, vertex);
                vertexToDistance.put(vertex, 0);
                minDistanceQueue.add(0);
            } else {
                distanceToRoot.put(vertex, Integer.MAX_VALUE);
                vertexToDistance.put(vertex, Integer.MAX_VALUE);
                minDistanceQueue.add(Integer.MAX_VALUE);
            }
        }

        while (!minDistanceQueue.isEmpty()) {
            int minDistance =  minDistanceQueue.poll();
            int currentVertex = distanceToRoot.get(minDistance);
            if (currentVertex == vertexToFind) {
                return minDistance;
            }

            //If the current min distance is infinity, non connected component
            if (minDistance == Integer.MAX_VALUE) {
                return -1;
            }

            for (WeightedEdge weightedNeighbor : adjacencyList.getNeighbors(currentVertex)) {
                int currentDistanceToRoot = minDistance + weightedNeighbor.getDistance();
                if (currentDistanceToRoot < vertexToDistance.get(weightedNeighbor.getTailVertex())) {
                    minDistanceQueue.remove(vertexToDistance.get(weightedNeighbor.getTailVertex()));
                    distanceToRoot.put(currentDistanceToRoot, weightedNeighbor.getTailVertex());
                    vertexToDistance.put(weightedNeighbor.getTailVertex(), currentDistanceToRoot);
                    minDistanceQueue.add(currentDistanceToRoot);
                }
            }
        }

        return shortestPath;
    }

    public static void main(String[] args) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath();

        long start = System.currentTimeMillis();
        System.out.println(dijkstraShortestPath.findShortestPathHeap(getList(), 1, 10));

        System.out.println(System.currentTimeMillis() - start);

    }

    public static WeightedAdjacencyList getList() {
        WeightedAdjacencyList weightedAdjacencyList = new WeightedAdjacencyArrayList();

        weightedAdjacencyList.addVertex(1);
        weightedAdjacencyList.addVertex(2);
        weightedAdjacencyList.addVertex(3);
        weightedAdjacencyList.addVertex(4);
        weightedAdjacencyList.addVertex(5);
        weightedAdjacencyList.addVertex(6);
        weightedAdjacencyList.addVertex(7);
        weightedAdjacencyList.addVertex(8);
        weightedAdjacencyList.addVertex(9);

        weightedAdjacencyList.addNeighbor(1,2,2);
        weightedAdjacencyList.addNeighbor(1,3,1);

        weightedAdjacencyList.addNeighbor(2,5,3);
        weightedAdjacencyList.addNeighbor(2,4,1);

        weightedAdjacencyList.addNeighbor(3,4,4);
        weightedAdjacencyList.addNeighbor(3,8,20);

        weightedAdjacencyList.addNeighbor(4,7,2);

        weightedAdjacencyList.addNeighbor(5,6,3);

        weightedAdjacencyList.addNeighbor(6,7,1);
        weightedAdjacencyList.addNeighbor(6,9,5);

        weightedAdjacencyList.addNeighbor(7,8,7);

        weightedAdjacencyList.addNeighbor(8,1,1);

        weightedAdjacencyList.addNeighbor(9,8,6);

        return  weightedAdjacencyList;
    }
}
