package datastructure.unionfind;

import org.junit.Test;

import static org.junit.Assert.*;

public class NaiveUnionFindTest extends AbstractUnionFindTest{

    public UnionFind getUnionFind(int size) {
        return new NaiveUnionFind(size);
    }
}