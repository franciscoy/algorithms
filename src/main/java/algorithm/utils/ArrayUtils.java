package algorithm.utils;

import java.util.Arrays;

/**
 * Created by Francisco Yllera.
 */
public class ArrayUtils {

    public static void printArr(int[] inputArray) {
        System.out.println(Arrays.toString(inputArray));
    }

    /**
     * Copies an array into a new one, not including the last index.
     *
     * @param  inputArray is the populated array
     * @param  firstArrayIndex the index from which the array will be started to been copied
     * @param  lastArrayIndex the final index to copy, not included in the copied array
     * @return  an int array copied between the bounds
     */
    public static int[] copyArray(int[] inputArray, int firstArrayIndex, int lastArrayIndex) {
        int[] copiedArray = new int[lastArrayIndex - firstArrayIndex];
        int j = 0;
        for (int i = firstArrayIndex; i < lastArrayIndex; i++) {
            copiedArray[j] = inputArray[i];
            j++;
        }

        return copiedArray;
    }
}
