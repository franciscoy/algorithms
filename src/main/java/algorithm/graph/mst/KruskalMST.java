package algorithm.graph.mst;

import algorithm.graph.representation.impl.WeightedEdge;
import datastructure.unionfind.OptimizedUnionFind;
import datastructure.unionfind.UnionFind;

import java.util.*;

/**
 * Created by Francisco Yllera.
 */
public class KruskalMST {

    /**
     * Find a MST from an undirected weighted edge set using Union-Find data structure.
     * Assuming the vertices are |V| = {0,1,..,N - 1}
     *
     * O(m log n)
     * @param edgeSet a set of the edges from the graph
     * @param verticesCount the vertices count from the graph
     * @return MST
     */
    public MinimumSpanningTree findMST(HashSet<WeightedEdge> edgeSet, int verticesCount){
        List<WeightedEdge> edgeList = new ArrayList<>(edgeSet);
        Collections.sort(edgeList);

        UnionFind unionFind = new OptimizedUnionFind(verticesCount);
        MinimumSpanningTree mst = generateMST(verticesCount);

        for (WeightedEdge weightedEdge : edgeList) {
            if (unionFind.find(weightedEdge.getHeadVertex()) != unionFind.find(weightedEdge.getTailVertex())) {
                populateMST(mst,weightedEdge);
                unionFind.union(weightedEdge.getHeadVertex(), weightedEdge.getTailVertex());
            }
        }
        return mst;
    }

    /**
     * Assuming the vertices are |V| = {0,1,..,N - 1}
     * @param size the size of the mst
     * @return MST
     */
    private MinimumSpanningTree generateMST(int size) {
        MinimumSpanningTree weightedAdjacencyList = new MinimumSpanningTree();

        for (int i = 0; i < size; i++) {
            weightedAdjacencyList.addVertex(i);
        }

        return weightedAdjacencyList;
    }

    private void populateMST(MinimumSpanningTree mst, WeightedEdge edge) {
        mst.addNeighbor(edge.getHeadVertex(), edge.getTailVertex(), edge.getDistance());
        mst.addNeighbor(edge.getTailVertex(), edge.getHeadVertex(), edge.getDistance());
        mst.addWeight(edge.getDistance());
    }
}
