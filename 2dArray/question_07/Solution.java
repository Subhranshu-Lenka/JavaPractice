import java.util.*;

public class Solution {

    public static void MatrixMultiplication(int[][] m1, int[][] m2, int[][] res) {
        int r1 = m1.length;
        int c1 = m1[0].length;
        int r2 = m2.length;
        int c2 = m2[0].length;

        if (c1 != r2) {
            System.out.println("Invalid Input");
            System.exit(1);
        }

        // Perform matrix multiplication
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                res[i][j] = 0; // Initialize result cell
                for (int k = 0; k < c1; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows of matrix_1:");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns of matrix_1:");
        int cols = sc.nextInt();
        sc.nextLine(); // newline

        int[][] matrix1 = new int[rows][cols];
        System.out.println("Enter the matrix_1 row by row (comma-separated values):");

        for (int i = 0; i < rows; i++) {
            String line = sc.nextLine().trim();
            if (!line.matches("^[0-9,\\s-]+$")) {
                System.out.println("Invalid input format. Only numbers and commas are allowed.");
                return;
            }

            String[] values = line.split(",");
            if (values.length != cols) {
                System.out.println("Invalid number of columns in row " + (i + 1));
                return;
            }

            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = Integer.parseInt(values[j].trim());
            }
        }

        System.out.println("Enter number of rows of matrix_2:");
        int rows2 = sc.nextInt();
        System.out.println("Enter number of columns of matrix_2:");
        int cols2 = sc.nextInt();
        sc.nextLine(); // newline


        // quick validation
        if(col != row2){
        System.out.println("The Matrix are un-multipliable.");
            return;
        }

        int[][] matrix2 = new int[rows2][cols2];
        System.out.println("Enter the matrix_1 row by row (comma-separated values):");

        for (int i = 0; i < rows2; i++) {
            String line = sc.nextLine().trim();
            if (!line.matches("^[0-9,\\s-]+$")) {
                System.out.println("Invalid input format. Only numbers and commas are allowed.");
                return;
            }

            String[] values = line.split(",");
            if (values.length != cols2) {
                System.out.println("Invalid number of columns in row " + (i + 1));
                return;
            }

            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = Integer.parseInt(values[j].trim());
            }
        }

    }
}