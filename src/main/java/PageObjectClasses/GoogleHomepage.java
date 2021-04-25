package PageObjectClasses;

import ReUsableLibrary.Abstract_Class;
import ReUsableLibrary.ReusableActionsPageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleHomepage extends Abstract_Class {
    //constructor is a method which uses the same name as java class
    //to store information that you want to use locally to this class
    //especially dealing with page object

    //declare local logger so you can use it in your page class
    ExtentTest logger;
    public GoogleHomepage(WebDriver driver){
        //page factory command
        PageFactory.initElements(driver, this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class

    //define all the WebElements you need using @FindBY concept
    @FindBy(xpath = "//*[@name= 'q']")
    WebElement googleSearch;
    @FindBy(xpath = "//*[@name= 'btnK']")
    WebElement googleSearchButton;
    //below find by is used useful whe  you need to click on an element which does not have a unique property
    //so you create webelement as a list then later you pass .get(index number) on your reusable actions
    @FindBy(xpath = "//*[@class= 'btnK']")
    List<WebElement> list;

    //create a method for google search
    public void EnterKeywordOnGoogleSearch(String userValue){
        ReusableActionsPageObject.sendKeysMethod(driver, googleSearch, userValue, logger, "Google Search");
    }//end of method

    //create a method for google search button
    public void SubmitOnGoogleSearchButton(){
        ReusableActionsPageObject.submitonElement(driver, googleSearchButton, logger, "Google Search Button");
    }//end of method



}// end of class
