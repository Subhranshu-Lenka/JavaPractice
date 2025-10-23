# Problem : Anagram

## Problem Statement

Given two non-empty strings s1 and s2, consisting only of lowercase English letters, determine whether they are anagrams of each other or not.

Two strings are considered anagrams if they contain the same characters with exactly the same frequencies, regardless of their order.

Write a function `checkAnagram(String s1, String s2)` that returns:

- `true` if both strings are anagrams.
- `false` otherwise.
- You must also write a **main** function that:
  - Takes user input for two strings.
  - Sanitizes the input and ensures the string contains only lowercase English letters.
  - Calls the `checkAnagram()` function and prints the result.

---

### Example 1:

> **Input:** s1 = "geeks" s2 = "kseeg"
>
> **Output:** true
>
> **Explanation:** Both the string have same characters with same frequency. So, they are anagrams.

### Example 2:

> **Input:** s1 = "allergy", s2 = "allergyy"
>
> **Output:** false
>
> **Explanation:** Although the characters are mostly the same, s2 contains an extra 'y'
> character. Since the frequency of characters differs, the strings are not anagrams.

### Example 3:

> **Input:** s1 = "listen", s2 = "lists"
>
> **Output:** false
>
> **Explanation:** The characters in the two strings are not the same — some are missing or extra. So, they are not anagrams.

## Code

```java
import java.util.Scanner;
import java.util.HashMap;

class Solution{
    public static boolean checkAnagram(String str1, String str2){

        if(str1.length() != str2.length()) return false;

        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(char ch : str1.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }

        for(char ch : str2.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)-1);
        }

        for(var data : freqMap.entrySet()){
            if(data.getValue()!=0){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String str1,str2;

        System.out.println("Enter the string-1");
        str1 = sc.nextLine().trim().toLowerCase();
        System.out.println("Enter the string-2");
        str2 = sc.nextLine().trim().toLowerCase();
        // System.out.println("Input String "+str1+" "+str2);

        boolean result = checkAnagram(str1,str2);
        System.out.println(result);
        System.out.printf("Given two strings '%s', '%s' %s%s", str1, str2, result ? "are" : "are not", " Anagram");

        return;
    }
}
```

## Terminal Output

```
$ java Solution
Enter the string-1
tea
Enter the string-2
ate
true
```
