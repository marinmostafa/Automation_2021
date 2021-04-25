package practice;

import ReUsableLibrary.Abstract_Class;
import ReUsableLibrary.ReusableActions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExpressNG extends Abstract_Class {


    @Test
    public void Loop() throws WriteException, InterruptedException, IOException, BiffException {

        //set the path to the report that I want to use
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/ActionItem5.xls"));
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/ActionItem5Result.xls"), readableBook);
        WritableSheet writableSheet = writableWorkbook.getSheet(0);
        int RowCount = writableSheet.getRows();

        driver.navigate().to("https://www.express.com");
        ReusableActions.closePopupExist(driver, "//*[@class= '_3tHVp']", logger, "CloseButton");

        for (int i=1; i< RowCount; i++) {



            //columns are hard corded and row is dynamic(i)
            String Size = writableSheet.getCell(0,i).getContents();
            String Quantity = writableSheet.getCell(1,i).getContents();
            String FName = writableSheet.getCell(2,i).getContents();
            String LName = writableSheet.getCell(3,i).getContents();
            String Email = writableSheet.getCell(4,i).getContents();
            String Phone = writableSheet.getCell(5,i).getContents();
            String Address = writableSheet.getCell(6,i).getContents();
            String ZCode = writableSheet.getCell(7,i).getContents();
            String City = writableSheet.getCell(8,i).getContents();
            String State = writableSheet.getCell(9,i).getContents();
            String ccNum = writableSheet.getCell(10,i).getContents();
            String ExpMonth = writableSheet.getCell(11,i).getContents();
            String ExpYear = writableSheet.getCell(12,i).getContents();
            String CvvCode = writableSheet.getCell(13,i).getContents();

            //delete the cookies so you can start fresh
            driver.manage().deleteAllCookies();

            //navigate to express.com and maximize
            driver.navigate().to("https://www.express.com");
            driver.manage().window().maximize();

            //hover over men
            ReusableActions.Mousehover(driver, "//*[@href= '/mens-clothing']", logger, "HoverOverMen");

            Thread.sleep(2000);

            //click on sweatshirts
            ReusableActions.clickonElement(driver, "//a[text()= 'Sweatshirts & Hoodies']", logger, "Sweatshirts");

            //click on the first picture
            ReusableActions.clickonElement(driver, "//a[@class= '_2EWqA']", logger, "FirstPicture");

            //click on different sizes
            ReusableActions.clickonElement(driver, "//*[@value= '" + Size + "']", logger, "Sizes");

            Thread.sleep(5000);

            //click on add to cart
            ReusableActions.clickonElement(driver, "//button[text()= 'Add to Bag']",logger, "Add to Cart");

            Thread.sleep(3000);

            //click on view bag
            ReusableActions.clickonElement(driver, "//*[text()= 'View Bag']", logger, "View Bag");

            //click on quantity box
            ReusableActions.clickonElement(driver, "//select[@id= 'qdd-0-quantity']", logger, "SelectQuantityBox");

            //enter different quantities
            ReusableActions.clickonElement(driver, "//*[text()= '" + Quantity + "']", logger, "SelectQuantity");

            Thread.sleep(3000);

            //click on checkout
            ReusableActions.clickonElement(driver, "//*[@id= 'continue-to-checkout']", logger,  "Click Checkout");

            Thread.sleep(2000);

            //click on guest
            ReusableActions.clickonElement(driver, "//*[text()= 'Checkout as Guest']", logger, "ClickGuest");

            //start entering all values

            //click and enter first name
            ReusableActions.clickonElement(driver, "//*[@name= 'firstname']", logger,  "ClickFName");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'firstname']", FName, logger,  "Enterfirstname");

            //click and enter last name
            ReusableActions.clickonElement(driver, "//*[@name= 'lastname']", logger,  "ClickLName");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'lastname']", LName, logger,  "Enterlastname");

            //click and enter email
            ReusableActions.clickonElement(driver, "//*[@name= 'email']",  logger, "ClickEmail");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'email']", Email, logger,  "EnterEmail");

            //click and enter confirm email
            ReusableActions.clickonElement(driver, "//*[@name= 'confirmEmail']", logger,  "ClickConEmail");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'confirmEmail']", Email, logger,  "EnterConEmail");

            //click and enter phone number
            ReusableActions.clickonElement(driver, "//*[@name= 'phone']", logger,  "ClickPhoneNumber");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'phone']", Phone,  logger, "EnterPhoneNumber");

            //click continue
            ReusableActions.clickonElement(driver, "//*[@type= 'submit']", logger,  "ClickContinue");

            //start entering shipping info
            //click and enter first name
            ReusableActions.clickonElement(driver, "//*[@name= 'shipping.firstName']", logger,  "ClickFNameShip");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'shipping.firstName']", FName, logger,  "EnterfirstnameShip");

            //click and enter last name
            ReusableActions.clickonElement(driver, "//*[@name= 'shipping.lastName']",  logger, "ClickLNameShip");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'shipping.lastName']", LName, logger,  "EnterlastnameShip");

            //click and enter address
            ReusableActions.clickonElement(driver, "//*[@name= 'shipping.line1']", logger,  "ClickAddress");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'shipping.line1']", Address,  logger, "EnterAddress");

            //click and enter zip code
            ReusableActions.clickonElement(driver, "//*[@name= 'shipping.postalCode']", logger,  "ClickZipCode");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'shipping.postalCode']", ZCode,  logger, "EnterZipCode");

            //click and enter city
            ReusableActions.clickonElement(driver, "//*[@name= 'shipping.city']",  logger, "ClickCity");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'shipping.city']", City, logger,  "EnterCity");

            //click and enter state
            ReusableActions.clickonElement(driver, "//*[@name= 'shipping.state']",  logger, "ClickState");

            ReusableActions.clickonElement(driver, "//*[text()= '" + State + "']", logger,  "SelectNY");

            //click continue
            ReusableActions.clickonElement(driver, "//*[@type= 'submit']", logger,  "ClickContinue2");

            Thread.sleep(2000);

            //click continue
            ReusableActions.clickonElement(driver, "//span[text()= 'Continue']",  logger, "ClickContinue3");

            //enter payment info
            //click and enter ccnumber
            ReusableActions.clickonElement(driver, "//*[@name= 'creditCardNumber']",  logger, "ClickccNumber");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'creditCardNumber']", ccNum, logger,  "EnterccNumber");

            //select month and year both using click command from drop down
            ReusableActions.clickonElement(driver, "//*[@name= 'expMonth']",  logger, "ClickExpMonth");

            ReusableActions.clickonElement(driver, "//*[text()= '" + ExpMonth + "']", logger,  "SelectMonth");

            ReusableActions.clickonElement(driver, "//*[@name= 'expYear']", logger,  "ClickExpYear");

            ReusableActions.clickonElement(driver, "//*[text()= '" + ExpYear + "']", logger,  "SelectYear");

            //click and enter cvv code
            ReusableActions.clickonElement(driver, "//*[@name= 'cvv']", logger,  "Clickccv");

            ReusableActions.sendKeysMethod(driver, "//*[@name= 'cvv']", CvvCode,  logger, "Enterccv");

            //click purchase
            ReusableActions.clickonElement(driver, "//*[@type= 'submit']", logger,  "ClickPurchase");

            //capture error message
            String ErrorMess = ReusableActions.CaptureText(driver, "//div[@class= '_13uVj jwBXt']", 0, logger, "CaptureText");

            //create a label so you can add it to a cell
            Label label = new Label(14,i, ErrorMess);

            //add the label back to the sheet
            writableSheet.addCell(label);

            logger.log(LogStatus.INFO,ErrorMess);



        }// end of for loop

        writableWorkbook.write();
        writableWorkbook.close();

    }//end of test method


}// end of java class
