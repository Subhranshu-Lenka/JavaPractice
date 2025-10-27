# Problem : Flood Fill Algorithm

## Problem Statement
You are given a 2D grid image[][], where each `image[i][j]` represents the color of a pixel in the image. Also provided is a coordinate`(sr, sc)` representing the starting pixel (row and column) and a new color value newColor.

Your task is to perform a flood fill starting from the pixel (sr, sc), changing its color and the color of all connected pixels that have the same original color. 

Two pixels are considered connected if they are `adjacent horizontally or vertically (not diagonally)` and have the `same original color`.

- Write a function, `floodFill()`, that Flood-Fills the given matrix.

- You must also **write a `main` method** that performs the following steps:

   1. **Takes input** for the matrix, starting coordinates (sr,sc) and new-color from the user.
   2. **Validates the input matrix format**, ensuring it contains only numbers separated by commas (with optional spaces).
   3. **Calls the `floodFill()` function** with the validated matrix.
   4. **Displays the result** appropriately.

## Example:
**Input**

![Alt text](https://media.geeksforgeeks.org/wp-content/uploads/20250411185458270414/111.webp "Input Image")
```
image = [
        [1, 1, 1, 0], 
        [0, 1, 1, 1], 
        [1, 0, 1, 1]
    ], 

sr = 1, 
sc = 2, 
newColor = 2
```

**Output**

![Alt text](https://media.geeksforgeeks.org/wp-content/uploads/20250411185456443739/222.webp "Input Image")

```
image = [
        [2, 2, 2, 0], 
        [0, 2, 2, 2], 
        [1, 0, 2,2]
    ] 
```
**Explanation:**
```
Starting from pixel (1, 2) with value 1, flood fill updates all connected pixels (up, down, left, right) with value 1 to 2, resulting in [[2, 2, 2, 0], [0, 2, 2, 2], [1, 0, 2, 2]].
```

## Code
```java
import java.util.*;

class Solution {
    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] == newColor) {
            return image;
        }

        int oldColor = image[sr][sc];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        // Change the color of the starting pixel
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0], y = front[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                // Check boundary conditions and color match
                if (nx >= 0 && nx < image.length && 
                    ny >= 0 && ny < image[0].length && 
                    image[nx][ny] == oldColor) {

                    // Change the color and enqueue
                    image[nx][ny] = newColor;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return image;
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

        System.out.println("Enter the starting x-coordinate");
        int starting_x = sc.nextInt(); 
        System.out.println("Enter the starting y-coordinate");
        int starting_y = sc.nextInt(); 
        System.out.println("Enter the new color value (integer).");
        int new_color = sc.nextInt(); 

        System.out.println();
        System.out.println("Input image: ");
        for(int arr[] : matrix){
            System.out.println(Arrays.toString(arr));
        }

        int newImage[][] = floodFill(matrix,starting_x,starting_y,new_color);

        System.out.println();
        System.out.println("Output image: ");
        for(int arr[] : newImage){
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
4
Enter the matrix row by row (comma-separated values):
1, 1, 1, 0
0, 1, 1, 1
1, 0, 1, 1
Enter the starting x-coordinate
1
Enter the starting y-coordinate
2
Enter the new color value (integer).
2

Input image:
[1, 1, 1, 0]
[0, 1, 1, 1]
[1, 0, 1, 1]

Output image:
[2, 2, 2, 0]
[0, 2, 2, 2]
[1, 0, 2, 2]
```

