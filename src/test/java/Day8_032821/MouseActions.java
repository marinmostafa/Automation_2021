package Day8_032821;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException, IOException {

        //kill all instances
        Runtime.getRuntime().exec("killall -KILL chromedriver");

        Thread.sleep(2000);

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.navigate().to("https://www.usps.com");
        } catch (Exception e) {
            System.out.println("Unable to navigate to usps." + e);
        }//end of exception
        driver.manage().window().maximize();

        Thread.sleep(2000);


        //define the mouse actions
        Actions actions = new Actions(driver);

        //hover to Quick tools tab
        try {
            //store your element as WebElement
            WebElement quickTools = driver.findElement(By.xpath("//*[text()= 'Quick Tools']"));
            //move your mouse actions to quick tools from dropdown to appear
            //you always end your mouse actions with .perform()
                    actions.moveToElement(quickTools).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to Quick Tools." + e);
        }//end of quick tools exception

        Thread.sleep(2000);

        //click on track a package using mouse actions
        try {
            //store your element as WebElement
            WebElement Trackpackage = driver.findElement(By.xpath("//*[text()= 'Track a Package']"));
            actions.moveToElement(Trackpackage).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to click on track a package." + e);
        }//end of tracking a package exception

        Thread.sleep(2000);

        //enter a tracking number using mouse actions
        try {
            //store your element as WebElement
            WebElement Trackpackage = driver.findElement(By.xpath("//*[@id= 'tracking-input']"));
            actions.moveToElement(Trackpackage).click().sendKeys("12345").perform();
        } catch (Exception e) {
            System.out.println("Unable to enter value on tracking input field." + e);
        }//end of entering number exception





    }// end of main method

}// end of java class
