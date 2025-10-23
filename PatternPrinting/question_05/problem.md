# Problem : Floyd’s Triangle

## Problem Statement

Write a program that prints **Floyd’s Triangle** — a right-angled triangle of **consecutive numbers** starting from `1`, arranged row by row.

- Row 1 contains 1 number, row 2 contains 2 numbers, row 3 contains 3 numbers, and so on.

## Input

- An integer `n` representing the number of rows.

## Output

- Floyd’s Triangle with `n` rows.

## Example

**Input:**

`5`

**Output:**

```
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
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

        int a=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++){
                System.out.print(a + " ");
                a++;
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

1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
```
