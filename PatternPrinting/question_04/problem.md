# Problem : Number Pyramid

## Problem Statement

Write a program that prints a **pyramid of numbers** with `n` rows.

- Each row `i` should contain numbers from `1` up to `i`.
- The numbers should form a symmetric pyramid.

## Input

- An integer `n` representing the number of rows.

## Output

- A number pyramid with `n` rows.

## Example

**Input:**

`5`

**Output:**

```
    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5
```

# Code

```java
import java.util.Scanner;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows for the pattern.");

        int n = sc.nextInt();

        System.out.println();
        System.out.println("Pattern :");
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(j + " ");
            System.out.println();
        }
    }
}
```

# Terminal Output

```
$ java Solution
Enter the number of rows for the pattern.
5

Pattern :

    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5
```
