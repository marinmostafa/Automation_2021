package Day4_031421;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchResults {
    public static void main(String[] args) {

        //set the System property of where the driver is located so you can use it
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");


        //define the WebDriver with a variable to use
        WebDriver driver = new ChromeDriver();


        //navigate/get to google home page
        driver.navigate().to("https://www.google.com");

        //to maximize the browser we use a command called driver.manage().window().maximize();
        //to locate an element: driver.findElement(By.xpath......
        // .sendKeys()- to type something a field
        // .click()- to click on a element
        /*.submit()- sometimes click does not work when there is a pop up and it is blocking the
        element to click on so you can use submit which is like hitting Enter key on your keyboard
         */




    }// end of main method
}// end of java class
