# Problem : Find the Peak Element in a 2D Array/Matrix

## Problem Statement
Given a 2D matrix mat[][], identify any `peak element` within the matrix. 

An element is considered a peak if it is greater than or equal to its four immediate neighbors: `top, bottom, left, and right`. For corner and edge elements, any missing neighbors are treated as having a value of `negative infinity`.

_A peak element is not necessarily the global maximum, it only needs to satisfy the condition relative to its adjacent elements. `Multiple peak elements may exist`, and the algorithm may return any one of them._

- Write a function `findPeakElement()` that take the input matrix and returns the first peak element.
- You must also **write a `main` method** that performs the following steps:

   1. **Takes input** for the matrix from the user.
   2. **Validates the input matrix format**, ensuring it contains only numbers separated by commas (with optional spaces).
   3. **Calls the `findPeakElement()` function** with the validated matrix.
   4. **Displays the result** appropriately.

## Example 1
```
Input: matrix[][] = [
            [10, 20, 15],
            [21, 30, 14],
            [7,  16, 32]
        ]

Output: [1, 1]

Explanation:  
The value at index {1, 1} is 30, which is greater than or equal to all its valid neighbors: Left = 21, Right = 14, Top = 20, Bottom = 16. So, it satisfies the peak condition. Alternatively, {2, 2} with value 32 also qualifies as a peak.
```
## Example 2
```
Input: mat[][] = [
            [17, 7],
            [11, 10]
        ]

Output: [0, 0]

Explanation: 
The value at index {0 0} is 17. Its neighbors are: Right= 7, Bottom = 11. Since 17 is greater than or equal to both (and top and left are out of bounds), it qualifies as a peak element.
```

## Code
```java
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
```

## Terminal Output
```
$ java Solution
Enter number of rows:
3
Enter number of columns:
3
Enter the matrix row by row (comma-separated values):
10, 20, 15
21, 30, 14
7,  16, 32

Input matrix:
[10, 20, 15]
[21, 30, 14]
[7, 16, 32]

Peak Element : [1, 1]
```
