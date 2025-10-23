# Problem : Find and Replace in a File

## Problem Statement

Write a program that reads the contents of a text file, replaces all occurrences of a **target word or phrase** with a **replacement word or phrase**, and writes the modified content to a new file.

Given:

- A file name (e.g., `input.txt`)
- Two strings:
  - **Find** → the text to search for
  - **Replace** → the text to replace it with

The program should create a new file (e.g., `output.txt`) containing the updated text.

## Example

**Input File (`input.txt`):**

```text
There was an error in the system.
The error caused a system crash.
```

**Find:** `error`  
**Replace:** `warning`

**Output File (`output.txt`):**

```text
There was a warning in the system.
The warning caused a system crash.
```
