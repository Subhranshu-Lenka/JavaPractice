# Problem : Two Sum Problem

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

## Example 1: Solution Found

**Input:**

```text
nums = [2, 7, 11, 15]
target = 9
```

**Output:**

```text
[0,1]
```

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
```

**Explanation:**
No two numbers in the array sum to 20, so we return an empty array.

## Constraints

You must find the solution with a time complexity between $O(n^2)$ and $O(n)$.

## Code

```java
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

class Solution2{
    // Solution in O(n)
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int sub = 0;
        for(int i = 0; i < nums.length; ++i) {
            sub = target - nums[i];
            if(mpp.containsKey(sub))
                return new int[]{mpp.get(sub), i};
            mpp.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);

        String inputRegex = "^\\s*(-?\\d{1,9})(\\s*,\\s*-?\\d{1,9})*\\s*$";
        /* valid inputs
            "123, 456,789",
            "1,2,3",
            "  12 , 34 , 56  "
        */

        System.out.println();
        System.out.println("Enter the integer array \n For eg. 1,2,6,3,56,45....");

        String inputArr = sc.nextLine();

        System.out.println();
        if(inputArr.matches(inputRegex)){
            System.out.println("The input array is corect.");
        }
        else{
            System.out.println("The input array is in-corect. Existing the program...");
            return;
        }

        String[] inputs = inputArr.split(",");

        int[] arr = Arrays.stream(inputs)
                    .map(String::trim)  //space removal
                    .mapToInt(Integer::parseInt) // cast to int
                    .toArray();

        System.out.println();
        System.out.println("Given int arr "+ Arrays.toString(arr));

        System.out.println();
        System.out.println("Enter the target (the specific sum you want to find)");
        int target = sc.nextInt();

        int[] result = twoSum(arr,target);
        String message;
        if(result.length>0){
            message = String.format("[%d,%d]",result[0],result[1]);
        }
        else{
            message= "[]";
        }
        System.out.println(message);
    }
}
```

## Terminal Output

```
$ java Solution2

Enter the integer array
 For eg. 1,2,6,3,56,45....
2, 7, 11, 15

The input array is corect.

Given int arr [2, 7, 11, 15]

Enter the target (the specific sum you want to find)
9
[0,1]
```
