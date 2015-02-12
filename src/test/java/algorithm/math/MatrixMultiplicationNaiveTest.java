package algorithm.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixMultiplicationNaiveTest {

    int[][] firstSquareMatrix = {{1,2}, {3,4}};
    int[][] secondSquareMatrix = {{4,3}, {2,1}};
    int[][] expectedSquareMatrix = {{8,5}, {20,13}};

    int[][] threeXtwoMatrix = {{ 1, 2 }, { 3, 4 }, {5, 6}};
    int[][] twoXthreeMatrix = {{6, 5, 4}, {3, 2, 1 }};
    int[][] threeXthreeMatrix = {{12,9,6},{30,23,16},{48,37,26}};
    int[][] twoXtwoMatrix = {{41,56},{14,20}};

    @Test
    public void whenSquareMatricesAreMultipliedThenReturnCorrectSquareMatrix() {
        assertArrayEquals(expectedSquareMatrix,new MatrixMultiplicationNaive().multiply(firstSquareMatrix,secondSquareMatrix));
    }

    @Test
    public void whenThreeXTwoAndTwoXThreeMatricesAreMultipliedThenReturnCorrectThreeXThreeMatrix() {
        assertArrayEquals(threeXthreeMatrix,new MatrixMultiplicationNaive().multiply(threeXtwoMatrix,twoXthreeMatrix));
    }

    @Test
    public void whenTwoXThreeAndThreeXTwoMatricesAreMultipliedThenReturnCorrectTwoXTwoMatrix() {
        assertArrayEquals(twoXtwoMatrix,new MatrixMultiplicationNaive().multiply(twoXthreeMatrix,threeXtwoMatrix));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectMatricesAreMultipliedThrowException() {
        new MatrixMultiplicationNaive().multiply(twoXtwoMatrix,threeXtwoMatrix);
    }
}