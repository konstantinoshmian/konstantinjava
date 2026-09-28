///7.
/// Дана целочисленная матрица размера A(n,m). Отсортировать
/// столбцы матрицы по количеству одинаковых элементов в столбце

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

        sortColumnsByDuplicates(matrix);

        System.out.println("\nsorted matrix:");
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
                mat[i][j] = rand.nextInt(5);
            }
        }
        return mat;
    }

    public static void sortColumnsByDuplicates(int[][] matrix) {
        int m = matrix[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - 1 - i; j++) {
                if (countDuplicatesInColumn(matrix, j) > countDuplicatesInColumn(matrix, j + 1)) {
                    SwapColumns(matrix, j, j + 1);
                }
            }
        }
    }

    public static int countDuplicatesInColumn(int[][] matrix, int col) {
        int duplicateCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int k = i + 1; k < matrix.length; k++) {
                if (matrix[i][col] == matrix[k][col]) {
                    duplicateCount++;
                    break;
                }
            }
        }
        return duplicateCount;
    }

    public static void SwapColumns(int[][] A, int col1, int col2){
        for (int i = 0; i < A.length; i++){
            int dop = A[i][col1];
            A[i][col1] = A[i][col2];
            A[i][col2] = dop;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
