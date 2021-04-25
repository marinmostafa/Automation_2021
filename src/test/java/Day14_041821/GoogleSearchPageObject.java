package Day14_041821;

import PageObjectClasses.Base_Class;
import ReUsableLibrary.Abstract_Class;
import org.testng.annotations.Test;

public class GoogleSearchPageObject extends Abstract_Class {

    @Test
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        Base_Class.googleHomepage().EnterKeywordOnGoogleSearch("cars");
        Base_Class.googleHomepage().SubmitOnGoogleSearchButton();
        Thread.sleep(3000);
        Base_Class.searchResults().CaptureSearchResultNumber();

    }//end of method


}//end of class
