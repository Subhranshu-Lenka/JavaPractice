# Problem : Roman to Integer

## Problem Statement

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

> `Symbol       Value`
>
> `I       =      1`
>
> `V       =      5`
>
> `X       =      10`
>
> `L       =      50`
>
> `C       =      100`
>
> `D       =      500`
>
> `M       =      1000`

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Write a function `romanToInt(String s)` that converts a **Roman numeral** into an **integer**.

If the given string is **not a valid Roman numeral**, your program should print an appropriate message and exit.

You must also write a **main** function that:

- Takes user input for a Roman numeral string.
- Validates whether it is a **valid Roman numeral**.
- Calls the `romanToInt()` function and prints the integer value.

### Example 1:

> **Input:** s = "III"
>
> **Output:** 3
>
> **Explanation:** III = 3.

### Example 2:

> **Input:** s = "LVIII"
>
> **Output:** 58
>
> **Explanation:** L = 50, V= 5, III = 3.

### Example 3:

> **Input:** s = "MCMXCIV"
>
> **Output:** 1994
>
> **Explanation:** M = 1000, CM = 900, XC = 90 and IV = 4.

## Code

```java
import java.util.Scanner;

class Solution {

    public static boolean isValidRoman(String s) {
    if (s == null || s.isEmpty()) return false;

    // Roman numerals can only use these characters
    if (!s.matches("^[IVXLCDM]+$")) return false;

    // Strict Roman numeral validation using regex
    // Covers subtractive rules like IV, IX, XL, XC, CD, CM
    String romanRegex =
        "^M{0,3}" +                 // Thousands - 0 to 3000
        "(CM|CD|D?C{0,3})" +        // Hundreds - 900 (CM), 400 (CD), 0-300 (C, CC, CCC)
        "(XC|XL|L?X{0,3})" +        // Tens - 90 (XC), 40 (XL), 0-30 (X, XX, XXX)
        "(IX|IV|V?I{0,3})$";        // Ones - 9 (IX), 4 (IV), 0-3 (I, II, III)

    return s.matches(romanRegex);
}

    public static int value(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public static int romanToInt(String s) {
        s = s.toUpperCase();
        int sum = 0;
        int length = s.length();

        for(int i=0;i<length;i++){
            int currValue = value(s.charAt(i));

            if(i+1 < length && currValue < value(s.charAt(i+1))){
                sum-=currValue;
            }
            else{
                sum+=currValue;
            }
        }
        return sum;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter you roman string / roman number.");
        String s = sc.nextLine().trim().toUpperCase();

        if(!isValidRoman(s)){
            System.out.println("Invalid Roman Literal. Quiting the program ...");
            return;
        }

        int result = romanToInt(s);

        System.out.println("The computed value of your roman number is :  "+result);
    }
}
```

## Terminal Output

```
$ java Solution
Enter you roman string / roman number.
MCMXCIV
The computed value of your roman number is :  1994
```
