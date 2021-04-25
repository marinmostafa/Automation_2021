package Day6_032121;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample {
    public static void main(String[] args) throws InterruptedException {
        //set the path to the driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //define the chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver (does not work with mac)
        //options.addArguments("start-maximized");
        //set the driver to incognito
        options.addArguments("incognito");
        //set it to headless
        //options.addArguments("headless");

        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo page
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(1000);
        driver.manage().window().maximize();


    }//end of main method
}//end of java class
