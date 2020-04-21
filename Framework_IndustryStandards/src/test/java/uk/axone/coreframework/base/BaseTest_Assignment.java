package uk.axone.coreframework.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import uk.axone.framework.report.ReportManager;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class BaseTest_Assignment {
    private WebDriver driver;
    public Properties prop;
    public ExtentReports report = ReportManager.getInstance();
    public ExtentTest test;


    public WebDriver getDriver() {
        return driver;
    }

    public BaseTest_Assignment() {
        String path = System.getProperty("user.dir") + "/src/test/java/resources/config_Assignment12.properties";

        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);
            String applicationUrl = prop.getProperty("applicationUrl");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void launchBrowser() {

        String browserType = prop.getProperty("browserType");
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {
            System.out.println("Invalid Browser");
        }

    }

    public void navigateToUrl() {

        driver.navigate().to(prop.getProperty("applicationUrl"));
    }

    public WebElement findElement(final String key) {
        WebElement element = null;
        String elementValue = prop.getProperty(key);
        if (key.endsWith("xpath")) {
            element = driver.findElement(By.xpath(elementValue));
        }
        else {
            System.out.println("LocatorKey specified is invalid.");
        }

        return element;
    }

    public void clickElement(String key) throws InterruptedException {
        findElement(key).click();
        Set<String> windows = driver.getWindowHandles();
        //to get the size
        System.out.println(windows.size());
        //to iterate ,  which returns of type string
        Iterator<String> itr =windows.iterator();
        //window handle is stored ins  seperate variable
        String Mainwindow=   itr.next();
        String Popupwindow1 =itr.next();
        String Popupwindow2 =itr.next();
        driver.switchTo().window(Popupwindow1);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        //current window open will be closed
        driver.close();
        driver.switchTo().window(Popupwindow2);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(Mainwindow);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());

    }
    public void takeFullScreenshot () {
        Date d = new Date();
        String filename = d.toString().replace(" ", "_").replace(":", "_") + ".png";
        String screenshotPath = SystemUtils.getUserDir() + "/target/screenshots/" + filename;

        //fluent style coding
        //1. Take the Screenshot image
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        //2. Write to a location
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotPath));
            test.log(LogStatus.FAIL, "Snapshot below: "+test.addScreenCapture(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //reporting methods

    public void reportInfo (String infoMessage){
        test.log(LogStatus.INFO, "infoMessage");

    }
    public void reportPass (String passMessage){
        test.log(LogStatus.PASS, "passMessage");


    //public void reportFail (String failMessage){
     //   test.log(LogStatus.FAIL, "failMessage");

        takeFullScreenshot();

    }
}



