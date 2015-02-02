package algorithm.sort.impl;

import algorithm.sort.SortingAlgorithm;

import static algorithm.utils.ArrayPrintUtils.printArr;

/**
 * Created by Francisco Yllera.
 */
public class ShellSort extends AbstractSortingAlgorithm implements SortingAlgorithm {
    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        int[] input = {2,1,5,4,3,7,6,9,8};

        printArr(ss.sort(input));
    }

    @Override
    public int[] sort(int[] inputArray) {
        int gap = inputArray.length / 2;
        while (gap > 0) {
            for (int i = inputArray.length - 1 ; i >= inputArray.length - gap ; i--) {

                for (int j = i; j - gap >= 0; j = j - gap) {
                    if (inputArray[j] < inputArray[j - gap]) {
                        swapElements(inputArray, j, j- gap);
                    }
                }

            }
            gap /= 2;
        }
        return inputArray;
    }

    
}
