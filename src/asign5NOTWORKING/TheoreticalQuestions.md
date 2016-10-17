## 1. What is the Java Virtual Machine? What is Bytecode?

Bytecode is whats left when javacode is compiled. And Java Virtual Machineis an inbuilt feature that reads the bytecode as instructions and then does what the bytecode demands. THe good thing part with the inbuild Java Virtual Machine is that it enableds many devices to run the code.

## 2. What is the Java Classpath?

A Java Classpath is the path to other classes, librarys and package that you import. This is if you for example want to import the scanner library you write

    import java.util.Scanner;

This means that in the java library ther is a "under" library thats called util that contains the scanner class.

## 3. How do you compile and run your java program without the help of an Integrated Development Environment (IDE) (e.g., an IDE like Eclipse)?

First and formost you have to install the Java jdk on your device. In ubuntu this is done by typing

    sudo apt-get install openjdk-8-jdk

And when the install is completed you need to navigate to your program. Then you need to compile it. This is done by accessing the java console. This you do by typing "javac" in the console. If we stick to the ubuntu example to compile you type

    javac name-of-you-program.java

  And when thats done you run it with

    javac name-of-you-program


## 4. What is a JAR file?

A JAR file is a compresed javaprogram. That can be extracted and run by inbuled features in the JDK. It can also be unpacked by zip Software.

## 5. How do you declare the starting point of a Java application?
The start of the program is the Main() method.

## 6. What is a package? Why is important to declare classes inside packages?

Packages are like folders. If you for example take the home folder of your computer you suposobly have one folder for music, one for documents and one for pictures. And its the same with java classes they need to be seperated in Packages


## 7. What is an interface? Why is it important to not change them?

An interface is like a blurprint for classes with empty method bodies. It's important to not change it couse the classes implementing it may not compile then.

## 8. Which visibility levels are available in Java? What is the default visibility for classes, methods, and fields?

There are 4 visibility levels they are as follows

  - Public - accessible everywhere

  - Protected - accessible in the same package and in the children

  - Default - accessible only in the same package also called Package-private

  - Private - accessible only in the same class.

## 9. In the context of Java, what is an Exception? And what is an Error?

  Error is when the program crashes and stops due to that sometings gone worng often non code related and should not be cought. Exceptions on the other hand are errors due to code and should be cought.


## 10. What happened if your program terminates with an OutOfMemoryError, or NoClassDefFoundErroror
NullPointerException?

- OutOfMemoryError occurs when the garbage collecter can't allocate more memory, so in other words the memory to run the program is al used.

- NoClassDefFoundErroror occurs when a class is not found and the program can't compiled

- NullPointerException occurs when you try to use a reference that points to no location in memory


## 11. How do you handle Exceptions in your program?

Your wrap the code in an try/catch block witch will catch the Exception so the program wont crash witout some sort of error message

## 12. Why is it important to test your code/application/product, before you deliver it to your
customer/boss/teacher?

If you don't test you don't have a clue if the code is working propely and if all requirements are meet

## 13. What is JavaDoc? How do you write documentation with it?

JavaDoc is a documentation tool writen by Sun Microsoft thats now owned by Oracle. It's used to write documentation that can be rendered to HTML just like Markdown that this document is writen in.
