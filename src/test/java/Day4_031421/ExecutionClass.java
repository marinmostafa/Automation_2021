package Day4_031421;

public class ExecutionClass {
    public static void main(String[] args) {
        //this is where you can call your reusable method to be executed
        //inside main method

        ReusableMethods.addTwoNumbers(20, 30);
        ReusableMethods.addTwoNumbers(25, 30);

        //call subtract method and store the result

        int c = ReusableMethods.subtractTwoNumbers(13, 4);
        System.out.println("New result " + (c / 3));

    }// end of main method
}// end of java class
