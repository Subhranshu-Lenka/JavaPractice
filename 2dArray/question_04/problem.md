# Problem : Rotate Image / Matrix 

## Problem Statement
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Write a function, `rotateImage(int[][] matrix)`, that rotates the given matrix.

You must also **write a `main` method** that performs the following steps:

   1. **Takes input** for the matrix from the user.
   2. **Validates the input matrix format**, ensuring it contains only numbers separated by commas (with optional spaces).
   3. **Calls the `rotateImage()` function** with the validated matrix.
   4. **Displays the result** appropriately.
---

### Example 1 :

**Input:**

```text
matrix = [
  [1,2,3],
  [4,5,6],
  [7,8,9]
]
```

**Output:**

```
[
    [7,4,1],
    [8,5,2],
    [9,6,3]
]
```

### Example 2 :

**Input:**

```text
matrix = [
  [5,1,9,11],
  [2,4,8,10],
  [13,3,6,7],
  [15,14,12,16]
]
```

**Output:**

```
[
   [15,13,2,5],
   [14,3,4,1],
   [12,6,8,9],
   [16,7,10,11]
]
```

## Code
```java
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
```

## Terminal Output
```
$ java Solution
Enter number of rows:
3
Enter number of columns:
3
Enter the matrix row by row (comma-separated values):
1,2,3
4,5,6
7,8,9

Input matrix:
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]

Output matrix:
[7, 4, 1]
[8, 5, 2]
[9, 6, 3]
```