package datastructure.unionfind;

/**
 * Created by Francisco Yllera.
 */
public class OptimizedUnionFind implements UnionFind {

    protected int[] elementsParent;
    protected int[] elementsRank;

    /**
     * Optimized Union-Find with:
     *  - Lazy union
     *  - Union by Rank
     *  - Path Compression
     */
    public OptimizedUnionFind(int size) {
        this.elementsParent = new int[size];
        this.elementsRank = new int[size];

        for (int i = 0; i < elementsParent.length; i++) {
            this.elementsParent[i] = i;
            this.elementsRank[i] = 0;
        }
    }

    /**
     * Find the parent root
     * Lazy union, O(n)
     * + Union by rank, O(log n)
     * + Path compression, O(α(n))
     * @param element
     * @return
     */
    public int find(int element) {
        int parentElement = this.elementsParent[element];
        int rootParentElement = findRoot(element);
        if (parentElement != rootParentElement) {
            this.elementsParent[element] = rootParentElement;
        }
        return rootParentElement;
    }

    protected int findRoot(int element) {
        int parentElement = this.elementsParent[element];
        return (parentElement == element) ? element : find(parentElement);
    }

    /**
     * Join two sets from elements given
     * @param element1
     * @param element2
     */
    public void union(int element1, int element2) {
        int parentRoot1 = find(element1);
        int parentRoot2 = find(element2);
        int rootRank1 = this.elementsRank[parentRoot1];
        int rootRank2 = this.elementsRank[parentRoot2];

        if (parentRoot1 == parentRoot2) {
            return;
        }

        if (rootRank1 > rootRank2) {
            this.elementsParent[parentRoot2] = parentRoot1;
        } else if (rootRank2 > rootRank1) {
            this.elementsParent[parentRoot1] = parentRoot2;
        } else {
            this.elementsParent[parentRoot2] = parentRoot1;
            this.elementsRank[parentRoot1]++;
        }
    }
}
