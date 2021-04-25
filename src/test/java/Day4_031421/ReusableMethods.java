package Day4_031421;

public class ReusableMethods {

    //create a reusable method which will add two numbers and print out the statement
    //you have to create another parenthesis inside to add two numbers
    //static means you can share the method
    //public means modifier, it is always the beginning
    //void means it only executes without returning

    public static void addTwoNumbers(int number1,int number2){
        System.out.println("My result is " + (number1+number2));
    }// end of method

    //create a return method which will subtract two numbers and print as well
    //return the result
    //after static, you have to write int or string (what kind of value u want) instead of void


    public static int subtractTwoNumbers(int number1,int number2){
        int result = number1 - number2;
        System.out.println("My result is " + (number1-number2));
    return result;

    }//end of method2
}// end of java class
