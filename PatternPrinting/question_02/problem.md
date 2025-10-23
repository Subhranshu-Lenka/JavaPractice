# Problem : # Inverted Right-Angled Triangle

## Problem Statement

Write a program that prints an `inverted right-angled triangle` made of stars (`*`) with **n rows**.

The first row should contain `n` stars, the second row `n-1`, and so on, until the last row contains 1 star.

## Input

- An integer `n` representing the number of rows.

## Output

- An inverted right-angled triangle of stars with `n` rows.

## Example

**Input:**
`5`

**Output:**

```
*****
****
***
**
*
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

        for (int i = n; i >= 1; i--) {
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

*****
****
***
**
*
``` 