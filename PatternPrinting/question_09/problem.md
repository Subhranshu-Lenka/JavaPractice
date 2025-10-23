# Problem : Zig-Zag Pattern

## Problem Statement

Write a program that prints a **zig-zag pattern of stars (`*`)** across 3 rows for `n` columns.

- The stars should follow a diagonal pattern, creating a zig-zag across the three rows.

## Input

- An integer `n` representing the number of columns.

## Output

- A 3-row zig-zag pattern of stars.

## Example

**Input:**

`9`

**Output:**

```
  *   *   *
 * * * * *
*   *   *
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

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i + j) % 4 == 0 || (i == 2 && j % 4 == 0)) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
```

## Terminal output

```
$ java Solution
Enter the number of rows for the pattern.
25

Pattern :

  *   *   *   *   *   *
 * * * * * * * * * * * *
*   *   *   *   *   *   *
```
