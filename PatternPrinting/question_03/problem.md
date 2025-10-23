# Problem : Pyramid of Stars

## Problem Statement

Write a program that prints a **symmetric pyramid** made of stars (`*`) with **n rows**.

- The first row should have 1 star centered.
- Each subsequent row should increase by 2 stars, forming a symmetric pyramid.

## Input

- An integer `n` representing the number of rows.

## Output

- A symmetric pyramid of stars with `n` rows.

## Example

**Input:**
`5`

**Output:**

```
    *
   ***
  *****
 *******
*********
```

## Code

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
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }
}
```

## Terminal Output

```
$ java Solution
Enter the number of rows for the pattern.
5

Pattern :

    *
   ***
  *****
 *******
```
