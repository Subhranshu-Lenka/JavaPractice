# Problem : Largest Number

## Problem Statement

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Write a function, `largestNumber(int[] arr)`, that finds the **largest number** among an array of integers.

- You must also write a **main** function that:
  - Takes user input for an array of non-negative integers (comma- separated).
    - Example input: 2,59,9,4,10,89
  - Validates the input using a regular expression.
  - Calls the largestNumber() method and prints the result.

---

### Example 1:
```
Input: nums = [10,2]
Output: "210"
```

### Example 2:
```
Input: nums = [3,30,34,5,9]
Output: "9534330"
```

## Code
```java
import java.util.*;

class Solution{

    public static String largestNumber(int[] nums){
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if (strNums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : strNums) 
            sb.append(s);

        return sb.toString();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String inputRegex = "^\\s*(\\d{1,9})(\\s*,\\s*\\d{1,9})*\\s*$";
        
        System.out.println("Enter the positive integer array \n For eg. 1,2,6,3,56,45....");
        String inputArr = sc.nextLine();

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

        System.out.println("Input array: "+Arrays.toString(arr));
        String result = largestNumber(arr);
        System.out.println("Result : "+result);
    }
}
```
## Terminal Output
```
$ java Solution
Enter the positive integer array 
 For eg. 1,2,6,3,56,45....
3,30,34,5,9
The input array is corect.
Input array: [3, 30, 34, 5, 9]
Result : 9534330
```