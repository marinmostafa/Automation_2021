package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.text.Format;

public class actionitem3 {
    public static void main(String[] args) throws InterruptedException {

        String[] PPrice = new String[]{"300000", "400000", "500000"};
        String[] Dpayment = new String[]{"15", "10", "20"};
        String[] MTerm = new String[]{"25", "30", "35"};
        String[] IRate = new String[]{"4", "3", "5"};
        String[] PMI = new String[]{"1", "2", "3"};
        String[] StartMonth = new String[]{"Jan", "Feb", "Apr"};
        String[] StartYear = new String[]{"2024", "2022", "2023"};

        //instead of using driver.quit, kill all instances:


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);



        for (int i = 0; i < 3; i++) {
            driver.navigate().to("https://www.mlcalc.com");
            driver.manage().window().maximize();
            Thread.sleep(1000);

            WebElement PurchasePrice = driver.findElement(By.xpath("//*[@value='312,500']"));
            PurchasePrice.clear();
            PurchasePrice.sendKeys(PPrice[i]);

            WebElement Downpayment = driver.findElement(By.xpath("//*[@value='20']"));
            Downpayment.clear();
            Downpayment.sendKeys(Dpayment[i]);

            WebElement MortgageTerm = driver.findElement(By.xpath("//*[@value='30']"));
            MortgageTerm.clear();
            MortgageTerm.sendKeys(MTerm[i]);

            WebElement InterestRate = driver.findElement(By.xpath("//*[@value='4.5']"));
            InterestRate.clear();
            InterestRate.sendKeys(IRate[i]);

            WebElement Pmi = driver.findElement(By.xpath("//*[@value='0.52']"));
            Pmi.clear();
            Pmi.sendKeys(PMI[i]);

            WebElement startmonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select dropdown = new Select(startmonth);
            dropdown.selectByVisibleText(StartMonth[i]);

            WebElement startyear = driver.findElement(By.xpath("//*[@name='sy']"));
            startyear.click();
            driver.findElement(By.xpath("//*[text()= '" + StartYear[i] + "']")).click();

            driver.findElement(By.xpath("//*[@value='Calculate']")).click();

            Thread.sleep(2000);

            String mntPayment = driver.findElements(By.xpath("//td[@class= 'big']")).get(0).getText();
            System.out.println("My monthly payment is " + mntPayment);

        }// end of for loop


        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Auto Loan Calculator")) {
            System.out.println("Title matches");
        } else {
            System.out.println("Title does not match " + actualTitle);
        }// end of conditional statement


    }//end of main method
}// end of java class
