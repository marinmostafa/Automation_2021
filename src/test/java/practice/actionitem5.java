package practice;

import Day9_04032021.ReusableMethods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class actionitem5 {
    public static void main(String[] args) throws InterruptedException, IOException, BiffException, WriteException {

        //set the driver using reusable method
        WebDriver driver = ReusableMethods.defineTheDriver();

        //locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/ActionItem5.xls"));

        //Create a writeable workbook that will mimic the data from readable
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/ActionItem5Result.xls"), readableBook);

        //read everything from writeable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        //Step 4: Get the row count
        int RowCount = writableSheet.getRows();

        driver.navigate().to("https://www.express.com");
        ReusableMethods.clickonElement(driver, "//*[@class= '_3tHVp']", "CloseButton");


        //this is where the for loop will start to iterate through your excel data
        for (int i=1; i<RowCount; i++) {

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
            ReusableMethods.Mousehover(driver, "//*[@href= '/mens-clothing']", "HoverOverMen");

            Thread.sleep(2000);

            //click on sweatshirts
            ReusableMethods.clickonElement(driver, "//a[text()= 'Sweatshirts & Hoodies']", "Sweatshirts");

            //click on the first picture
            ReusableMethods.clickonElement(driver, "//a[@class= '_2EWqA']", "FirstPicture");

            //click on different sizes
            ReusableMethods.clickonElement(driver, "//*[@value= '" + Size + "']", "Sizes");

            Thread.sleep(2000);

            //click on add to cart
            ReusableMethods.clickonElement(driver, "//button[text()= 'Add to Bag']", "Add to Cart");

            Thread.sleep(3000);

            //click on view bag
            ReusableMethods.clickonElement(driver, "//*[text()= 'View Bag']", "View Bag");

            //click on quantity box
            ReusableMethods.clickonElement(driver, "//select[@id= 'qdd-0-quantity']", "SelectQuantityBox");

            //enter different quantities
            ReusableMethods.clickonElement(driver, "//*[text()= '" + Quantity + "']", "SelectQuantity");

            Thread.sleep(3000);

            //click on checkout
            ReusableMethods.clickonElement(driver, "//*[@id= 'continue-to-checkout']", "Click Checkout");

            Thread.sleep(2000);

            //click on guest
            ReusableMethods.clickonElement(driver, "//*[text()= 'Checkout as Guest']", "ClickGuest");

            //start entering all values

            //click and enter first name
            ReusableMethods.clickonElement(driver, "//*[@name= 'firstname']", "ClickFName");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'firstname']", FName, "Enterfirstname");

            //click and enter last name
            ReusableMethods.clickonElement(driver, "//*[@name= 'lastname']", "ClickLName");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'lastname']", LName, "Enterlastname");

            //click and enter email
            ReusableMethods.clickonElement(driver, "//*[@name= 'email']", "ClickEmail");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'email']", Email, "EnterEmail");

            //click and enter confirm email
            ReusableMethods.clickonElement(driver, "//*[@name= 'confirmEmail']", "ClickConEmail");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'confirmEmail']", Email, "EnterConEmail");

            //click and enter phone number
            ReusableMethods.clickonElement(driver, "//*[@name= 'phone']", "ClickPhoneNumber");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'phone']", Phone, "EnterPhoneNumber");

            //click continue
            ReusableMethods.clickonElement(driver, "//*[@type= 'submit']", "ClickContinue");

            //start entering shipping info
            //click and enter first name
            ReusableMethods.clickonElement(driver, "//*[@name= 'shipping.firstName']", "ClickFNameShip");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'shipping.firstName']", FName, "EnterfirstnameShip");

            //click and enter last name
            ReusableMethods.clickonElement(driver, "//*[@name= 'shipping.lastName']", "ClickLNameShip");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'shipping.lastName']", LName, "EnterlastnameShip");

            //click and enter address
            ReusableMethods.clickonElement(driver, "//*[@name= 'shipping.line1']", "ClickAddress");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'shipping.line1']", Address, "EnterAddress");

            //click and enter zip code
            ReusableMethods.clickonElement(driver, "//*[@name= 'shipping.postalCode']", "ClickZipCode");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'shipping.postalCode']", ZCode, "EnterZipCode");

            //click and enter city
            ReusableMethods.clickonElement(driver, "//*[@name= 'shipping.city']", "ClickCity");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'shipping.city']", City, "EnterCity");

            //click and enter state
            ReusableMethods.clickonElement(driver, "//*[@name= 'shipping.state']", "ClickState");

            ReusableMethods.clickonElement(driver, "//*[text()= '" + State + "']", "SelectNY");

            //click continue
            ReusableMethods.clickonElement(driver, "//*[@type= 'submit']", "ClickContinue2");

            Thread.sleep(2000);

            //click continue
            ReusableMethods.clickonElement(driver, "//span[text()= 'Continue']", "ClickContinue3");

            //enter payment info
            //click and enter ccnumber
            ReusableMethods.clickonElement(driver, "//*[@name= 'creditCardNumber']", "ClickccNumber");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'creditCardNumber']", ccNum, "EnterccNumber");

            //select month and year both using click command from drop down
            ReusableMethods.clickonElement(driver, "//*[@name= 'expMonth']", "ClickExpMonth");

            ReusableMethods.clickonElement(driver, "//*[text()= '" + ExpMonth + "']", "SelectMonth");

            ReusableMethods.clickonElement(driver, "//*[@name= 'expYear']", "ClickExpYear");

            ReusableMethods.clickonElement(driver, "//*[text()= '" + ExpYear + "']", "SelectYear");

            //click and enter cvv code
            ReusableMethods.clickonElement(driver, "//*[@name= 'cvv']", "Clickccv");

            ReusableMethods.sendKeysMethod(driver, "//*[@name= 'cvv']", CvvCode, "Enterccv");

            //click purchase
            ReusableMethods.clickonElement(driver, "//*[@type= 'submit']", "ClickPurchase");

            //capture error message
            String ErrorMess = ReusableMethods.CaptureText(driver, "//div[@class= '_13uVj jwBXt']", 0, "CaptureText");

            //create a label so you can add it to a cell
            Label label = new Label(14,i, ErrorMess);

            //add the label back to the sheet
            writableSheet.addCell(label);


        }// end of for loop

        //outside of the cell write back to writable notebook
        writableWorkbook.write();
        //close it
        writableWorkbook.close();

        driver.quit();


    }//end of main method
}//end of java class
