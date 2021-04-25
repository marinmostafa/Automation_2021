package Day9_04032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

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

    public static void clickonElement(WebDriver driver, String xpathLocator, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch exception to locate an element and click on it
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        } // end of exception
    }// end of click method

    public static void closePopupExist(WebDriver driver, String xpathLocator, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch exception to locate an element and click on it
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
        } catch (Exception e) {
            System.out.println("Popup " + elementName + " is not present. Move on to the next step.");
        } // end of exception
    }// end of click method

    public static void submitonElement(WebDriver driver, String xpathLocator, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch exception to locate an element and submit
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        } // end of exception
    }// end of submit method

    public static void sendKeysMethod(WebDriver driver, String xpathLocator, String userValue, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch exception to locate an element and click on it
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + " " + e);
        } // end of exception
    }// end of click method

    public static void Sendkeys(WebDriver driver, String xpathlocator, String userValue, String elementNamee) {
        WebElement elemnt2 = driver.findElement(By.xpath(xpathlocator));
        elemnt2.click();
        elemnt2.sendKeys();
    }


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

    public static String CaptureText(WebDriver driver, String xpath, int index, String elementname) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text" + elementname + " " + e);
        }// end of exception

        return result;

    }//end of method

    public static void Mousehover(WebDriver driver, String xpath, String elementname) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover over element" + elementname + " " + e);
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

}// end of java class
