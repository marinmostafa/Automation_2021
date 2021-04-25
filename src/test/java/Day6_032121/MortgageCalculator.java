package Day6_032121;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MortgageCalculator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.mortgagecalculator.org");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //verify that the title with your expected
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("mortgage calculator")) {
            System.out.println("Title matches");
        } else {
            System.out.println("Title does not match " + actualTitle);
        }// end of conditional statement


        //you have to name the variable after WebElement
        //store home value first
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        //clear the previous data
        homeValue.clear();
        //enter the new home Value
        homeValue.sendKeys("350000");

        Thread.sleep(2000);

        //store downpayment first
        WebElement dPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        //clear the previous data
        dPayment.clear();
        //enter the new downpayment
        dPayment.sendKeys("234999");

        Thread.sleep(5000);

        //select april on month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //select the locator using Select command
        Select dropdown = new Select(startMonth);
        //using by visible text command select month April
        //has to be the exact text that you see
        dropdown.selectByVisibleText("Apr");

        Thread.sleep(3000);

        //if dropdown is not under select tag then you have to use click command twice
        //click on dropdown
        startMonth.click();
        //click on dropdown value by text
        driver.findElement(By.xpath("//*[text()= 'May']")).click();

        //click on Calculate button
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();

        Thread.sleep(3000);

        //capture the monthly payment using FindElements with first Index
        String mntPayment = driver.findElements(By.xpath("//div[@class= 'left-cell']")).get(0).getText();
        System.out.println("My monthly payment is " + mntPayment);

        Thread.sleep(3000);

        driver.quit();


    }// end of main method
}// end of java class
