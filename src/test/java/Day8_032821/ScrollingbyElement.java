package Day8_032821;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class ScrollingbyElement {
    public static void main(String[] args) throws InterruptedException, IOException {

        //kill all chrome instances that are opened
        Runtime.getRuntime().exec("killall -KILL chromedriver");
        Thread.sleep(1000);
        //set the path to the driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        //define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
        //set the driver to incognito(private)
        options.addArguments("incognito");
        //set it to headless
        //options.addArguments("headless");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage site
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //store the locator as a element that I want to scroll by for a view
        WebElement viewLoan = driver.findElement(By.xpath("//*[text()='View Loan Breakdown']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",viewLoan);

    }// end of main method
}// end of java class
