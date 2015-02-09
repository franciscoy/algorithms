package algorithm.count;

import java.util.Arrays;

/**
 * Created by Francisco Yllera.
 */
public class CountInversion {

    public int count(int[] inputArray) {
        if (inputArray.length <= 1) {
            return 0;
        }

        int firstArrayIndex = (inputArray.length / 2);
        int[] firstArray = copyArray(inputArray, 0, firstArrayIndex);
        int[] secondArray = copyArray(inputArray, firstArrayIndex, inputArray.length);

        int firstHalfInversionsCount = count(firstArray);
        int secondHalfInversionsCount = count(secondArray);
        int mergeHalvesInversionsCount = mergeAndCountInversions(firstArray, secondArray, inputArray);

        return firstHalfInversionsCount + secondHalfInversionsCount + mergeHalvesInversionsCount;
    }

    protected int[] copyArray(int[] inputArray, int firstArrayIndex, int lastArrayIndex) {
        int[] copiedArray = new int[lastArrayIndex - firstArrayIndex];
        int j = 0;
        for (int i = firstArrayIndex; i < lastArrayIndex; i++) {
            copiedArray[j] = inputArray[i];
            j++;
        }

        return copiedArray;
    }

    public int mergeAndCountInversions(int[] firstArr, int[] secondArr, int[] mergedArray) {
        int[] merged = new int[firstArr.length + secondArr.length];
        int firstIndex = 0, secondIndex = 0, count = 0;

        for (int i = 0; i < merged.length; i++) {
            if (secondIndex >= secondArr.length || (firstIndex < firstArr.length && secondArr[secondIndex] > firstArr[firstIndex])) {
                merged[i] = firstArr[firstIndex];
                firstIndex++;
            } else {
                merged[i] = secondArr[secondIndex];
                secondIndex++;
                if (firstArr.length > firstIndex) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountInversion ci = new CountInversion();
        int[] array = {1,3,0,5,2,4,6,2};

        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};

        System.out.println(ci.count(array));
        System.out.println(Arrays.toString(array));
    }
}
