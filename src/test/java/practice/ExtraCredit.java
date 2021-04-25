package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.ArrayList;

public class ExtraCredit {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> ZipCode = new ArrayList<>();
        ZipCode.add("11210");
        ZipCode.add("11229");
        ZipCode.add("11230");

        ArrayList<Integer> MilesRange = new ArrayList<>();
        MilesRange.add(10);
        MilesRange.add(15);
        MilesRange.add(20);

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        for (int i = 0; i<3; i++){

            try {
                driver.navigate().to("https://www.aetna.com");
            } catch (Exception e){
                System.out.println("Unable to navigate to website. " + e);
            } // end of navigation exception

            driver.manage().window().maximize();
            Thread.sleep(2000);

            String ActualTitle = driver.getTitle();
            if (ActualTitle.equals("Health Insurance Plans | Aetna")){
                System.out.println("Title Matches");
            } else {
                System.out.println("Title does not match" + ActualTitle);
            }// end of for loop

            try {
                WebElement Shop= driver.findElement(By.xpath("//*[text()= 'Shop for a plan']"));
                Shop.click();
            } catch (Exception e){
                System.out.println("Unable to click on shop. " + e);
            } // end of click shop exception

            Actions actions = new Actions(driver);

            try {
                WebElement Medicare = driver.findElement(By.xpath("//*[text()= 'Medicare']"));
                actions.moveToElement(Medicare).perform();
            } catch (Exception e){
                System.out.println("Unable to hover on medicare. " + e);
            } // end of hover medicare exception

            try {
                WebElement FindADoc = driver.findElement(By.xpath("//*[contains(@href, 'page=providerSearchLanding')]"));
               FindADoc.click();
                Thread.sleep(3000);
            } catch (Exception e){
                System.out.println("Unable to click on find a doctor. " + e);
            } // end of click find a doctor exception


            try {
                WebElement Plans = driver.findElement(By.xpath("//*[@class= 'primaryPurple BtnWidth mgbutton w400']"));
                Plans.click();
            } catch (Exception e){
                System.out.println("Unable to click on 2021 plans. " + e);
            } // end of click 2021 plans exception

            try {
                WebElement Zipcode = driver.findElement(By.xpath("//*[@id= 'medZip']"));
                Zipcode.sendKeys(ZipCode.get(i));
            } catch (Exception e){
                System.out.println("Unable to enter zipcode. " + e);
            } // end of entering zip code exception

        Thread.sleep(4000);

            try {
                WebElement ZCLink = driver.findElement(By.xpath("//*[@class= 'typeahead_grouping active']"));
                Thread.sleep(3000);
                ZCLink.click();
            } catch (Exception e){
                System.out.println("Unable to click on zip code link. " + e);
            } // end of click zip code link exception

            try {
                WebElement Slider = driver.findElement(By.xpath("//*[@role= 'slider']"));
       Slider.sendKeys(Keys.ARROW_RIGHT);

            } catch (Exception e){
                System.out.println("Unable to click on slider. " + e);
            } // end of click slider exception



        }// end of for loop
    }// end of main method
}// end of java class
