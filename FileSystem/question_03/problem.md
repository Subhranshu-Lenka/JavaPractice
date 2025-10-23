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

## Code

```java
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string you want to append to a file.");
        String inputStr = sc.nextLine().trim();

        System.out.println("Enter the file path where you want to append. Please select only text files for output.");
        String inputPath = sc.nextLine().trim();

        try{
            FileWriter fw = new FileWriter(inputPath, true); // true → append mode
            fw.write(inputStr + "\n");
            fw.close();
            System.out.println("Data appended successfully.");
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
Enter the string you want to append to a file.
New data line
Enter the file path where you want to append. Please select only text files for output.
C:\Users\SDE\Desktop\JavaPractice\FileSystem\question_03\sample.txt
Data appended successfully.
Ending the Program.
```

## Inside `sample.txt`

Before

```
Hello this is a line.
```

After

```
Hello this is a line.
New data line
```
