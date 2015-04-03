package datastructure.unionfind;

/**
 * Created by Francisco Yllera.
 */
public interface UnionFind {

    public int find(int element);
    public void union(int element1, int element2);
}
