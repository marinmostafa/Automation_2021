package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonPractice {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id= 'twotabsearchtextbox']")).sendKeys("couple tshirts");
        driver.findElement(By.xpath("//*[@id= 'nav-search-submit-text']")).submit();
        driver.findElement(By.xpath("//*[@class= 'a-size-base-plus a-color-base a-text-normal']")).click();
        driver.findElement(By.xpath("//*[@id= 'add-to-cart-button']")).click();


    }// end of main method
}// end of java class
