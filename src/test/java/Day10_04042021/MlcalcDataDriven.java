package Day10_04042021;

import Day9_04032021.ReusableMethods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class MlcalcDataDriven {
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        //set the driver using reusable method
        WebDriver driver = ReusableMethods.defineTheDriver();

        //Step 1: locate the path for readable file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/mcalcdatadriven.xls"));

        //Accessing the excel sheet to read the data
        //Sheet readableSheet = readableBook.getSheet(0);

        //Step 2: Create a writeable workbook that will mimic the data from readable
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/mcalcdatadrivenResult.xls"), readableBook);

        //Step 3: read everything from writeable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        //Step 4: Get the row count
        int RowCount = writableSheet.getRows();

        //this is where the for loop will start to iterate through your excel data
        for (int i=1; i<RowCount; i++){

            //columns are hard corded and row is dynamic(i)
            String Pprice = writableSheet.getCell(0,i).getContents();
            String Dpayment = writableSheet.getCell(1,i).getContents();
            String MTerm = writableSheet.getCell(2,i).getContents();
            String IRate = writableSheet.getCell(3,i).getContents();
            String Startmonth = writableSheet.getCell(4,i).getContents();
            String StartYear = writableSheet.getCell(5,i).getContents();

            //navigate to mcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2000);

            //enter the purchase price
            ReusableMethods.sendKeysMethod(driver, "//input[@id= 'ma']", Pprice, "Purchase Price");

            //enter the down payment
            ReusableMethods.sendKeysMethod(driver, "//input[@id= 'dp']", Dpayment, "Down Payment");

            //enter the mortgage term
            ReusableMethods.sendKeysMethod(driver, "//input[@id= 'mt']", MTerm, "Mortage Term");

            //enter interest rate
            ReusableMethods.sendKeysMethod(driver, "//input[@id= 'ir']", IRate, "Interest Rate");

            //enter start month
            ReusableMethods.dropdownbyText(driver, "//select[@name= 'sm']", Startmonth, "Start Month");

            //enter start year
            ReusableMethods.dropdownbyText(driver, "//select[@name= 'sy']", StartYear, "Start Year");

            //click on calculate
            ReusableMethods.clickonElement(driver, "//input[@value= 'Calculate']", "Calculate");

            //capture monthly payment
            String monthlyPayment = ReusableMethods.CaptureText(driver, "//td[@class= 'big']", 0, "Monthly Payment");

            //create a label so you can add it to a cell
            Label label = new Label(6,i, monthlyPayment);

            //add the label back to the sheet
            writableSheet.addCell(label);


        }// end of for loop

        //outside of the cell write back to writable notebook
        writableWorkbook.write();
        //close it
        writableWorkbook.close();

        driver.quit();

    }// end of main method
}// end of java class
