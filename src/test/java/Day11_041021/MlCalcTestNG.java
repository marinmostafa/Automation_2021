package Day11_041021;

import Day9_04032021.ReusableMethods;
import ReUsableLibrary.Abstract_Class;
import ReUsableLibrary.ReusableActions;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MlCalcTestNG extends Abstract_Class {



    @Test
    public void testScenario () throws InterruptedException, WriteException, IOException, BiffException {
        //set the driver using reusable method
        driver = ReusableMethods.defineTheDriver();

        //Step 1: Locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/mcalcdatadriven.xls"));

        //Step 2: Create a writeable workbook that will mimic the data from readable
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/mcalcdatadrivenResult.xls"), readableBook);

        //Step 3: Read everything from writable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        //Step 4: Get the row Count
        int rowCount = writableSheet.getRows();

        //this is where the for loop will start to iterate through your excel data

        for (int i= 1; i < rowCount; i++){
            //columns are hard coded and row is dynamic (i)
            String Pprice = writableSheet.getCell(0,i).getContents();
            String DPayment = writableSheet.getCell(1, i).getContents();
            String MTerm = writableSheet.getCell(2, i).getContents();
            String IRate = writableSheet.getCell(3,i).getContents();

            //navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(3000);
            //enter the purchase price
            ReusableActions.sendKeysMethod(driver, "//input[@id='ma']", Pprice, logger,"Purchase Price");
            //enter the down payment
            ReusableActions.sendKeysMethod(driver, "//input[@id= 'dp']", DPayment, logger,"Down Payment");
            //enter mortgage term
            ReusableActions.sendKeysMethod(driver, "//input[@id= 'mt']", MTerm, logger,"Mortgage Term");
            //enter interest rate
            ReusableActions.sendKeysMethod(driver, "//input[@id= 'ir']", IRate, logger,"Interest Rate");
            //click on Calculate
            ReusableActions.clickonElement(driver, "//input[@value= 'Calculate']",logger, "Calculate");

            //capture monthly payment
            String monthlyPayment = ReusableActions.CaptureText(driver, "//td[align= 'center']", 0, logger,"Monthly Payment");

            //print out the monthly payment to see the result in my log
            logger.log(LogStatus.INFO,"My search number is " + monthlyPayment);

            //create a label so you can add it to a cell
            Label label = new Label(6, i, monthlyPayment);
            //add the label back to the sheet
            writableSheet.addCell(label);
        }//end of loop

        //outside of the cell write back to writeable workbook
        writableWorkbook.write();
        //close it
        writableWorkbook.close();

    }//end of test scenario


        //open writable excel automatically
        //Desktop.getDesktop().open(new File("src/main/resources/mcalcdatadrivenResult.xls"));

}// end of java class




