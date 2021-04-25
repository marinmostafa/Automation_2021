package Day7_03272021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Handlingtabs {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        //navigate to oxford health home page
        driver.navigate().to("https://www.oxhp.com");
        Thread.sleep(2000);

        //using contains only choose the unique portion of the value
        //to click on members link
        driver.findElement(By.xpath("//*[contains(@onmouseover,'/images/home/members_hm_on')]")).click();
        Thread.sleep(2000);

        //click on find a physician link
        driver.findElement(By.xpath("//*[contains(text(),'Find a Physician')]")).click();

        //using ArrayList we can switch to new tab(1)
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new tab 2
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);


        //click on metro to verify you are on the new tab
        try {
            driver.findElement(By.xpath("//*[text= 'Metro']")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Metro Link. " + e);
        }//end of exception


        //close the new tab
        driver.close();

        //switch back to old tab
        driver.switchTo().window(tabs.get(0));


    }// end of main method
}// end of java class
