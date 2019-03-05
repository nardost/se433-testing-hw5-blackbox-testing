# SE 433/333 Software Testing & Quality Assurance
## Assignment 6 Black Box Testing
## Part 2: Test Case Implementation
## Objectives
1. Design test suites using black-box techniques.
2. Implement the test suites using JUnit.
3. Run the test suites using Maven command line.
## Problems
In this assignment, you are given two classes to test. For each class, the
specification is given below, and the compiled Java code is also provided.
Design and implement a test suite using JUnit to adequately test the
designated method in each program. You may use any combination of
black-box testing techniques to design the test cases. Use Maven to run
the entire testing process, which includes compilation and the execution of
each of the test suites.
## Program 1: Shipping Cost Calculator
The program under test is ```edu.depaul.se433.Orders```. The class declares an ```enum``` type ```ShippingMethod``` and a
```public static``` method ```calculateTotal``` with the following signature:
```
public enum ShippingMethod { Standard, NextDay };
public static double calculateTotal(double rawTotal, ShippingMethod shippingMethod, String destinationState)
```
The specification of the method is as follows:
### Input
* ```rawTotal```: the raw total of all items in the order.
* ```shippingMethod```: the shipping method
* ```destinationState```: the state of the shipping address
### Output
* the total shipping cost calculated according to the rules described in Problem 1 of assignment 5 (black box test case design).
### Exception
* If any of the arguments is invalid, an ```IllegalArgumentException``` should be thrown.
## Program 2: Pluralizer
The program under test is a Java class named ```StringUtil``` in package
```edu.depaul.se433```. This class defines a public static method with the following signature:
```public static String pluralize(String word)```
The specification of the method is as follows:
### Input
* word is a single word in English.
### Output
* If the word is a singular noun, it returns the plural form of the noun. Otherwise, it returns the original word.
### Exception
* If the argument contains characters not used in any English word, an ```llegalArgumentException``` should be thrown.
## Binary Code of Program Under Test
The binary code of both programs under test is provided in a jar file named ```week6-test-targets.jar```.
Create a folder named ```lib``` in the root folder of the project and copy the jar to that folder.
Follow the instructions in the presentation to make the required pom file changes to make the jar file usable by your tests.
### You should create a ZIP file by executing:
```mvn clean package -Dmaven.test.failure.ignore=true```
