# Problem : Copy Contents from One File to Another

## Problem Statement

Write a program that reads the contents of `input.txt` and writes the **same contents** to a new file named `output.txt`.

If either file does not exist, your program should **create it automatically**.  
Ensure that the copied file has the exact same text as the original, including spaces, newlines, and special characters.

## Input

- A text file named `input.txt` containing any text.

## Output

- A new text file named `output.txt` containing the same contents as `input.txt`.

## Example

**Input File (`input.txt`):**

```text
Hello World
This is a sample file.
File copy test.
```

**Output File (`output.txt`):**

```text
Hello World
This is a sample file.
File copy test.
```

## Code

```java
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path. Select the source file.");
        String inputPath = sc.nextLine().trim();

        System.out.println("Enter the file path. Select the destination file.");
        String outputPath = sc.nextLine().trim();

        try{
            FileInputStream in = new FileInputStream(inputPath);
            FileOutputStream out = new FileOutputStream(outputPath);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();
            System.out.println("File copied successfully.");
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
Enter the file path. Select the source file.
C:\Users\SDE\Desktop\JavaPractice\FileSystem\question_05\input.txt
Enter the file path. Select the destination file.
C:\Users\SDE\Desktop\JavaPractice\FileSystem\question_05\output.txt
File copied successfully.
Ending the Program.
```

## Inside `input.txt`

```
Hello world
This is a test file.
It contains multiple lines.
```

## Inside `output.txt`

```
Hello world
This is a test file.
It contains multiple lines.
```
