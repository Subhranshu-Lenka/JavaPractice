# Problem : Append Data to File

## Problem Statement

Write a program that takes **user input** (such as names, scores, or any text) and **appends** it to an existing file, **without overwriting** the previous content.

If the file does not exist, the program should create it automatically before writing the data.

## Input

- A text value entered by the user (e.g., a name, a score, or a sentence).
- A file (e.g., `data.txt`) where the input should be appended.

## Output

- The input data is added to the end of the file while preserving all existing content.

## Example

**Initial File (`data.txt`):**

```
Alice - 85
Bob - 90
```

**User Input:** `Charlie - 88`

**Updated File (`data.txt`):**

```
Alice - 85
Bob - 90
Charlie - 88
```
