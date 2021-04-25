package PageObjectClasses;

import ReUsableLibrary.Abstract_Class;
import ReUsableLibrary.ReusableActionsPageObject;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPageGoogle extends Abstract_Class {
    //constructor is a method which uses the same name as java class
    //to store information that you want to use locally to this class
    //especially dealing with page object

    //declare local logger so you can use it in your page class
    ExtentTest logger;
    public SearchResultPageGoogle(WebDriver driver){
        //page factory command
        PageFactory.initElements(driver, this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class

    //define all the WebElements you need using @FindBY concept
    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement SearchResultsData;

    //create method for capturing results
    public void CaptureSearchResultNumber(){
        String result= ReusableActionsPageObject.CaptureText(driver, SearchResultsData, 0, logger,"SearchResultsData");
        String[] arrayresult = result.split(" ");
        System.out.println(arrayresult[1]);
        logger.log(LogStatus.INFO,"My search number is " + arrayresult[1]);


    }//end of method






}// end of class
