package Day8_032821;

import com.sun.source.tree.TryTree;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class YahooWithScrolling {
    public static void main(String[] args) throws InterruptedException, IOException {

        //kill all instances
        Runtime.getRuntime().exec("killall -KILL chromedriver");

        Thread.sleep(2000);

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.yahoo.com");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        //enter a keyword
        driver.findElement(By.xpath("//*[@name= 'p']")).sendKeys("cars");

        //click on search icon
        driver.findElement(By.xpath("//*[@id= 'ybar-search']")).click();
        Thread.sleep(2000);

        //set command for scrolling
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //scroll to the bottom by pixels

            jse.executeScript("scroll(0,5000)");


        //capture text
        /* first you split with the word next, so everything on the left side of "next" becomes arrayResult[0]
        and everything on the right side of "next" becomes arrayResult [1]. */

        /* then you have to split what is on the right side, which is arrayResult[1], and split it by "results"
        everything on the left will be arrayNumber[0], which is what we want. */

        String result = driver.findElement(By.xpath("//div[@class= 'compPagination']")).getText();
        //split by keyword Next to capture the actual result
        String[] arrayResult = result.split("Next");
        //split by the keyword results to get the actual number
        String[] arrayNumber = arrayResult[1].split("results");
        System.out.println("My search number is" + arrayNumber[0]);

        Thread.sleep(2000);

        //go all the way to the top and click on sign in
        jse.executeScript("scroll(0,-5000)");
        driver.findElement(By.xpath("//*[@id= 'ysignin']")).click();

    }// end of main method
}// end of java class
