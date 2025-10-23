# Problem : Right-Angled Triangle of Stars

## Problem Statement

Write a program that prints a `right-angled triangle` made of stars (`*`) with **n rows**.

Each row `i` should contain exactly `i` stars.

## Input

- An integer `n` representing the number of rows.

## Output

- A right-angled triangle of stars with `n` rows.

## Example

**Input:**
`5`

**Output:**

```
*
**
***
****
*****
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
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
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
**
***
****
*****
```
