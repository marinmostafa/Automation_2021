package practice;

public class whileloopconditional {
    public static void main(String[] args) {
        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Staten Island";
        cities[3] = "Manhattan";

        int i = 0;
        while (i < cities.length) {
            if (cities[i] == "Brooklyn") {
                System.out.println("city is" + cities[i]);
            } else if (cities[i] == "Manhattan") {
                System.out.println("city is" + cities[i]);
            }// end of conditional

            i = i + 1;
        }// end of while loop
    }// end of main method
}// end of java class
