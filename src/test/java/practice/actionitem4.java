package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.text.Format;
import java.util.ArrayList;

public class actionitem4 {
    public static void main(String[] args) throws InterruptedException {

        String[] FindLZip = new String[]{"11210", "11229", "11230"};
        String[] LType = new String[]{"Post Office", "Collection Boxes", "gopost"};
        String[] LMiles = new String[]{"1 Mile", "25 Miles", "50 Miles"};

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        for (int i =0; i<FindLZip.length; i++) {

            try {
                driver.navigate().to("https://www.usps.com");
            } catch (Exception e) {
                System.out.println("Unable to navigate to website. " + e);
            }// end of navigation exception

            driver.manage().window().maximize();

            String ActualTitle = driver.getTitle();
            if (ActualTitle.equals("Welcome | USPS")) {
                System.out.println("title matches");
            } else {
                System.out.println("title does not match " + ActualTitle);
            }// end of conditional statement

            Actions actions = new Actions(driver);

            try {
                WebElement Send = driver.findElement(By.xpath("//*[@id= 'mail-ship-width']"));
                actions.moveToElement(Send).perform();
            } catch (Exception e) {
                System.out.println("Unable to hover to send tab." + e);
            }// end of hover send tab exception

            try {
                WebElement USPSLoc = driver.findElement(By.xpath("//*[contains(@href, 'find-location.htm')]"));
                actions.moveToElement(USPSLoc).click().perform();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click on USPS Locations." + e);
            }// end of clicking find locations exception


            try {
                WebElement ZipCode = driver.findElement(By.xpath("//*[@id= 'city-state-input']"));
                actions.moveToElement(ZipCode).click().sendKeys(FindLZip[i]).perform();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click and enter zip code." + e);
            }// end of clicking and entering zip code exception

            try {
                WebElement LTypes = driver.findElement(By.xpath("//*[@id= 'post-offices-select']"));
                LTypes.click();
            } catch (Exception e) {
                System.out.println("Unable to click location type." + e);
            }// end of clicking location type box

            try {
                driver.findElement(By.xpath("//*[text()= '" + LType[i] + "']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click type from dropdown." + e);
            }// end of clicking location type from drop down

            try {
                WebElement Miles = driver.findElement(By.xpath("//*[@id= 'within-select']"));
                Miles.click();
            } catch (Exception e) {
                System.out.println("Unable to click miles box." + e);
            }// end of clicking miles box

            try {
                driver.findElement(By.xpath("//*[text()= '" + LMiles[i] + "']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to click type from dropdown." + e);
            }// end of clicking location type from drop down

            try {
                WebElement Search = driver.findElement(By.xpath("//*[@id= 'searchLocations']"));
                Search.click();
            } catch (Exception e) {
                System.out.println("Unable to click search." + e);
            }// end of clicking search

            Thread.sleep(2000);

            try {
                ArrayList <WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//div[@class= 'list-item-location popover-trigger']")));
                if (i == 0){
                    links.get(0).click();
                    Thread.sleep(2000);
                } else if (i == 1){
                    links.get(1).click();
                    Thread.sleep(2000);
                } else if (i == 2){
                    links.get(2).click();
                    Thread.sleep(2000);

                }//end of if else condition
            } catch (Exception e){
                System.out.println("Unable to click on links." + e);
            }// end of clicking links exception

            try {
                String address = driver.findElement(By.xpath("//div[@class= ' address-wrapper']")).getText();
                System.out.println("The address is" + address);
            } catch (Exception e) {
                System.out.println("unable to capture address. " + e);
            }// end of address exception

            try {
                String hours = driver.findElement(By.xpath("//div[@id= 'commonServices']")).getText();
                System.out.println("The hours are" + hours);
            } catch (Exception e) {
                System.out.println("unable to capture hours. " + e);
                }// end of hour exception




        }// end of for loop

        driver.quit();

    }// end of main method
}// end of java class
