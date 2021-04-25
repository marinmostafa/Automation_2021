package ReUsableLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class ReusableActions {

    //create a reusable method for navigate to a page

    public static WebDriver defineTheDriver() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        return driver;

    }// end of navigate

    //method to click on any webelement by explicit wait

    public static void clickonElement(WebDriver driver, String xpathLocator, ExtentTest logger, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch exception to locate an element and click on it
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
            System.out.println("Unable to click on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
        } // end of exception
    }// end of click method

    public static void closePopupExist(WebDriver driver, String xpathLocator, ExtentTest logger, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch exception to locate an element and click on it
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
            logger.log(LogStatus.PASS,"Successfully closedpopup " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
            System.out.println("Popup " + elementName + " is not present. Move on to the next step.");
            getScreenShot(driver, elementName, logger);
        } // end of exception
    }// end of click method

    public static void submitonElement(WebDriver driver, String xpathLocator, ExtentTest logger, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch exception to locate an element and submit
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).submit();
            logger.log(LogStatus.PASS,"Successfully submit on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
            System.out.println("Unable to submit on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
        } // end of exception
    }// end of submit method

    public static void sendKeysMethod(WebDriver driver, String xpathLocator, String userValue, ExtentTest logger, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch exception to locate an element and click on it
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully entered a value on " + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to enter value on element " + elementName + " " + e);
            System.out.println("Unable to enter a value on element " + elementName + " " + e);
            getScreenShot(driver, elementName, logger);
        } // end of exception
    }// end of click method

    public static void Sendkeys(WebDriver driver, String xpathlocator, String userValue, String elementname) {
        WebElement elemnt2 = driver.findElement(By.xpath(xpathlocator));
        elemnt2.click();
        elemnt2.sendKeys();
    }// end of method


    public static void dropdownbyText(WebDriver driver, String xpath, String userValue, String elementname) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
        } catch (Exception e) {
            System.out.println("Unable to select a value from" + elementname + " " + e);

        }// end of exception
    }//end of method

    public static String CaptureText(WebDriver driver, String xpath, int index, ExtentTest logger, String elementname) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully captured a text on " + elementname);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to capture a text " + elementname + " " + e);
            System.out.println("Unable to capture text" + elementname + " " + e);
            getScreenShot(driver, elementname, logger);
        }// end of exception

        return result;

    }//end of method

    public static void Mousehover(WebDriver driver, String xpath, ExtentTest logger, String elementname) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully hover to " + elementname);
        } catch (Exception e) {
            System.out.println("Unable to hover over element" + elementname + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hover to an element " + elementname + " " + e);
            getScreenShot(driver, elementname, logger);
        }// end of exception
    }//end of method

    public static void MouseHoverClick(WebDriver driver, String xpath, String elementname) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to hover and click over element" + elementname + " " + e);
        }// end of exception
    }//end of method

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger){
        try {
            String fileName = imageName + ".png";
            String directory =  null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }//end of exception

    }//end of method

}// end of java class
