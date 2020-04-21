package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import uk.axone.coreframework.base.Basetest;

public class TestA extends Basetest {

    // 1. Launch the browser
    // 2. Navigate to selenium practice portal
    // 3. Click the Sign-in link
    // 4. enter username / password
    // 5.click the sign-in button
    // 6.validate user login

    @Test
    public void testPracticePortal() throws InterruptedException {

        test = report.startTest("testPracticePortal");

        reportInfo("navigating to url");
        navigateToUrl();
        takeFullScreenshot();

        reportInfo("clicking on Sigin link");
        System.out.println(isElementDisplayed(fetchElement("sign_in_link_xpath")));
        clickElement("sign_in_link_xpath");

        reportInfo("entering username");
        typeValues("username_id", "karthik@axone-tech.uk");

        reportInfo("entering password");
        typeValues("pass_name", "password");
        takeFullScreenshot();

        reportInfo("click sign in button");
        clickElement("sign_in_button_css");

        reportPass("Test case is passed");
        reportFail("Test case is failed..");

        Thread.sleep(1000);
    }

    @AfterTest
    public void quitBrowser() {
        report.endTest(test);
        report.flush();

        getDriver().quit();
    }
}
