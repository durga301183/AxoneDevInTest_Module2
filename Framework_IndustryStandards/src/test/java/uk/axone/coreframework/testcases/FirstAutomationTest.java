package uk.axone.coreframework.testcases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uk.axone.coreframework.base.BaseTest;
import uk.axone.framework.report.ReportManager;

public class FirstAutomationTest extends BaseTest{

    @BeforeTest
    public void setUp(){
        test= report.startTest("Testing Axone Selenium Practice Portal");
    }


    @Test

    public void  testPracticePortal() throws InterruptedException {
// if we have many tests, then many reports needs to be cretaed which is common .hence moved to base test
       // ExtentReports report = ReportManager.getInstance();

        reportInfo("Launching the Browser..");
        launchBrowser();

        reportInfo("Navigating to Url");
        navigateToUrl();

        reportInfo("Clicking the sign-in link");
        clickElement("sign_in_xpath");

        Thread.sleep(3000);

        reportInfo("Clicking the username values");
        sendText("user_id","karthik@axone-tech.uk");

        reportInfo("Clicking the password values");
        sendText("password_name","password");

        reportInfo("Clicking on sign_in button");
        clickElement("sign_in_btn_css");

        //Assertion
        reportPass( "Test Check-PASSED");
        reportFail( "Test Check-FAILED");
        Thread.sleep(3000);
    }

    @AfterTest
    public void quitBrowser(){

        report.endTest(test);
        report.flush();
        getDriver() .quit();
    }

}