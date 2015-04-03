package datastructure.unionfind;

/**
 * Created by Francisco Yllera.
 */
public class NaiveUnionFind implements UnionFind{

    protected int[] elementsParent;

    /**
     * Create the array of parents and assign each element as his own parent.
     * @param size
     */
    public NaiveUnionFind(int size) {
        this.elementsParent = new int[size];

        for (int i = 0; i < elementsParent.length; i++) {
            this.elementsParent[i] = i;
        }
    }

    /**
     * Returns the root parent of the element
     * O(1)
     * @param element
     * @return
     */
    @Override
    public int find(int element) {
        if (element > elementsParent.length + 1) {
            throw new IllegalArgumentException("The element is not in the union find set");
        }

        return this.elementsParent[element];
    }

    /**
     * Union two sets of elements
     * O(n)
     * @param element1
     * @param element2
     */
    @Override
    public void union(int element1, int element2) {
        int parent1 = find(element1);
        int parent2 = find(element2);
        
        if (parent1 != parent2) {
            for (int i = 0; i < elementsParent.length; i++) {
                if (find(i) == parent2) {
                    elementsParent[i] = parent1;
                }
            }
        }
    }
}
