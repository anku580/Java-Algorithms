# This file is all about the interview question asked in java.
Keep on adding the interview questions.


### Q1 - Explain public static void main(String args[]) in Java.
A1- 
> main() in Java is the entry point for any Java program. It is always written as public static void main(String[] args).
  * public: Public is an access modifier, which is used to specify who can access this method. Public means that this Method will be accessible by any Class.
  * static: It is a keyword in java which identifies it is class-based. main() is made static in Java so that it can be accessed without creating the instance of a Class. In case, main is not made static then the compiler will throw an error as main() is called by the JVM before any objects are made and only static methods can be directly invoked via the class. 
  * void: It is the return type of the method. Void defines the method which will not returnss any value.
  * main: It is the name of the method which is searched by JVM as a starting point for an application with a particular signature only. It is the method where the main execution occurs.
  * String args[]: It is the parameter passed to the main method.
  
  ### Q2 - Is java Pass by value or Pass by reference?
A2- 
> Java is strictly Pass by Value. This can be best explained by a swap() function in java.
```java
public static void swap(int n1, int n2)
{
    int temp=n1;
    n1=n2;
    n2=temp;
}

public static void main(String[] args)
{
    int a = 10;
    int b = 20;
    swap(a,b);
    System.out.print(a,b);
    
    //output will be 10 20
}
```
