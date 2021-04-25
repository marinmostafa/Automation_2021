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

public class PaymentPage extends Abstract_Class {
    //declare local logger so you can use it in your page class
    ExtentTest logger;

    public PaymentPage(WebDriver driver) {
        //page factory command
        PageFactory.initElements(driver, this);
        this.logger = Abstract_Class.logger;
    }//end of constructor class

    @FindBy(xpath = "//*[@name= 'firstname']")
    WebElement FirstName;

    @FindBy(xpath = "//*[@name= 'lastname']")
    WebElement LastName;

    @FindBy(xpath = "//*[@name= 'email']")
    WebElement Email;

    @FindBy(xpath = "//*[@name= 'confirmEmail']")
    WebElement ConfirmEmail;

    @FindBy(xpath = "//*[@name= 'phone']")
    WebElement Phone;

    @FindBy(xpath = "//*[@type= 'submit']")
    WebElement Continue;

    @FindBy(xpath = "//*[@name= 'shipping.firstName']")
    WebElement ShippingFirstName;

    @FindBy(xpath = "//*[@name= 'shipping.lastName']")
    WebElement ShippingLastName;

    @FindBy(xpath = "//*[@name= 'shipping.line1']")
    WebElement Address;

    @FindBy(xpath = "//*[@name= 'shipping.postalCode']")
    WebElement ZipCode;

    @FindBy(xpath = "//*[@name= 'shipping.city']")
    WebElement City;

    @FindBy(xpath = "//*[@name= 'shipping.state']")
    WebElement ClickState;

    @FindBy(xpath = "//*[@type= 'submit']")
    WebElement Continue1;

    @FindBy(xpath = "//span[text()= 'Continue']")
    WebElement Continue2;

    @FindBy(xpath = "//*[@name= 'creditCardNumber']")
    WebElement CCNumber;

    @FindBy(xpath = "//*[@name= 'expMonth']")
    WebElement ExpMonth;

    @FindBy(xpath = "//*[@name= 'expYear']")
    WebElement ExpYear;

    @FindBy(xpath = "//*[@name= 'cvv']")
    WebElement Cvv;

    @FindBy(xpath = "//*[@type= 'submit']")
    WebElement Purchase;

    @FindBy(xpath = "//div[@class= '_13uVj jwBXt']")
    WebElement ErrorMessage;


    public void clickfirstname() {
        ReusableActionsPageObject.clickonElement(driver, FirstName, logger, "Click on First Name");
    }// end of method

    public void enterfirstname(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, FirstName, userValue, logger, "Enter First Name");
    }// end of method

    public void clicklastname() {
        ReusableActionsPageObject.clickonElement(driver, LastName, logger, "Click on Last Name");
    }// end of method

    public void enterlastname(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, LastName, userValue, logger, "Enter Last Name");
    }// end of method

    public void clickemail() {
        ReusableActionsPageObject.clickonElement(driver, Email, logger, "Click on email");
    }// end of method

    public void enteremail(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, Email, userValue, logger, "Enter email");
    }// end of method

    public void clickconemail() {
        ReusableActionsPageObject.clickonElement(driver, ConfirmEmail, logger, "Click on confirm email");
    }// end of method

    public void enterconemail(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, ConfirmEmail, userValue, logger, "enter email again");
    }// end of method

    public void clickphone() {
        ReusableActionsPageObject.clickonElement(driver, Phone, logger, "Click on phone");
    }// end of method

    public void enterphone(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, Phone, userValue, logger, "enter phone");
    }// end of method

    public void ClickCont(){
        ReusableActionsPageObject.clickonElement(driver, Continue, logger, "Click first continue");
    }//end of method

    public void clickFName() {
        ReusableActionsPageObject.clickonElement(driver, ShippingFirstName, logger, "Click on Shipping First Name");
    }// end of method

    public void enterFName(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, ShippingFirstName, userValue, logger, "Enter shipping First Name");
    }// end of method

    public void clickLName() {
        ReusableActionsPageObject.clickonElement(driver, ShippingLastName, logger, "Click on Shipping Last Name");
    }// end of method

    public void enterLName(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, ShippingLastName, userValue, logger, "Enter Shipping Last Name");
    }// end of method

    public void clickAddress() {
        ReusableActionsPageObject.clickonElement(driver, Address, logger, "Click on Address");
    }// end of method

    public void enterAddress(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, Address, userValue, logger, "Enter Address");
    }// end of method

    public void clickZipCode() {
        ReusableActionsPageObject.clickonElement(driver, ZipCode, logger, "Click on ZipCode");
    }// end of method

    public void enterZipCode(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, ZipCode, userValue, logger, "Enter ZipCode");
    }// end of method

    public void clickCity() {
        ReusableActionsPageObject.clickonElement(driver, City, logger, "Click on City");
    }// end of method

    public void enterCity(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, City, userValue, logger, "Enter City");
    }// end of method

    public void ClickState(){
            ReusableActionsPageObject.clickonElement(driver, ClickState, logger, "Click on StateBox");
    }//end of method

    public void SelectState(String State){
        WebDriverWait wait = new WebDriverWait(driver,8);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value= '" + State + "']"))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on state" + State);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to click on state" + State + " " + e);
            ReusableActionsPageObject.getScreenShot(driver, "state", logger);
        }//end of exception
    }//end of method

    public void Click2Continue(){
            ReusableActionsPageObject.clickonElement(driver, Continue1, logger, "Click on 2nd Continue");
    }// end of method

    public void Click3Continue(){
            ReusableActionsPageObject.clickonElement(driver, Continue2, logger, "Click on 3rd Continue");
    }//end of method

    public void clickCCNumber() {
        ReusableActionsPageObject.clickonElement(driver, CCNumber, logger, "Click on CCNumber");
    }// end of method

    public void enterCCNumber(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, CCNumber, userValue, logger, "Enter CCNUmber");
    }// end of method

    public void ClickExpMonthBox(){
            ReusableActionsPageObject.clickonElement(driver, ExpMonth, logger, "Click on Exp Month Box");
    }//end of method

    public void SelectExpMonth(String ExpMonth){
        WebDriverWait wait = new WebDriverWait(driver,8);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value= '" + ExpMonth + "']"))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on ExpMonth" + ExpMonth);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to click on ExpMonth" + ExpMonth + " " + e);
            ReusableActionsPageObject.getScreenShot(driver, "ExpMonth", logger);
        }//end of exception
    }//end of method

    public void ClickExpYearBox(){
        ReusableActionsPageObject.clickonElement(driver, ExpYear, logger, "Click on Exp Month Box");
    }//end of method

    public void SelectExpYear(String ExpYear){
        WebDriverWait wait = new WebDriverWait(driver,8);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()= '" + ExpYear + "']"))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on ExpYear" + ExpYear);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Unable to click on ExpYear" + ExpYear + " " + e);
            ReusableActionsPageObject.getScreenShot(driver, "ExpYear", logger);
        }//end of exception
    }//end of method

    public void clickCCVNumber() {
        ReusableActionsPageObject.clickonElement(driver, Cvv, logger, "Click on CCNumber");
    }// end of method

    public void enterCVVNumber(String userValue) {
        ReusableActionsPageObject.sendKeysMethod(driver, Cvv, userValue, logger, "Enter CCNUmber");
    }// end of method

    public void ClickPurchase(){
        ReusableActionsPageObject.clickonElement(driver, Purchase, logger, "Click purchase");
    }//end of method

    public String Capturetext(){
        String captureText = ReusableActionsPageObject.CaptureText(driver, ErrorMessage, 0, logger, "Capture Error Message");
        return captureText;
    }//end of method






}//end of class
