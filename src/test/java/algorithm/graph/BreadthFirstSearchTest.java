package algorithm.graph;

public class BreadthFirstSearchTest extends AbstractSearchTest{

    @Override
    public GraphSearch getGraphSearch() {
        return new BreadthFirstSearch();
    }
}