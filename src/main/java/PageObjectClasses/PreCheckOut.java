package PageObjectClasses;

import ReUsableLibrary.Abstract_Class;
import ReUsableLibrary.ReusableActionsPageObject;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreCheckOut extends Abstract_Class {

    //declare local logger so you can use it in your page class
    ExtentTest logger;
    public PreCheckOut(WebDriver driver){
        //page factory command
        PageFactory.initElements(driver, this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class

    @FindBy(xpath = "//select[@id= 'qdd-0-quantity']")
    WebElement QuantityBox;

    @FindBy(xpath = "//*[@id= 'continue-to-checkout']")
    WebElement CheckoutBox;

    @FindBy(xpath = "//*[text()= 'Checkout as Guest']")
    WebElement CheckoutGuest;

    public void ClickQuantityBox(){
        ReusableActionsPageObject.clickonElement(driver,QuantityBox,logger,"Click on Quantity Box");
    }//end of method

    public void ClickQuantityNumber(String Quantity){
        WebDriverWait wait = new WebDriverWait(driver,8);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value= '" + Quantity + "']"))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on size" + Quantity);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to click on size" + Quantity + " " + e);
            ReusableActionsPageObject.getScreenShot(driver, "Size", logger);
        }//end of exception
    }//end of method

    public void ClickCheckout(){
        ReusableActionsPageObject.clickonElement(driver, CheckoutBox, logger, "Click Checkout");
    }//end of method

    public void CheckoutAsGuest(){
        ReusableActionsPageObject.clickonElement(driver, CheckoutGuest, logger, "Click on Guest Checkout");
    }//end of method

}//end of java class
