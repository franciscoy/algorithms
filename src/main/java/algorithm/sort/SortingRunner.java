package algorithm.sort;

import algorithm.sort.impl.InsertionSort;

/**
 * Created by Francisco Yllera.
 */
public class SortingRunner {
    int[] sortingSmallDataset = {2,3,10,10,6,1,25,44,7};

    private InsertionSort iSort;

    public SortingRunner(){
        this.iSort = new InsertionSort();
    }

    public void runSortingAlgorithms() {
        this.iSort.sort(sortingSmallDataset);
    }

    public static void main(String[] args) {
        new SortingRunner().runSortingAlgorithms();
    }
}
