package practice;

import PageObjectClasses.Base_Class;
import ReUsableLibrary.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import org.jsoup.Connection;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExpressPageObject extends Abstract_Class {

    @Test
    public void ExpressPurchase() throws InterruptedException, IOException, BiffException, WriteException {

        //set the path to the report that I want to use
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/ActionItem5.xls"));
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/ActionItem5Result.xls"), readableBook);
        WritableSheet writableSheet = writableWorkbook.getSheet(0);
        int RowCount = writableSheet.getRows();


        driver.navigate().to("https://www.express.com");
        driver.manage().window().maximize();

        //close popup
        Base_Class.Expresshomepage().ClickPopUp();

        for (int i = 1; i < RowCount; i++) {

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
            driver.navigate().to("https://www.express.com");

            Thread.sleep(3000);

            //hover over mens tab
            Base_Class.Expresshomepage().HoverMensTab();

            //click on sweatshirts
            Base_Class.Expresshomepage().ClickSweaters();

            //click on first sweater
            Base_Class.Hoodies().ClickFirstHoodie();

            //click size
            Base_Class.hoodieDetails().addSize(Size);

            //click Add to Bag
            Base_Class.hoodieDetails().ClickAddBag();

            Thread.sleep(3000);

            //click View Bag
            Base_Class.hoodieDetails().ClickViewBag();

            //click quanitty box and select quantity
            Base_Class.preCheckOut().ClickQuantityBox();
            Base_Class.preCheckOut().ClickQuantityNumber(Quantity);

            //click checkout and checkout guest
            Base_Class.preCheckOut().ClickCheckout();
            Base_Class.preCheckOut().CheckoutAsGuest();

            //enter all info
            Base_Class.paymentPage().clickfirstname();
            Base_Class.paymentPage().enterfirstname(FName);
            Base_Class.paymentPage().clicklastname();
            Base_Class.paymentPage().enterlastname(LName);
            Base_Class.paymentPage().clickemail();
            Base_Class.paymentPage().enteremail(Email);
            Base_Class.paymentPage().clickconemail();
            Base_Class.paymentPage().enterconemail(Email);
            Base_Class.paymentPage().clickphone();
            Base_Class.paymentPage().enterphone(Phone);
            Base_Class.paymentPage().ClickCont();
            Base_Class.paymentPage().clickFName();
            Base_Class.paymentPage().enterFName(FName);
            Base_Class.paymentPage().clickLName();
            Base_Class.paymentPage().enterLName(LName);
            Base_Class.paymentPage().clickAddress();
            Base_Class.paymentPage().enterAddress(Address);
            Base_Class.paymentPage().clickZipCode();
            Base_Class.paymentPage().enterZipCode(ZCode);
            Base_Class.paymentPage().clickCity();
            Base_Class.paymentPage().enterCity(City);
            Base_Class.paymentPage().ClickState();
            Base_Class.paymentPage().SelectState(State);
            Base_Class.paymentPage().Click2Continue();
            Thread.sleep(3000);
            Base_Class.paymentPage().Click3Continue();
            Base_Class.paymentPage().clickCCNumber();
            Base_Class.paymentPage().enterCCNumber(ccNum);
            Base_Class.paymentPage().ClickExpMonthBox();
            Base_Class.paymentPage().SelectExpMonth(ExpMonth);
            Base_Class.paymentPage().ClickExpYearBox();
            Base_Class.paymentPage().SelectExpYear(ExpYear);
            Base_Class.paymentPage().clickCCVNumber();
            Base_Class.paymentPage().enterCVVNumber(CvvCode);
            Base_Class.paymentPage().ClickPurchase();
           String error = Base_Class.paymentPage().Capturetext();

            //create a label so you can add it to a cell
            Label label = new Label(14,i, error);

            //add the label back to the sheet
            writableSheet.addCell(label);

            logger.log(LogStatus.INFO,error);

        }//end of loop

        writableWorkbook.write();
        writableWorkbook.close();
    }//end of test method


}//end of class
