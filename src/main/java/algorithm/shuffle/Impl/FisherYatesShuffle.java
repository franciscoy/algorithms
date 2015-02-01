package algorithm.shuffle.Impl;

import algorithm.shuffle.ShuffleAlgorithm;

import java.util.Random;

import static algorithm.utils.ArrayPrintUtils.printArr;

/**
 * Created by Francisco Yllera.
 */
public class FisherYatesShuffle implements ShuffleAlgorithm{

    Random random;

    public FisherYatesShuffle(Random randomGenerator) {
        this.random = randomGenerator;
    }

    @Override
    public int[] shuffle(int[] inputArray) {
        int randomIndex = 0, temp;
        for (int i = inputArray.length - 1; i > 0; i--) {
            randomIndex = this.random.nextInt(i + 1);
            temp = inputArray[i];
            inputArray[i] = inputArray[randomIndex];
            inputArray[randomIndex] = temp;
        }

        return inputArray;
    }

    public static void main(String[] args) {
        FisherYatesShuffle fisherYatesShuffle = new FisherYatesShuffle(new Random());
        int[] input = {1,2,3,4};


        printArr(fisherYatesShuffle.shuffle(input));
    }
}
