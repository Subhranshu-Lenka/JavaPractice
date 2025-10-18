# Problem 1: Two Sum Problem

## Problem Statement

Write a function `twoSum(nums, target)` that takes an array of integers (`nums`) and an integer (`target`) as input.  
The goal is to find **two numbers in the array** that add up exactly to the `target`.

- Your function should return the **indices** of the two numbers.
- **You may not use the same element twice.**
- If no two numbers sum up to the target, the function should return an empty array (`[]`).
- You must also **write a `main` method** that performs the following steps:

    1. **Takes input** for the array and the target value from the user.  
    2. **Validates the input array format**, ensuring it contains only numbers separated by commas (with optional spaces).  
    3. **Calls the `twoSum()` function** with the validated array and target value.  
    4. **Displays the result** appropriately.
---
---

## Input / Output

| Parameter | Type           | Description                          |
|-----------|----------------|--------------------------------------|
| nums      | Array of Int   | The list of numbers to search through |
| target    | Integer        | The specific sum the two numbers must equal |

**Return:**  

- Array of integers — The indices `[i, j]` of the two numbers that sum to the target.  
- Returns `[]` if no solution is found.

---

## Example 1: Solution Found

**Input:**

```text
nums = [2, 7, 11, 15]
target = 9
```

**Output:**

```text
[0,1]
````

**Explanation:**
Because nums[0] (which is 2) + nums[1] (which is 7) equals 9, we return the indices [0, 1].

## Example 2: No Solution Found

**Input:**

```text
nums = [3, 5, 8]
target = 20
```

**Output:**

```text
[]
````

**Explanation:**
No two numbers in the array sum to 20, so we return an empty array.

Constraints

$2 \le \text{nums.length} \le 10^5$

$-10^9 \le \text{nums}[i] \le 10^9$

$-10^9 \le \text{target} \le 10^9$

You must find the solution with a time complexity between $O(n^2)$ and  $O(n)$.