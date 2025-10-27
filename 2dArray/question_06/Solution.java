import java.util.*;

class Solution {
    public static int[] findPeakElement(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int ans[]={-1,-1};

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int curr = matrix[i][j];
                boolean isPeak = true;

                if (i > 0 && matrix[i - 1][j] > curr)
                    isPeak = false;

                if (i + 1 < n && matrix[i + 1][j] > curr)
                    isPeak = false;

                if (j > 0 && matrix[i][j - 1] > curr)
                    isPeak = false;

                if (j + 1 < m && matrix[i][j + 1] > curr)
                    isPeak = false;

                if (isPeak) {
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns:");
        int cols = sc.nextInt();
        sc.nextLine(); // newline

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix row by row (comma-separated values):");

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
                matrix[i][j] = Integer.parseInt(values[j].trim());
            }
        }

        System.out.println();
        System.out.println("Input matrix: ");
        for(int arr[] : matrix){
            System.out.println(Arrays.toString(arr));
        }

        int result[] = findPeakElement(matrix);

        System.out.println();
        System.out.println("Peak Element : "+Arrays.toString(result));
    }
}