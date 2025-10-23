# Problem: Find All Duplicates in an Array

## Problem Statement

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others once.

Find all the elements that appear twice.

## Example 1:

```text
Input: [4,3,2,7,8,2,3,1]
Output: [2,3]
```

## Example 2:

```text
Input: [1,1,2]
Output: [1]
```

## Code

```java
import java.util.*;

class Solution{

    public static ArrayList<Integer> findDuplicateElements(int arr[]){
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num , map.getOrDefault(num,0)+1);
        }

        for(var pair : map.entrySet()){
            if(pair.getValue()!=1){
                result.add(pair.getKey());
            }
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

        ArrayList<Integer> result = findDuplicateElements(arr);

        System.out.println("Result "+result);
    }
}
```

## Terminal Output

```
$ java Solution
Enter the integer array
 For eg. 1,2,6,3,56,45....
4,3,2,7,8,2,3,1
The input array is corect.

Input array [4, 3, 2, 7, 8, 2, 3, 1]
Result [2, 3]
```
