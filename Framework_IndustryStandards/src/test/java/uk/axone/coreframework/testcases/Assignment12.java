package uk.axone.coreframework.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uk.axone.coreframework.base.BaseTest_Assignment;

public class Assignment12 extends BaseTest_Assignment {

    @BeforeTest
    public void setUp() {
        test = report.startTest("Testing Axone Practice Portal");
    }


    @Test

    public void testPracticePortal() throws InterruptedException {

        reportInfo("Launching the Browser..");
        launchBrowser();

        reportInfo("Navigating to Url");
        navigateToUrl();

        reportInfo("Clicking the btn link");
        clickElement("btn_xpath");

        reportPass( "Test Check-PASSED");
      //  reportFail( "Test Check-FAILED");

        Thread.sleep(3000);


    }
    @AfterTest
    public void quitBrowser(){

        report.endTest(test);
        report.flush();
        getDriver() .quit();
    }

}