# Problem: Search a 2D Matrix

## Problem Statement

You are given an `m x n` integer matrix `matrix` with the following properties:

1. Each row is sorted in **non-decreasing order**.
2. The **first integer of each row** is greater than the **last integer of the previous row**.
3. You must also **write a `main` method** that performs the following steps:

   1. **Takes input** for the matrix and the target value from the user.
   2. **Validates the input matrix format**, ensuring it contains only numbers separated by commas (with optional spaces).
   3. **Calls the `searchMatrix()` function** with the validated array and target value.
   4. **Displays the result** appropriately.

Given an integer `target`, return `true` if `target` is present in the matrix, or `false` otherwise.

---

### Example 1 : Target Exists

**Input:**

```text
matrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60]
]
target = 3
```

**Output:**

```
Result: Target found!
```

### Example 2 : Target Doesn't Exists

**Input:**

```text
matrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60]
]
target = 13
```

**Output:**

```
Result: Target Not found!
```

### Constraints:

- You must write a solution in `O(log(m * n))` time complexity.

## Code

```java
import java.util.*;
class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        ArrayList<Integer> fEle = new ArrayList<Integer>();

        for(int[] row : matrix){
            fEle.add(row[0]);
        }

        //binary search
        int low=0;
        int high=fEle.size()-1;
        int rowIndex = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            //break point
            if((mid==fEle.size()-1)||(target >= fEle.get(mid) && target < fEle.get(mid+1))){
                rowIndex = mid;
                break;
            }

            if(target > fEle.get(mid)){
                low = mid+1;
            }
            else{
                high = mid-1;
            }

        }

        if(rowIndex==-1) return false;

        // actual row searching
        low=0;
        int[] searchRow = matrix[rowIndex];
        high=searchRow.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(target == searchRow[mid]){
                return true;
            }

            if(target > searchRow[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return false;
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

        System.out.println("Enter target value:");
        int target = sc.nextInt();

        Solution sol = new Solution();
        boolean found = searchMatrix(matrix, target);

        System.out.println("Result: " + (found ? "Target found!" : "Target not found."));
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
1,5,6
6,8,7
11,25,10
Enter target value:
11
Result: Target found!
```
