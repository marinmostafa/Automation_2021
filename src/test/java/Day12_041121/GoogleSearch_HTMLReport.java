package Day12_041121;

import ReUsableLibrary.Abstract_Class;
import ReUsableLibrary.ReusableActions;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class GoogleSearch_HTMLReport extends Abstract_Class {

    @Test
    public void SearchForACar() throws InterruptedException {
        driver.navigate().to("https://www.google.com");

        Thread.sleep(2500);
        //search for a car
        ReusableActions.sendKeysMethod(driver,"//*[@name='q']","cars",logger,"Search Field");
        //submit on google search button
        ReusableActions.submitonElement(driver,"//*[@name='btnK']",logger,"Google Search");
        Thread.sleep(3000);
    }//end of test 1

    @Test(dependsOnMethods = "SearchForACar")
    public void getSearchNumber(){
        String result = ReusableActions.CaptureText(driver,"//*[@id='result-stats']",0,logger,"Google Search Result");
        String[] arrayResult = result.split(" ");
        System.out.println(arrayResult[1]);
        logger.log(LogStatus.INFO,"My search number is " + arrayResult[1]);

    }//end of test 2

}// end of java class
