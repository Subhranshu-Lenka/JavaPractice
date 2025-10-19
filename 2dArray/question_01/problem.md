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

### 🧠 Example 1 : Target Exists

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
```java
true
```

### 🧠 Example 2 : Target Doesn't Exists

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
```java
false
```

### Constraints:
- You must write a solution in `O(log(m * n))` time complexity.
- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 100
- -104 <= matrix[i][j], target <= 104