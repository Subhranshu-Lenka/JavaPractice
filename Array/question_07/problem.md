# Problem : Self Dividing Numbers

## Problem Statement

A  _self-dividing number_ is a number that is divisible by every digit it contains.

- For example, `128` is a  _self-dividing number_ because `128 % 1 == 0`, `128 % 2 == 0`, and `128 % 8 == 0`.

A  _self-dividing number_ is not allowed to contain the digit zero.

Given two integers `left` and `right`, return a list of all the  _self-dividing numbers_ in the range `[left, right]` (**both inclusive**).

- Write a function `selfDividingNumber(left, right)` that takes two integers `left, right`.

- You must also **write a `main` method** that performs the following steps:

  1. **Takes inputs** `left`, `right` from the user.
  2. **Calls the `selfDividingNumber()` function**.
  3. **Displays the result** appropriately.

## Example 1:
```
Input: left = 1, right = 22

Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
```

## Example 1:
```
Input: left = 47, right = 85

Output: [48,55,66,77]
```

## Code
```java
import java.util.Scanner;
import java.util.*;

class Solution{

    public static List<Integer> selfDividingNumbers(int left, int right){
        List<Integer> arr = new ArrayList<>();

        for(int num = left; num<=right; num++){

            if (num % 10 == 0 || num % 100 == 0 || num % 1000 == 0)
            continue;

            if(num>0 && num<10){
                arr.add(num);
                continue;
            }

            int temp = num;
            boolean flag = true;
            while(temp!=0){
                int digit = temp%10;

                if(digit==0 || num%digit!=0){
                    flag = false;
                    break;
                }

                temp = temp/10;
            }

            if(flag){
                arr.add(num);
            }
        }

        return arr;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 'left' starting integer.");
        int left = sc.nextInt();

        System.out.println("Enter 'right' ending integer.");
        int right = sc.nextInt();

        List<Integer> result = selfDividingNumbers(left,right);

        System.out.println("result "+ result);
    }
}
```

## Terminal Output
```
$ java Solution
Enter 'left' starting integer.
1
Enter 'right' ending integer.
22
result [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
```