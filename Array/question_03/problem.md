# Problem: Merge Sort

## Problem Statement

Implement the **Merge Sort** algorithm to sort an array of integers in ascending order.

Merge Sort is a **divide and conquer** algorithm that works as follows:

1. Divide the array into two halves.
2. Recursively sort each half.
3. Merge the two sorted halves into a single sorted array.

Your task is to write a function that takes an array of integers and returns a sorted array.

**Example 1:**

```text
Input: arr[] = [5, 3, 8, 4, 2]
Output: [2, 3, 4, 5, 8]
```

## Code

```java
import java.util.Scanner;
import java.util.Arrays;

class Solution{
    public static void merge(int[] arr, int low, int mid, int high){
        int n = mid - low + 1;
        int m = high - mid;

        int left[] = new int[n];
        int right[] = new int[m];

        //copy to temp arr
        for(int i = 0; i<n; i++){
            left[i] = arr[low + i];
        }

        for(int i = 0; i<m; i++){
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j=0, k = low;
        while(i< n && j< m){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // residual elements
        while(i<n){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j<m){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low<high){
            int mid = low + (high-low)/2;

            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);

            merge(arr, low, mid, high);
        }
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

        int[] arr = Arrays.stream(inputArr.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();

        System.out.println("Input array before merge sort"+Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println("Input array after merge sort"+Arrays.toString(arr));
    }
}
```

## Terminal Output

```
$ java Solution
Enter the integer array
 For eg. 1,2,6,3,56,45....
5, 3, 8, 4, 2
The input array is corect.
Input array before merge sort[5, 3, 8, 4, 2]
Input array after merge sort[2, 3, 4, 5, 8]
```
