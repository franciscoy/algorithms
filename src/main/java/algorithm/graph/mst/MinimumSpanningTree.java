package algorithm.graph.mst;

import algorithm.graph.representation.impl.WeightedAdjacencyArrayList;

/**
 * Created by Francisco Yllera.
 */
public class MinimumSpanningTree extends WeightedAdjacencyArrayList {

    protected int weight = 0;

    public int getWeight() {
        return weight;
    }

    public void addWeight(int addedWeight) {
        this.weight += addedWeight;
    }
}
