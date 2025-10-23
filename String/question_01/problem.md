# Problem 1: Longest Common Prefix

## Problem Statement

Write a function, `longestCommonPrefix(String[] strs)`, that finds the **longest common prefix** string among an array of strings.

If there is **no common prefix**, return an empty string `""`.

- You must also write a **main** function that:
  - Takes user input for an array of strings (comma- separated).
    - Example input: apple, application, appstore
  - Validates the input using a regular expression.
  - Splits and trims the strings into an array.
  - Calls the longestCommonPrefix() method and prints the result.

---

### Example 1: Common Prefix Found

**Input:**

```java
strs = ["flower", "flow", "flight"]
```

**Output:**

```java
"fl"
```

**Explanation:**
The longest common prefix among the three strings is "fl".

### Example 2: No Common Prefix Found

**Input:**

```java
strs = ["dog", "racecar", "car"]
```

**Output:**

```java
""
```

**Explanation:**
There is no common prefix among the input strings.

## Code

```java
import java.util.Scanner;
import java.util.Arrays;
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        String longest = strs[0];

        for(int i=1;i<strs.length;i++){
            if(longest.length()==0){
                return longest;
            }

            for(int j=0; j<Math.min(longest.length(),strs[i].length()); j++){
                if(longest.charAt(j)!=strs[i].charAt(j)){
                    longest  = longest.substring(0,j);
                    break;
                }
            }
            longest = longest.substring(0,Math.min(longest.length(),strs[i].length()));
        }

        return longest;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String inputRegex = "^\\s*\\w+(\\s*,\\s*\\w+)*\\s*$";
        /* valid inputs
           "apple,banana,cherry" ✅
            "apple, banana, cherry " ✅
            " apple , banana " ✅
        */

        System.out.println();
        System.out.println("Enter the string array (comma-separated, optional spaces). \nFor example: apple, banana, cherry");

        String inputArr = sc.nextLine();

        System.out.println();
        if(inputArr.matches(inputRegex)){
            System.out.println("The input array is corect.");
        }
        else{
            System.out.println("The input array is in-corect. Exiting the program...");
            return;
        }

        String[] arr = Arrays.stream(inputArr.split(","))
                        .map(String::trim)
                        .toArray(String[]::new);

        String result = longestCommonPrefix(arr);

        System.out.println();
        System.out.println();
        System.out.println("The most common longest prefix is : '"+result+"'");
    }
}
```

## Terminal Output

```
$ java Solution

Enter the string array (comma-separated, optional spaces).
For example: apple, banana, cherry
flower,flow,flight

The input array is corect.

The most common longest prefix is : 'fl'
```
