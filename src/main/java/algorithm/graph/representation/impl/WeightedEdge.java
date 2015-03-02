package algorithm.graph.representation.impl;

/**
 * Created by Francisco Yllera.
 */
public class WeightedEdge {

    private int tailVertex;
    private int distance;

    public WeightedEdge(int tailVertex, int distance) {
        this.tailVertex = tailVertex;
        this.distance = distance;
    }

    public int getTailVertex() {
        return tailVertex;
    }

    public int getDistance() {
        return distance;
    }
}
