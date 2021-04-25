package PageObjectClasses;

import ReUsableLibrary.Abstract_Class;

public class Base_Class extends Abstract_Class {

    //this page class is a static reference fot he page object classes
    //so i can use it on my test class

    public static GoogleHomepage googleHomepage(){
        GoogleHomepage googleHomepage = new GoogleHomepage(driver);
        return googleHomepage;
    }//end of method

    public static SearchResultPageGoogle searchResults(){
        SearchResultPageGoogle searchResults = new SearchResultPageGoogle(driver);
        return searchResults;
    }//end of method

    public static ExpressHomepage Expresshomepage(){
        ExpressHomepage Expresshomepage = new ExpressHomepage(driver);
        return Expresshomepage;
    }//end of method

    public static HoodiesAndSweatshirts Hoodies(){
        HoodiesAndSweatshirts Hoodies = new HoodiesAndSweatshirts(driver);
        return Hoodies;
    }//end of method

    public static HoodieDetails hoodieDetails(){
        HoodieDetails hoodieDetails = new HoodieDetails(driver);
        return hoodieDetails;
    }//end of method

    public static PreCheckOut preCheckOut(){
        PreCheckOut preCheckOut = new PreCheckOut(driver);
        return preCheckOut;
    }//end of method

    public static PaymentPage paymentPage(){
        PaymentPage paymentPage = new PaymentPage(driver);
        return paymentPage;
    }//end of method

}//end of java class
