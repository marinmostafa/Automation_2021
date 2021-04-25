package Day12_041121;

import Day9_04032021.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GettingLinkCount_Yahoo {

    @Test
    public void linkCount () throws InterruptedException {

        WebDriver driver = ReusableMethods.defineTheDriver();

        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(2000);

        //store the array list with class attribute for the links
        ArrayList <WebElement> linkCount = new ArrayList(driver.findElements(By.xpath("//*[contains(@class, '_yb_1rwct')]")));

        //print out the count of the links
        System.out.println("Link count is " + linkCount.size());

        //I want to click on each link and navigate back to the page
        for (int i = 0; i<linkCount.size(); i++){
            driver.navigate().to("https://www.yahoo.com");
            Thread.sleep(5000);
            //ArrayList <WebElement> linkCounts = new ArrayList(driver.findElements(By.xpath("//*[contains(@class, '_yb_12gb1')]")));
            //linkCounts.get(i).click();
            linkCount = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, '_yb_1rwct')]")));
            linkCount.get(i).click();
            Thread.sleep(2000);
        }// end of loop
    }//end of test
}// end of java class
