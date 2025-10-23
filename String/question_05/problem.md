# Problem : Group Anagrams

## Problem Statement

Given an array of strings strs, group all the anagrams together.

Two strings are anagrams if they contain the same characters in different order.

Write a function `groupAnagram(String[] strArr)` that finds `Grouped Anagram` from the given string array.

You must also write a **main** function that:

- Takes user input for a string.
- Calls the `groupAnagram()` function and prints the result value.

### Example 1:

> **Input:** strs = ["eat","tea","tan","ate","nat","bat"]
>
> **Output:** [["eat","tea","ate"],["tan","nat"],["bat"]]
>
> **Explanation:**

### Example 1:

> **Input:** strs = [""]
>
> **Output:** [[""]]
>
> **Explanation:**

## Code

```java
import java.util.*;

class Solution{
    public static String generateHashKey(String s){
        int arr_size = 26; // length of english characters;

        StringBuilder hashString = new StringBuilder();
        int[] frequency = new int[arr_size];

        for(char c : s.toCharArray()){
            frequency[c - 'a'] += 1;  //frequency of each char in str
        }

        for(int i=0; i<arr_size; i++){
            hashString.append(frequency[i]);
            hashString.append("$");
        }

        return hashString.toString();
    }

    public static ArrayList<ArrayList<String>> groupAnagram(String[] strArr){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i<strArr.length; i++){
            String key = generateHashKey(strArr[i]);

            if(!map.containsKey(key)){
                map.put(key,result.size());   // map keep ths index of the keys
                result.add(new ArrayList<>());  // at every index we keep the arraylist of same key,
            }

            result.get(map.get(key)).add(strArr[i]);  // store the string in its respective arraylist index
        }

        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string seperated by ',' comma.  Eg. abc, cdb, xyz ....");
        String[] str = Arrays.stream(sc.nextLine().trim().split(","))
                        .map(String::trim)
                        .toArray(String[]::new);

        ArrayList<ArrayList<String>> result = groupAnagram(str);

        System.out.println(result);
    }
}
```

## Terminal Output

```
$ java Solution
Enter string seperated by ',' comma.  Eg. abc, cdb, xyz ....
eat,tea,tan,ate,nat,bat
[[eat, tea, ate], [tan, nat], [bat]]
```
