package Day11_041021;

import Day9_04032021.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class GoogleSearchTestNG {
    /** capture search result for google*/
    //declare the global variable outside of annotation method
    //you have to initialize global variables with some null/empty values
    WebDriver driver = null;

    //use before suite when you have multiple @test methods
    @BeforeSuite
    public void setupDriver(){

        driver = ReusableMethods.defineTheDriver();

    }//end of driver set up

    //navigate to google, enter keyword and hit submit
    @Test(priority = 1)
    public void googleSearch() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2500);
        //enter a keyword
        ReusableMethods.sendKeysMethod(driver, "//*[@name= 'q']", "cars", "Google Search");
        //submit on google search button
        ReusableMethods.submitonElement(driver, "//*[@name= 'btnK']", "Google Search Button");
        Thread.sleep(3000);
    }// end of google search

    //capture the search number from search result page
    @Test(priority = 2)
    public void CaptureSearchNumber(){
      String result = ReusableMethods.CaptureText(driver, "//*[@id= 'result-stats']", 0, "Search Results");
      String[] arrayResult = result.split(" ");
      System.out.println("Search number is " + arrayResult[1]);
    }// end of google search

    //quit my driver
    @AfterSuite
    public void closeBrowser(){

        driver.quit();

    }// end of close browser


}// end of java class

