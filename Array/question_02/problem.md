# Problem: Maximum Subarray Sum (Kadane’s Algorithm)

## Problem Statement

Given an integer array `arr[]`, find the **subarray** (containing at least one element) which has the **maximum possible sum**, and return that sum.

> Note: A subarray is a **continuous part** of an array.

---

### 🧠 Examples

**Example 1:**

```text
Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray [7, -1, 2, 3] has the largest sum = 11.
```

**Example 2:**

```text
Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray [-2] has the largest sum -2.
```

**Example 3:**

```text
Input: arr[] = [5, 4, 1, 7, 8]
Output: 25
Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
```

## Code

```java
import java.util.Scanner;
import java.util.Arrays;

class Solution2{

    public static int maximumSubArraySum(int[] arr){
        int res = arr[0];
        int maxEnding = arr[0];

        // Kadane's appraoch O(n)
        for(int i=1;i<arr.length;i++){
            maxEnding = Math.max(arr[i] ,maxEnding + arr[i]);

            res = Math.max(res,maxEnding);
        }

        return res;

    }

    public static void main(String args[]){
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
            System.out.println("The input array is in-corect. Exiting the program...");
            return;
        }

        int[] arr = Arrays.stream(inputArr.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();


        int result = maximumSubArraySum(arr);

        System.out.println("The maximum sub-array sum is : "+result);
    }
}
```

## Terminal Output

```
$ java Solution2

Enter the integer array
 For eg. 1,2,6,3,56,45....
5, 4, 1, 7, 8

The input array is corect.
The maximum sub-array sum is : 25
```
