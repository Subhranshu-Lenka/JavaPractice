# Problem : Longest Substring Without Repeating Characters

## Problem Statement

Given a string s, find the length of the longest substring that contains no repeating characters.
A substring is a contiguous sequence of characters within the string.

Write a function `Longest_Substring_Without_Repeating_Characters(String s)` that finds `Longest Substring Without Repeating Characters` from the given string.

You must also write a **main** function that:

- Takes user input for a string.
- Calls the `Longest_Substring_Without_Repeating_Characters()` function and prints the result value.

### Example 1:

> **Input:** s = "abcabcbb"
>
> **Output:** substring = abc , size = 3
>
> **Explanation:** The answer is "abc", with a length of 3.

### Example 2:

> **Input:** s = "pwwkew"
>
> **Output:** substring = wke , size = 3
>
> **Explanation:** The longest substring without repeating characters is "wke".

## Code

```java
import java.util.Scanner;
import java.util.HashMap;

class Solution{

    public static String Longest_Substring_Without_Repeating_Characters(String str){
        int n = str.length();
        HashMap<Character,Integer> charMap = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        String subStr="";

        for(int i=0; i<n; i++){
            char c= str.charAt(i);

            if(charMap.containsKey(c) && charMap.get(c)>=left){
                left = charMap.get(c)+1;
            }

            charMap.put(c,i);

            int currLen = i - left + 1;

            if(currLen>maxLen){
                maxLen = currLen;
                subStr = str.substring(left,i+1);
            }
        }

        return subStr;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String.");
        String s = sc.nextLine().trim();

        String result = Longest_Substring_Without_Repeating_Characters(s);
        System.out.printf("substring = '%s', size = %d",result, result.length());
    }
}
```

## Terminal Output

```
$ java Solution
Enter a String.
pwwkew
substring = 'wke', size = 3
```
