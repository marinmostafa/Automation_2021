package Day3_031321;

public class loopwithconditionalstatement {
    public static void main(String[] args) {
        String[] countries = new String[4];
        countries[0] = "USA";
        countries[1] = "Canada";
        countries[2] = "Bangladesh";
        countries[3] = "India";

        //using for loop with conditional statements print only when country is USA or Canada
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == "USA") {
                System.out.println("Country is" + countries[i]);

            } else if (countries[i] == "Canada") {
                System.out.println("Country is" + countries[i]);


            }// end of conditional statement
        }// end of for loop

        //using for loop with case statements print only when country is USA or Canada
        for (int i = 0; i < countries.length; i++) {
            switch (countries[i]) {
                case "USA":
                    System.out.println("Country is " + countries[i]);
                    break;
                case "Canada":
                    System.out.println("Country is " + countries[i]);
                    break;

            }// end of case statements
        }// end of for loop


    }// end of main method
}// end of java class
