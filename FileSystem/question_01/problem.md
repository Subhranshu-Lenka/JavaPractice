# Problem : Count Words, Lines, and Characters

## Problem Statement

Write a program that reads a text file and prints the **total number of lines**, **words**, and **characters** in it.

Your program should handle any plain text file and produce accurate counts even if the file contains multiple spaces, blank lines, or special characters.

## Input

A text file containing any number of lines, words, and characters.

## Output

Print three counts:

- Total number of **lines**
- Total number of **words**
- Total number of **characters**

### Example

**Input File Content (`input.txt`):**

```text
Hello world
This is a test file.
It contains multiple lines.

```

**Output**

```text
Lines: 3
Words: 9
Characters: 53

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
Enter the file path. Please select only text files for output.
C:\Users\SDE\Desktop\JavaPractice\FileSystem\question_01\input.txt
Lines: 3
Words: 11
Characters: 58
End of Program.
```
