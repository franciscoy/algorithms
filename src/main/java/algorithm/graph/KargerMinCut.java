package algorithm.graph;

import algorithm.graph.representation.AdjacencyList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Francisco Yllera.
 */
public class KargerMinCut {

    Random random = new Random();

    /**
     * Contracts random edges merging their two vertices
     * until there are only two vertices left in the graph.
     * The count of parallel edges represent the minimum cut of G.
     *
     * It may fail therefore it is iterated a number of times to maximize the chance of finding
     * the minimum cut.
     *
     * @param list
     * @return minimum cut
     */
    public int minCut(AdjacencyList list) {
        int minCut = Integer.MAX_VALUE;
        for (int i = 0; i < getIterationsByVerticlesSize(list); i++) {
            AdjacencyList clonedList = list.deepClone();
            while(clonedList.getVertices().size() > 2) {
                int randomVertex = pickRandomVertex(clonedList);
                contractEdge(clonedList, randomVertex, pickRandomNeighbor(clonedList, randomVertex));
            }

            int firstVertex = clonedList.getVertices().keySet().iterator().next();
            if (clonedList.getNeighbors(firstVertex).size() < minCut) {
                minCut = clonedList.getNeighbors(firstVertex).size();
            }
        }

        return minCut;
    }

    /**
     * Function to calculate the times the algorithm need to run to have
     * high chance of finding the minimum cut.
     */
    public int getIterationsByVerticlesSize(AdjacencyList list) {
        int n = list.getVertices().size();
        return (int)Math.round(n * (n - 1) / 2 * Math.log(n));
    }

    /**
     * Pick a neighbor from given vertex randomly
     * @param list
     * @param vertex
     * @return
     */
    protected int pickRandomNeighbor(AdjacencyList list, int vertex) {
        List<Integer> neighbors = list.getNeighbors(vertex);
        return neighbors.get(random.nextInt(neighbors.size()));

    }

    /**
     * Pick a vertex randomly
     * @param list
     * @return
     */
    protected int pickRandomVertex(AdjacencyList list) {
        ArrayList<Integer> verticesList = new ArrayList<>(list.getVertices().keySet());
        return verticesList.get(random.nextInt(verticesList.size()));
    }

    /**
     * Contract Edge Subroutine.
     * Given tow vertices (v1 and v2), contracts every edge from both, into one vertex.
     *
     * First, remove v2 from v1's edges, since they will merge
     * Second, add v2's neighbors to v1 and update those to point to v1 now
     * Third, remove v2 from the graph.
     *
     * @param list
     * @param vertex1
     * @param vertex2
     */
    protected void contractEdge(AdjacencyList list, int vertex1, int vertex2) {
        List<Integer> listNeighborsFromV1 = list.getNeighbors(vertex1);
        for (int i = 0; i < listNeighborsFromV1.size(); i++) {
            if (listNeighborsFromV1.get(i).intValue() == vertex2) {
                listNeighborsFromV1.remove(i);
                i --;
            }
        }

        List<Integer> listNeighborsFromV2 = list.getNeighbors(vertex2);
        for (int i = 0; i < listNeighborsFromV2.size(); i++) {
            int neighbor = listNeighborsFromV2.get(i).intValue();
            if (neighbor != vertex1) {
                listNeighborsFromV1.add(neighbor);

                List<Integer> adjFromNeighbor = list.getNeighbors(neighbor);
                for (int j = 0; j < adjFromNeighbor.size(); j++) {
                    if (adjFromNeighbor.get(j).intValue() == vertex2) {
                        adjFromNeighbor.remove(j);
                        adjFromNeighbor.add(vertex1);
                    }
                }
            }
        }

        list.removeVertex(vertex2);
    }
}
