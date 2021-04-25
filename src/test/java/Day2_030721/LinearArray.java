package Day2_030721;

public class LinearArray {
    public static void main(String[] args) {
        //declare the variables
        String[] cities, countries;
        int[] streetNumber, houseNumber;


        cities = new String[]{"Brooklyn", "Queens", "Manhattan", "Staten Island", "Bronx"};
        countries = new String[]{"United States", "Canada", "Mexico"};
        streetNumber = new int[]{222, 345, 567, 888, 1000};
        houseNumber = new int[]{2222, 4, 4, 4, 4};

        //I want to print queens and street number is 222;
        System.out.println("My city is " + cities[1] + " and street number is " + streetNumber[0] + " and house number is " + houseNumber[2] + " and my country is " + countries[2]);

        System.out.println("My country is " + countries[1] + " not stupid ass " + countries[0]);
        System.out.println("i hate " + cities[0] + "." + " kalla be fuckin up the house on " + streetNumber[2] + " street");


    }// end of main method

}// end of java class
