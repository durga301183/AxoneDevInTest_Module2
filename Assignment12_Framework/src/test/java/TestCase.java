import javafx.scene.layout.Priority;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uk.axone.coreframework.TestAutomationFramework;

public class TestCase extends TestAutomationFramework {

    @BeforeTest
    public void setUp() {

        test = report.startTest("Testing Axone Selenium Practice Portal");
    }

    @Test(priority = 1)
    public void launchBrowserAndNavigate() throws InterruptedException {
        reportInfo("Launching the Browser..");
        launchBrowser("Browser");

        reportInfo("Navigating to URL");
        navigateToURL("URLAssign");

    }


    @Test(priority = 2)
    public void getTitle_ClickFirstButton() throws InterruptedException {

        passedReport("Identifying the Follow on Twitter Button") ;
            identifyElements("followOnTwitter_xpath");

        passedReport("Clicking on the Button") ;
            clickElement("followOnTwitter_xpath");

        passedReport("Switching to PopUp Window");
            handleMultiPopUpWindows();
            Thread.sleep(2000);
            takeScreenShots();

        }


                @Test(priority = 3)
                public void getTitle_ClickSecondButton () throws InterruptedException {

                    passedReport("Identifying the Like us on Facebook Page") ;
                        identifyElements("likeOnFB_xpath");

                        passedReport("Clicking on the Second Button") ;
                            clickElement("likeOnFB_xpath");

                            passedReport("Switching to Popup Window") ;
                                handleMultiPopUpWindows();
                                Thread.sleep(2000);
                                takeScreenShots();

                            }

                            @Test(priority = 4)

                            public void testMultipleWindowModal() throws InterruptedException {

                                passedReport("Identifying Follow Twitter and FB Button");
                                identifyElements("followOnTwitter_FB_xpath");

                                clickElement("followOnTwitter_FB_xpath");

                                handleMultiPopUpWindows();
                                Thread.sleep(2000);
                                takeScreenShots();

                            }

                            @AfterTest
                            public void endTest () {

                                getDriver().quit();
                                writeToReports();
                            }
                        }
























