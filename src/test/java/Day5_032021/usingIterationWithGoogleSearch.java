package Day5_032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class usingIterationWithGoogleSearch {
    public static void main(String[] args) throws InterruptedException {

        /**iterate through multiple cities on google search and print out the number each time **/

        //declare and define the array list
        String[] cities = new String[3];
        cities [0]= "Brooklyn";
        cities[1]= "Queens";
        cities[2]= "Bronx";

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

       //your actual use case from start to end should go inside for/while loop for multiple iterations
        for (int i=0; i< cities.length; i++) {

            driver.navigate().to("https://www.google.com");
            driver.manage().window().maximize();

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);

            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            Thread.sleep(1000);

            String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

            String[] arrayResults = searchResult.split(" ");

            System.out.println("The city " + cities[i] + " search number is " + arrayResults[1]);

        }// end of for loop

        //quit the driver
        driver.quit();


    }//end of main method
}//end of java class
