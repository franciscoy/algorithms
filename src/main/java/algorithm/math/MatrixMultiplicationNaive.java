package algorithm.math;

import algorithm.utils.ArrayUtils;

/**
 * Created by Francisco Yllera.
 */
public class MatrixMultiplicationNaive implements MatrixMultiplication {

    public int[][] multiply(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix[0].length) {
            throw new IllegalArgumentException();
        }
        int currentValue;
        int[][] matrixResult = new int[firstMatrix.length][secondMatrix[0].length];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix.length; j++) {
                currentValue = 0;
                for (int k = 0; k < firstMatrix.length; k++) {
                    currentValue += firstMatrix[j][k] *  secondMatrix[k][i];
                }
                matrixResult[j][i] = currentValue;
            }
        }
        
        return matrixResult;
    }

    public static void main(String[] args) {
        MatrixMultiplicationNaive matrixMultiplicationNaive = new MatrixMultiplicationNaive();

        int[][] matrix = { { 1, 2 }, { 3, 4 }, {5, 6}};
        int[][] matrix2 = { {6, 5, 4}, {3, 2, 1 } };

        matrixMultiplicationNaive.show(matrixMultiplicationNaive.multiply(matrix, matrix2));
    }

    public void show(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
