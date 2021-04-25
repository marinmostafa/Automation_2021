package Day9_04032021;

import org.openqa.selenium.WebDriver;

import java.util.ResourceBundle;

public class test {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = ReusableMethods.defineTheDriver();

        //navigate to google
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2300);
        //enter something on search field
        ReusableMethods.sendKeysMethod(driver, "//*[@name= 'q']", "cars", "Search Field");
        //click on google search
        ReusableMethods.submitonElement(driver, "//*[@name= 'btnK']", "Google Search");


    }// end of main method
}// end of java class
