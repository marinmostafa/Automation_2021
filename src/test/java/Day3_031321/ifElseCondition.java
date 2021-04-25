package Day3_031321;

public class ifElseCondition {
    public static void main(String[] args) {
        //declare the integer variables
        int a,b;
        a = 4;
        b = 3;

        //using if condition, verify that a is less than b
        //it will not print anything if a is not less than b
        if ( a < b){
            System.out.println("a is less than b");

        }// end of if condition

        //using if else condition, verify if a is less than b, else it is greater or equal to b
        if ( a < b) {
            System.out.println("a is less than b");
        } else {
            System.out.println("a is either greater than b or equal to b");

        }// end of if else condition

        //using <= operator verify if a is less than b or is equal to b
        //you can change less than to greater than according to the variables
        if ( a <= b) {
            System.out.println("a is less than b or a is equal to b");



        }// end of if else
    }// end of main method
}// end of java class

