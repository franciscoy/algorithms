package algorithm.graph;

public class DeepFirstSearchTest extends AbstractSearchTest{

    @Override
    public GraphSearch getGraphSearch() {
        return new DeepFirstSearch();
    }
}