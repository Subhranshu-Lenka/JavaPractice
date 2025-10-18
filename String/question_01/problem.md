# Problem 1: Longest Common Prefix

## Problem Statement

Write a function, `longestCommonPrefix(String[] strs)`, that finds the **longest common prefix** string among an array of strings.

If there is **no common prefix**, return an empty string `""`.

- You must also write a **main** function that:
    - Takes user input for an array of strings (comma- separated).
        - Example input: apple, application, appstore
    - Validates the input using a regular expression.
    - Splits and trims the strings into an array.
    - Calls the longestCommonPrefix() method and prints the result.

---

### Input / Output

| Parameter | Type | Description |
|------------|------|-------------|
| `strs` | Array of Strings | The list of strings to analyze for a common prefix. |

| Returns | Type | Description |
|----------|------|-------------|
| `longestCommonPrefix` | String | The longest common prefix among all strings. Returns an empty string if none exists. |

---

### Example 1: Common Prefix Found

**Input:**
```java
strs = ["flower", "flow", "flight"]
```

**Output:**
```java
"fl"
```
**Explanation:**
The longest common prefix among the three strings is "fl".

### Example 2: No Common Prefix Found

**Input:**
```java
strs = ["dog", "racecar", "car"]
```

**Output:**
```java
""
```
**Explanation:**
There is no common prefix among the input strings.