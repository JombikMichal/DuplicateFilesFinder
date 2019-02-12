# Duplicate Files Finder

The task is to implement program that will find duplicate files in specified directory
and allow users to perform various operation on them.

## Supported operations

* Delete files.
* Create hard link: <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html#createLink(java.nio.file.Path,java.nio.file.Path)>
* Create soft link: <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html#createSymbolicLink(java.nio.file.Path,java.nio.file.Path,java.nio.file.attribute.FileAttribute...)>

## How to find duplicate files

1. For each file compute its hash by using <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/security/MessageDigest.html>
(<https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/security/DigestInputStream.html> might be useful).
Optionally you can create your own hashing implementation. 

2. If two files have the same hash then compare their content byte by byte.

## Program input

Program receives paths to directories in which it is supposed to find duplicate files as
program arguments. That means they are in `String[] args` variable of the `main` method.

Program will be called in the following manner:
```bash
java package.YourMainClass ${dir1} ${dir2}
```

## Interactive mode

Upon finding a duplicate, program will present user with following output:
```
Found duplicate files: 
0. ${f1}
1. ${f2}
2. ${f3}
… 
 
What do you want to do? (0 = ignore, 1 = delete, 2 = create soft link, 3 = create hard link)
```

### Delete (1) 

Your program output:
```
Do you want to delete ${f}? (y/n)
```

### Create soft link (2)

Keeps only one file and others will be replaced with soft links.

```
File for which to create soft link: (file number)
```

### Create hard link (3)

Keeps only one file and others will be replaced with hard links.

```
File for which to create hard link: (file number)
```

## Test files

### Simple Test

Expected output:
```
Found duplicate files: 
0. test1
1. test2

What do you want to do? (0 = ignore, 1 = delete, 2 = create soft link, 3 = create hard link)
…
```

### Complex Test
Expected output:
```
Found duplicate files: 
0. bin/bin4
1. bin/bin6

What do you want to do? (0 = ignore, 1 = delete, 2 = create soft link, 3 = create hard link)

…

Found duplicate files: 
0. src/main/java/cz/cuni/mff/HelloWord.java
1. test/reources/test_input.txt
2. test/reources/test_input.txt2

What do you want to do? (0 = ignore, 1 = delete, 2 = create soft link, 3 = create hard link)

…
```

---

Good luck :)