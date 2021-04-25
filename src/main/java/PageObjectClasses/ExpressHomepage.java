package PageObjectClasses;

import ReUsableLibrary.Abstract_Class;
import ReUsableLibrary.ReusableActionsPageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpressHomepage extends Abstract_Class {
    //declare local logger so you can use it in your page class
    ExtentTest logger;
    public ExpressHomepage(WebDriver driver){
        //page factory command
        PageFactory.initElements(driver, this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class

    //define all the WebElements you need using @FindBY concept
    @FindBy(xpath = "//*[@class= '_3tHVp']")
    WebElement HomePagePopup;
    @FindBy(xpath = "//*[@href= '/mens-clothing']")
    WebElement MensTab;
    @FindBy(xpath = "//a[text()= 'Sweatshirts & Hoodies']")
    WebElement SweatersAndHoodies;

    public void ClickPopUp(){
        ReusableActionsPageObject.clickonElement(driver, HomePagePopup, logger, "Click on Popup");
    }//end of method

    public void HoverMensTab(){
        ReusableActionsPageObject.Mousehover(driver,MensTab,logger, "Hover over Mens Tab");
    }//end of method

    public void ClickSweaters(){
        ReusableActionsPageObject.clickonElement(driver, SweatersAndHoodies, logger, "Click on Sweaters");
    }//end of method

}//end of java class
