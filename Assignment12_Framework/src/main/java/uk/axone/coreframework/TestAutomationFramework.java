package uk.axone.coreframework;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.axone.reportmanager.ReportManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestAutomationFramework {

    //1.create private variable for Webdriver driver
    private WebDriver driver;

    //1a. 1a create private variable for webdriver wait
    public WebDriverWait wait;

    //2.create getter and setter methods for driver
    public WebDriver getDriver() {
        return driver;
    }

    //3.Get the Extent report here and use the extent tests to use in the testcase
    public ExtentReports report = ReportManager.reports();
    public ExtentTest test;
    //4.to handle the property file
    public Properties prop;

    //5.Create constructor and keep the code to read the config.prop file here

    public TestAutomationFramework() {

        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/configuration.properties";

            prop = new Properties();
            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);
            //String applicationUrl = prop.getProperty("applicationUrl");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //6.Create method to launch the browser from the property file
    public void launchBrowser(String key) throws InterruptedException {
        String browserType = prop.getProperty(key);
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        }

        //7.Navigate to the URL

        public void navigateToURL (String key){
            driver.navigate().to(prop.getProperty(key));
        }

        //8.Identify the Webelements

        public WebElement identifyElements (String key){

            WebElement element = null;

            String locator = prop.getProperty(key);
            if (key.endsWith("xpath")) {
                element = driver.findElement(By.xpath(locator));
            } else if (key.endsWith("id")) {
                element = driver.findElement(By.id(locator));
            } else if (key.endsWith("css")) {
                element = driver.findElement(By.cssSelector(locator));
            } else if (key.endsWith("name")) {
                element = driver.findElement(By.name(locator));
            } else {

                System.out.println("Invalid Locator Specified");
            }

            return element;
        }
//scrolling in page

        public void scrollInPage () {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(500,1000)");

        }

        public void clickElement (String key)
        {
            identifyElements(key).click();
        }

        public void typeIn (String key, String text)
        {
            identifyElements(key).sendKeys(text);
        }


        //reporting methods
        public void reportInfo (String infoMessage){
            test.log(LogStatus.INFO, "infoMessage");

        }
        public void failedReport (String failMessage){
            test.log(LogStatus.FAIL, "failMessage");
            takeScreenShots();
        }

        public void passedReport (String passMessage){
            test.log(LogStatus.PASS, "passMessage");
        }

        //9. Take Screenshots on Failure

        public void takeScreenShots () {
            // Date d = new Date();
            String filename = new Date().toString().replace(" ", "_").replace(":", "_") + ".png";
            String takeScreenShot = SystemUtils.getUserDir() + "/target/screenshots/" + filename;
            //fluent style coding
            //1. Take the Screenshot image
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                    .takeScreenshot(driver);
            //2. Write to a location
            try {
                ImageIO.write(screenshot.getImage(), "PNG", new File(takeScreenShot));
                test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(takeScreenShot));
                test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(takeScreenShot));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //10.validations
        public boolean isEnabled (WebElement element){
            return element.isEnabled();
        }
        public boolean isDisplayed (WebElement element){
            return element.isDisplayed();
        }

//11. Method to manage single and multiple popup windows
        public void handleMultiPopUpWindows () throws InterruptedException {
        Set<String> window = driver.getWindowHandles();
            Iterator<String> itr = window.iterator();
            String mainWin = itr.next();
            while (itr.hasNext()) {
                String popupWin = itr.next();
                driver.switchTo().window(popupWin);
                test.log(LogStatus.PASS, "Title of the current window is:" + driver.getTitle());
                Thread.sleep(1000);
            }
/*
// It will return the parent window name as a String
String parent=driver.getWindowHandle();
 // This will return the number of windows opened by Webdriver and will return Set of St//rings
Set<String>s1=driver.getWindowHandles();
 // Now we will iterate using Iterator
Iterator<String> I1= s1.iterator();
while(I1.hasNext()){
String child_window=I1.next();
// Here we will compare if parent window is not equal to child window then we will close
if(!parent.equals(child_window))
{
driver.switchTo().window(child_window);
System.out.println(driver.switchTo().window(child_window).getTitle());
driver.close();
}
}
// once all pop up closed now switch to parent window
driver.switchTo().window(parent);
 */
            driver.close();
            driver.switchTo().window(mainWin);
        }

        //13. Write to extent reports

        public void writeToReports () {
            report.endTest(test);
            report.flush();
        }
    }










