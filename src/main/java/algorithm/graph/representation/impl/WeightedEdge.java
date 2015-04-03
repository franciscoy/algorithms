package algorithm.graph.representation.impl;

/**
 * Created by Francisco Yllera.
 */
public class WeightedEdge implements Comparable{
    private int headVertex;
    private int tailVertex;
    private int distance;

    public WeightedEdge(int headVertex, int tailVertex, int distance) {
        this.headVertex = headVertex;
        this.tailVertex = tailVertex;
        this.distance = distance;
    }

    public int getHeadVertex() {
        return headVertex;
    }

    public int getTailVertex() {
        return tailVertex;
    }

    public int getDistance() {
        return distance;
    }

    /**
     * The hashCode is the same for edges with the same points and distance
     * @return
     */
    @Override
    public int hashCode() {
        String headVertexStr = Integer.toString(headVertex);
        String tailVertexStr = Integer.toString(tailVertex);
        String distanceStr = Integer.toString(distance);

        if (headVertex >= tailVertex) {
            return Integer.valueOf(headVertexStr + tailVertexStr + distanceStr);
        } else {
            return Integer.valueOf(tailVertexStr + headVertexStr + distanceStr);
        }
    }

    @Override
    public boolean equals(Object obj) {
        WeightedEdge edgeToCompare = ((WeightedEdge) obj);
        return this.headVertex == edgeToCompare.getHeadVertex() &&
                this.tailVertex == edgeToCompare.getTailVertex() &&
                this.distance == edgeToCompare.getDistance();
    }

    @Override
    public int compareTo(Object o) {
        int edgeToCompareDistance = ((WeightedEdge) o).getDistance();
        if (this.distance == edgeToCompareDistance) {
            return 0;
        } else if (this.distance > edgeToCompareDistance) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        String headVertexStr = Integer.toString(headVertex);
        String tailVertexStr = Integer.toString(tailVertex);
        String distanceStr = Integer.toString(distance);

        return headVertexStr + "|" + tailVertexStr + "|" + distanceStr;
    }
}
