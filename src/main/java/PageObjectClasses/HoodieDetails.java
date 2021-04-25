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

public class HoodieDetails extends Abstract_Class {
    //declare local logger so you can use it in your page class
    ExtentTest logger;
    public HoodieDetails(WebDriver driver){
        //page factory command
        PageFactory.initElements(driver, this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class


    @FindBy(xpath = "//button[text()= 'Add to Bag']")
    WebElement AddToBag;
    @FindBy(xpath = "//*[text()= 'View Bag']")
    WebElement ViewBag;

    public void addSize(String Size){
        WebDriverWait wait = new WebDriverWait(driver,8);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value= '" + Size + "']"))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on size" + Size);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to click on size" + Size + " " + e);
            ReusableActionsPageObject.getScreenShot(driver, "Size", logger);
        }//end of exception
    }//end of method

    public void ClickAddBag(){
        ReusableActionsPageObject.clickonElement(driver, AddToBag, logger, "Click Add to Bag");
    }//end of method

    public void ClickViewBag(){
        ReusableActionsPageObject.clickonElement(driver, ViewBag, logger, "Click View Bag");
    }//end of method


}//end of java class
