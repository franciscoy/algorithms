package datastructure.unionfind;

public class OptimizedUnionFindTest extends AbstractUnionFindTest{

    @Override
    UnionFind getUnionFind(int size) {
        return new OptimizedUnionFind(size);
    }
}