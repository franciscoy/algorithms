package algorithm.count;

/**
 * Created by Francisco Yllera.
 */
public class CountInversionNaive implements CountInversion{

    /**
     * Counts split inversions from an array naively.
     * @param inputArray
     * @return split inversions count
     */
    @Override
    public int count(int[] inputArray) {
        int count= 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = i + 1; j < inputArray.length ; j++) {
                if(inputArray[i] > inputArray[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
