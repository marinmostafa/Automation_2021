package Day2_030721;

public class forLoopExample {
    public static void main(String[] args) {
        String[] cities;

        cities = new String [4];
        cities[0] = "Brooklyn";
        cities[1] = "Queen";
        cities[2] = "Manhattan";
        cities[3] = "Bronx";

        //set your iteration to loop through all the values from cities
        for (int i = 0;i < cities.length; i++){
        //print out all values in one print statement

            System.out.println("My city is " + cities[i]);

        }//end of for loop
    }//end of main method
}// end of java class
