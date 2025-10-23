# Problem: Product of Array Except Self

## Problem Statement

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

Do not use division, and solve in O(n) time.

If any array element is `0`, then the division may cause `divide by 0` exceoption.

Write a function `productExceptSelf(nums)` that takes an array of integers (`nums`) as input.  
The goal is to return an array `answer` such that `answer[i]` is equal to the **product of all elements in `nums` except `nums[i]`**.

- **Do not use division**.
- Solve the problem in **O(n) time**.
- If the array contains `0`, handle it properly to avoid division errors.

You must also **write a `main` method** that performs the following steps:

1. **Takes input** for the array from the user.
2. **Validates the input array format**, ensuring it contains only numbers separated by commas (with optional spaces).
3. **Calls the `productExceptSelf()` function** with the validated array.
4. **Displays the result** appropriately.

## Example 1

```
Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation:

For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
```

## Example 2

```
Input: arr[] = [12, 0]
Output: [0, 12]
Explanation:

For i = 0, res[i] = 0.
For i = 1, res[i] = 12.
```

## Code

```java
import java.util.Scanner;
import java.util.Arrays;

class Solution{

    public static int[] productExceptSelf(int arr[]){
        int n = arr.length;

        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        int[] result = new int[n];

        prefixProduct[0] = 1;
        for(int i=1; i<n; i++){
            prefixProduct[i] = arr[i-1] * prefixProduct[i-1];
        }

        suffixProduct[n-1]=1;
        for(int j=n-2; j>=0; j--){
            suffixProduct[j] = arr[j+1] * suffixProduct[j+1];
        }

        for(int i=0; i<n; i++){
            result[i] = prefixProduct[i] * suffixProduct[i];
        }

        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String inputRegex = "^\\s*(-?\\d{1,9})(\\s*,\\s*-?\\d{1,9})*\\s*$";

        System.out.println("Enter the integer array \n For eg. 1,2,6,3,56,45....");
        String inputArr = sc.nextLine();

        if(inputArr.matches(inputRegex)){
            System.out.println("The input array is corect.");
        }
        else{
            System.out.println("The input array is in-corect. Exiting the program...");
            return;
        }
        System.out.println();
        int[] arr = Arrays.stream(inputArr.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();

        System.out.println("Input array "+Arrays.toString(arr));

        int result[] = productExceptSelf(arr);

        System.out.println("Result "+Arrays.toString(result));
    }
}
```

## Terminal Output

```
$ java Solution
Enter the integer array
 For eg. 1,2,6,3,56,45....
10, 3, 5, 6, 2
The input array is corect.

Input array [10, 3, 5, 6, 2]
Result [180, 600, 360, 300, 900]
```
