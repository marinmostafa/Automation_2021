package Day12_041121;

import Day9_04032021.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Assertions {


    @Test
    public void assertions(){

        WebDriver driver = ReusableMethods.defineTheDriver();

        driver.navigate().to("https://www.google.com");

        //using hard assert verify the google title
        //Assert.assertEquals("Google", driver.getTitle());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Google", driver.getTitle());

        //enter something on google search
        ReusableMethods.sendKeysMethod(driver, "//*[@name= 'q']", "Cars", "Search");


        //assertALL should be the last step on your test
        softAssert.assertAll();

    }// end of method

}// end of java class
