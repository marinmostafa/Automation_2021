package Day3_031321;

public class multipleCondition {
    public static void main(String[] args) {

        //using multiple conditional statements
        int a, b, c;
        a = 2;
        b = 3;
        c = 4;

        //verify either a+b >c, a+b < c, a+b = c
        //your last statement, you have to end with else, instead of else if
        // if previous two conditions didn't match then you can just end with else statement

        if (a+b >c){
            System.out.println("a & b is greater than c");
        } else if(a+b < c) {
            System.out.println("a & b is less than c");
        } else {
            System.out.println("a & b is equal to c");

        }//end of multiple condition
    }// end of main method
}// end of java class
