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

## Code

```java
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word that you want to find & replace");
        String findStr = sc.nextLine().trim();

        System.out.println("Enter the word that you want to replace with");
        String replaceStr = sc.nextLine().trim();

        System.out.println("Enter the file path. Please select only text files for output.");
        String inputPath = sc.nextLine().trim();

        try{
            String content = new String(Files.readAllBytes(Paths.get(inputPath)));
            content = content.replaceAll(findStr, replaceStr);
            Files.write(Paths.get("output.txt"), content.getBytes());
            System.out.println("Replacements done.");
        }
        catch(Exception err){
            System.out.println("Found errors with the provided file-path.");
            System.out.println(err);
        }
        finally{
            System.out.println("Ending the Program.");
        }
    }
}
```

## Terminal Output

```
$ java Solution
Enter the word that you want to find & replace
system
Enter the word that you want to replace with
environment
Enter the file path. Please select only text files for output.
C:\Users\SDE\Desktop\JavaPractice\FileSystem\question_04\sample.txt
Replacements done.
Ending the Program.
```

## Inside `sample.txt`

```
There was an error in the system.
The error caused a system crash.
```

## Inside `output.txt`

```
There was an error in the environment.
The error caused a environment crash.
```
