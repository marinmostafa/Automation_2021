package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mtbank {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www3.mtb.com");
        driver.manage().window().maximize();

        Thread.sleep(2000);

driver.findElement(By.xpath("//*[@class= 'icon-hamburger-menu']")).click();
 Thread.sleep(3000);

 driver.findElements(By.xpath("//a[@class= 'navigation-link parent-title']")).get(1).click();

 Thread.sleep(2000);

driver.quit();
    }
}
