package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;

import static algorithm.utils.ArrayPrintUtils.printArr;

/**
 * Created by Francisco Yllera.
 */
public class ShellSort implements SortingAlgorithm {
    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        int[] input = {2,1,5,4,3};

        printArr(ss.sort(input));
    }

    @Override
    public int[] sort(int[] inputArray) {
//        int gap = inputArray.length / 2;
//        {
//            for( int gap = inputArray.length / 2; gap > 0;
//                 gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
//                for( int i = gap; i < inputArray.length; i++ )
//                {
//                    int tmp = inputArray[ i ];
//                    int j = i;
//
//                    for( ; j >= gap && tmp == inputArray[ j - gap ] < 0; j -= gap )
//                    inputArray[ j ] = inputArray[ j - gap ];
//                    inputArray[ j ] = tmp;
//                }
//        }

        return inputArray;
    }
}
