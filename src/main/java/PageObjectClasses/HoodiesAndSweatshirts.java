package PageObjectClasses;

import ReUsableLibrary.Abstract_Class;
import ReUsableLibrary.ReusableActionsPageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoodiesAndSweatshirts extends Abstract_Class {

        //declare local logger so you can use it in your page class
        ExtentTest logger;
        public HoodiesAndSweatshirts(WebDriver driver){
            //page factory command
            PageFactory.initElements(driver, this);
            this.logger = Abstract_Class.logger;
        }//end of constructor class

    @FindBy(xpath = "//a[@class= '_2EWqA']")
    WebElement FirstHoodiePic;

        public void ClickFirstHoodie(){
            ReusableActionsPageObject.clickonElement(driver, FirstHoodiePic, logger, "Click on First Hoodie");
        }//end of method

}//end of java class
