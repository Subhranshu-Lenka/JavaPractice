import java.util.*;

class Solution{

    public static void rotateImage(int matrix[][]){
        //transpose
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<=i; j++){
                //swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<matrix.length; i++){ // 2-pointer reversal

            int left = 0;
            int right = matrix[i].length-1;

            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        } 
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns:");
        int cols = sc.nextInt();
        sc.nextLine(); // consume newline

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

        rotateImage(matrix);

        System.out.println();
        System.out.println("Output matrix: ");
        for(int arr[] : matrix){
            System.out.println(Arrays.toString(arr));
        }
    }
}