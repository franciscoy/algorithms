package datastructure.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Francisco Yllera.
 */
public abstract class AbstractUnionFindTest {

    abstract UnionFind getUnionFind(int size);

    @Test
    public void whenUnionTwoSingletonsThenTheSecondOneIsInTheFirstOne() {
        UnionFind unionFind = getUnionFind(2);
        unionFind.union(0,1);

        assertEquals(0, unionFind.find(0));
        assertEquals(0, unionFind.find(1));
    }

    @Test
    public void whenUnionTwoBigSetsThenTheSecondOneIsInTheFirstOne() {
        UnionFind unionFind = getUnionFind(10);
        //first set
        unionFind.union(3,1);
        unionFind.union(3,2);
        unionFind.union(3,6);
        unionFind.union(3,8);

        //second set
        unionFind.union(4,0);
        unionFind.union(4,5);
        unionFind.union(4,7);
        unionFind.union(4,9);

        unionFind.union(2,7);

        assertEquals(3, unionFind.find(9));
        assertEquals(3, unionFind.find(8));
    }

    @Test
    public void whenMultipleUnionElementsThenReturnParentCorrectly() {
        UnionFind unionFind = getUnionFind(10);

        unionFind.union(3,2);
        unionFind.union(3,1);
        unionFind.union(6,8);
        unionFind.union(4,5);
        unionFind.union(0,7);

        unionFind.union(1,8);
        unionFind.union(5,7);
        unionFind.union(0,9);

        unionFind.union(2,7);

        assertEquals(3, unionFind.find(9));
        assertEquals(3, unionFind.find(8));
    }
}
