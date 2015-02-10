package algorithm.shuffle.Impl;

import algorithm.shuffle.ShuffleAlgorithm;

import java.util.Random;

/**
 * Created by Francisco Yllera.
 */
public class FisherYatesShuffle implements ShuffleAlgorithm{

    Random random;

    /**
     * Basic bug efficient shuffling algorithm.
     * @param randomInput
     */
    public FisherYatesShuffle(Random randomInput) {
        this.random = randomInput;
    }

    /**
     * Shuffles the array decreasingly.
     * @param inputArray
     * @return a shuffled array
     */
    @Override
    public int[] shuffle(int[] inputArray) {
        int randomIndex, temp;
        for (int i = inputArray.length - 1; i > 0; i--) {
            randomIndex = this.random.nextInt(i + 1);
            temp = inputArray[i];
            inputArray[i] = inputArray[randomIndex];
            inputArray[randomIndex] = temp;
        }

        return inputArray;
    }
}
