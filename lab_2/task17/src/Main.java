///Преобразовать строки матрицы таким образом, чтобы элементы,
/// равные нулю,располагались после всех остальных.Удалить нулевые столбцы
///

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] size = readSize(scanner);
        int n = size[0], m = size[1];

        int[][] matrix = createMatrix(n, m, random);

        System.out.println("initial matrix:");
        printMatrix(matrix);

        shiftZerosToEndInRows(matrix);
        System.out.println("\nmatrix after shifting zeros:");
        printMatrix(matrix);

        matrix = removeZeroColumns(matrix);
        System.out.println("\nmatrix after removing zero columns:");
        printMatrix(matrix);
    }

    public static int[] readSize(Scanner sc) {
        System.out.print("input n and m: ");
        return new int[]{sc.nextInt(), sc.nextInt()};
    }

    public static int[][] createMatrix(int n, int m, Random rand) {
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = rand.nextInt(3);
            }
        }
        return mat;
    }

    public static void shiftZerosToEndInRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] newRow = new int[matrix[i].length];
            int index = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    newRow[index] = matrix[i][j];
                    index++;
                }
            }
            matrix[i] = newRow;
        }
    }

    public static int[][] removeZeroColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] isZeroCol = new boolean[cols];
        int zeroColsCount = 0;

        for (int j = 0; j < cols; j++) {
            boolean allZeros = true;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] != 0) {
                    allZeros = false;
                    break;
                }
            }
            if (allZeros) {
                isZeroCol[j] = true;
                zeroColsCount++;
            }
        }

        if (zeroColsCount == 0) {
            return matrix;
        }

        int[][] newMatrix = new int[rows][cols - zeroColsCount];

        for (int i = 0; i < rows; i++) {
            int newColIndex = 0;
            for (int j = 0; j < cols; j++) {
                if (!isZeroCol[j]) {
                    newMatrix[i][newColIndex] = matrix[i][j];
                    newColIndex++;
                }
            }
        }

        return newMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("(matrix is empty)");
            return;
        }
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
