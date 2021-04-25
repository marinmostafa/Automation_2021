package Day7_03272021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExceptionExample {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.bing.com");
        Thread.sleep(2000);

        //enter a keyword on search field
        try{
            driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("Cars");
        } catch (Exception e){
            System.out.println("Unable to enter keyword on Search field. " + e);
        }// end of search exception

        //click on search icon
        try{
            driver.findElement(By.xpath("//*[@for = 'sb_form_go']")).click();
        } catch (Exception e){
            System.out.println("Unable to click on search icon. " + e);
        }// end of search icon exception


    }// end of main method
}// end of java class
