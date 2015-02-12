package algorithm.math;

/**
 * Created by Francisco Yllera.
 */
public class MatrixMultiplicationNaive implements MatrixMultiplication {

    /**
     * Multiplies 2 matrices naively
     * N = rows
     * M = columns
     *
     * @param firstMatrix
     * @param secondMatrix
     * @return
     */
    public int[][] multiply(int[][] firstMatrix, int[][] secondMatrix) {
        //check first m equals second n
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalArgumentException();
        }

        int currentValue;
        //the resulting array will be n = first n, m = second m
        int[][] matrixResult = new int[firstMatrix.length][secondMatrix[0].length];
        for (int i = 0; i < matrixResult.length; i++) {
            for (int j = 0; j < matrixResult[0].length; j++) {
                currentValue = 0;
                for (int k = 0; k < firstMatrix[0].length; k++) {
                    currentValue += firstMatrix[i][k] * secondMatrix[k][j];
                }
                matrixResult[i][j] = currentValue;
            }
        }

        return matrixResult;
    }

    /**
     * Helper method to print matrices
     * @param matrix
     */
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
