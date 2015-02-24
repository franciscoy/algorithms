package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;
import algorithm.graph.representation.impl.AdjacencyArrayList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Francisco Yllera.
 */
public class ShortestPathBasic {

    /**
     * DTO for vertex and its distance from root relation.
     */
    private class VertexDistancePair {
        private int vertex;
        private int distanceFromRoot;

        public VertexDistancePair(int vertex, int distanceFromRoot) {
            this.vertex = vertex;
            this.distanceFromRoot = distanceFromRoot;
        }

        public int getVertex() {
            return vertex;
        }
        public int getDistanceFromRoot() {
            return distanceFromRoot;
        }

    }

    /**
     * Calculate the shortest path in a graph from two vertices
     * Based in BFS.
     *
     * Neighbors have current vertex distance from root + 1, and so on.
     * @param adjacencyList
     * @param rootVertex
     * @param vertexToFind
     * @return the shortest path
     */
    public int findShortestPath(AdjacencyList adjacencyList, int rootVertex, int vertexToFind) {
        if (rootVertex == vertexToFind) {
            return 0;
        }
        HashSet<Integer> verticesInspected = new HashSet<>();
        Queue<VertexDistancePair> verticesToInspect = new LinkedList<>();

        verticesToInspect.add(new VertexDistancePair(rootVertex, 0));
        verticesInspected.add(rootVertex);
        while (!verticesToInspect.isEmpty()) {
            VertexDistancePair pair = verticesToInspect.poll();
            for (int neighbour : adjacencyList.getNeighbors(pair.getVertex())) {
                if (verticesInspected.contains(neighbour)){
                    continue;
                }
                if (neighbour == vertexToFind) {
                    return pair.getDistanceFromRoot() + 1;
                }
                verticesToInspect.add(new VertexDistancePair(neighbour, pair.getDistanceFromRoot() + 1));
                verticesInspected.add(neighbour);
            }
        }

        return -1;
    }
}
