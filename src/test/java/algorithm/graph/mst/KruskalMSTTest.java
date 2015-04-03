package algorithm.graph.mst;

import algorithm.graph.representation.impl.WeightedEdge;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class KruskalMSTTest {

    @Test
    public void whenFindingMSTFromASetOfDistinctWeightedEdgesThenReturnCorrect() {
        HashSet<WeightedEdge> edges = new HashSet<>();

        edges.add(new WeightedEdge(0,1,1));
        edges.add(new WeightedEdge(0,2,7));
        edges.add(new WeightedEdge(1,3,4));
        edges.add(new WeightedEdge(1,2,5));
        edges.add(new WeightedEdge(1,4,3));
        edges.add(new WeightedEdge(2,4,6));
        edges.add(new WeightedEdge(3,4,2));

        KruskalMST kruskalMST = new KruskalMST();

        MinimumSpanningTree mst = kruskalMST.findMST(edges, 4 + 1);

        assertEquals(11, mst.getWeight());
        assertEquals(1, mst.getNeighbors(0).size());
        assertEquals(3, mst.getNeighbors(1).size());
        assertEquals(1, mst.getNeighbors(2).size());
        assertEquals(1, mst.getNeighbors(3).size());
        assertEquals(2, mst.getNeighbors(4).size());
    }

    @Test
    public void whenFindingMSTFromASetOfNonDistinctWeightedEdgesThenReturnCorrect() {
        HashSet<WeightedEdge> edges = new HashSet<>();

        edges.add(new WeightedEdge(0,2,1));
        edges.add(new WeightedEdge(0,1,2));
        edges.add(new WeightedEdge(2,1,2));
        edges.add(new WeightedEdge(2,3,3));
        edges.add(new WeightedEdge(2,4,7));
        edges.add(new WeightedEdge(1,4,2));
        edges.add(new WeightedEdge(1,3,4));
        edges.add(new WeightedEdge(3,4,6));

        KruskalMST kruskalMST = new KruskalMST();

        MinimumSpanningTree mst = kruskalMST.findMST(edges, 4 + 1);

        assertEquals(8, mst.getWeight());
        assertEquals(1, mst.getNeighbors(0).size());
        assertEquals(2, mst.getNeighbors(1).size());
        assertEquals(3, mst.getNeighbors(2).size());
        assertEquals(1, mst.getNeighbors(3).size());
        assertEquals(1, mst.getNeighbors(4).size());
    }
}