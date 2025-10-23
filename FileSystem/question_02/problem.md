# Problem : Count Frequency of Each Word

## Problem Statement

Write a program that reads a text file and prints how many times each **word** appears in it.

The program should:

- **Ignore case** (treat “Hello” and “hello” as the same word).
- **Ignore punctuation** (so “word,” and “word” are treated the same).

## Input

- A text file (e.g., `input.txt`) containing any text.

## Output

- A list of words with their frequency counts.

## Example

**Input File (`input.txt`):**

```
Hello world!
This is a test. Hello again, world.
```

**Expected Output:**

```
hello: 2
world: 2
this: 1
is: 1
a: 1
test: 1
again: 1
```

## Code

```java
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path. Please select only text files for output.");
        String inputPath = sc.nextLine().trim();

        try{
            BufferedReader br = new BufferedReader(new FileReader(inputPath));
            Map<String, Integer> freq = new HashMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                for (String word : line.split("\\s+")) {
                    if (!word.isEmpty()) freq.put(word, freq.getOrDefault(word, 0) + 1);
                }
            }
            br.close();
            freq.forEach((k, v) -> System.out.println(k + " - " + v));
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

## Terminal output

```
$ java Solution
Enter the file path. Please select only text files for output.
C:\Users\SDE\Desktop\JavaPractice\FileSystem\question_02\input.txt
a - 1
contains - 1
world - 1
file - 1
test - 1
this - 1
multiple - 1
is - 1
hello - 1
it - 1
lines - 1
Ending the Program.
```

Inside `input.txt`

```
Hello world
This is a test file.
It contains multiple lines.
```
