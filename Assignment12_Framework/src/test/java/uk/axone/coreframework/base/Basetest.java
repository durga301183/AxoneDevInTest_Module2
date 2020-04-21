package uk.axone.coreframework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import driver.WebDriverFactory;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import uk.axone.reportmanager.ReportManager;

/**
 *
 * BaseTest - abstracts out all the commonalities of a test.
 *
 *
 * @author karthik
 *
 */
public abstract class Basetest {

    /** driver instance variable. */
    private WebDriver driver;

    /** instance variable to handle config properties. */
    private Properties prop;

    private String browserType;

    private String platformName;

    private String browserVersion;

    private String gridConfigUrl;

    private String seleniumGridEnabled;

    /** CONSTANTS. */
    private static final String BROWSER_TYPE = "browserType";

    private static final String BROWSER_VERSION = "browserVersion";

    private static final String PLATFORM = "platform";

    private static final String GRID_ENABLED_FLAG = "isGridEnabled";

    private static final String GRID_HUB_URL = "gridHubUrl";

    // make this inst var as private and create accessor methods
    public ExtentReports report = ReportManager.reports();

    public ExtentTest test;

    // anything common to be performed

    // handling various drivers (browser type)

    // reading config values i.e. properties

    /**
     * @return the driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * no arg constructor. Helps to load the config properties file.
     */
    public Basetest() {
        String path = System.getProperty("user.dir")
                + "/src/test/resources/input_config.properties";
        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Map<String, String> readTestParameters(
            final ITestContext testContext) {
        return testContext.getCurrentXmlTest().getLocalParameters();
    }

    @BeforeTest
    public void testBaseBefore(final ITestContext testContext) {

        Map<String, String> testParameters = readTestParameters(testContext);

        browserType = testParameters.get(BROWSER_TYPE) != null
                ? testParameters.get(BROWSER_TYPE)
                : prop.getProperty(BROWSER_TYPE);
        // if test specific platform is mentioned from testng.xml use it
        // otherwise use from input_config.properties
        platformName = testParameters.get(PLATFORM) != null
                ? testParameters.get(PLATFORM)
                : prop.getProperty(PLATFORM);
        // if test specific platform is mentioned from testng.xml use it
        // otherwise use from input_config.properties
        browserVersion = testParameters.get(BROWSER_VERSION) != null
                ? testParameters.get(BROWSER_VERSION)
                : prop.getProperty(BROWSER_VERSION);

        //pouplate the values from input_config.properties
        gridConfigUrl = prop.getProperty(GRID_HUB_URL);
        seleniumGridEnabled = prop.getProperty(GRID_ENABLED_FLAG);
        //figure out whether Grid is enabled or not!!
        boolean isGridEnabled = Boolean.parseBoolean(seleniumGridEnabled);
        //initialize the driver.
        try {
            driver = WebDriverFactory.getDriver(browserType, platformName,
                    browserVersion, isGridEnabled, gridConfigUrl);
        } catch (MalformedURLException e) {
            System.out.println("ERROR: " + e);
        }

    }

    /** * Gets the prop field. * * @return the prop */

    public Properties getProp() {
        return prop;
    }

    /** * Gets the report field. * * @return the report */

    public ExtentReports getReport() {
        return report;
    }

    /** * Gets the test field. * * @return the test */

    public ExtentTest getTest() {
        return test;
    }

    // ui interactions --> opening browsers, navig to url, clicking a button,
    /**
     * method to launch the browser based on the input config.properties values.
     */
    public void launchBrowser() {
        String browserType = prop.getProperty("browserType");
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().version("75.0.3770.90").setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {

        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Invalid browser specified");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void navigateToUrl() {
        driver.navigate().to(prop.getProperty("applicationUrl"));
    }

    // clicking element
    public void clickElement(String locatorKey) {
        // 1. to identify the element
        // 2. to click on the element
        if (isElementEnabled(fetchElement(locatorKey))) {
            fetchElement(locatorKey).click();
        }
    }

    protected WebElement fetchElement(String locatorKey) {
        WebElement element = null;
        String locatorValue = prop.getProperty(locatorKey);
        if (locatorKey.endsWith("xpath")) {
            element = driver.findElement(By.xpath(locatorValue));
        } else if (locatorKey.endsWith("css")) {
            element = driver.findElement(By.cssSelector(locatorValue));
        } else if (locatorKey.endsWith("id")) {
            element = driver.findElement(By.id(locatorValue));
        } else if (locatorKey.endsWith("name")) {
            element = driver.findElement(By.name(locatorValue));
        } else if (locatorKey.endsWith("class")) {
            element = driver.findElement(By.className(locatorValue));
        } else {
            System.out.println("Invalid locatory specified");
        }

        return element;
    }

    // type values, etc.
    public void typeValues(String locatorKey, String valueToType) {
        // 1.identify the element
        // 2.type the value
        fetchElement(locatorKey).sendKeys(valueToType);
    }

    // taking screenshot
    public void takeFullScreenshot() {

        Date d = new Date();
        String filename = d.toString().replace(" ", "_").replace(":", "_")
                + ".png";
        String screenshotPath = SystemUtils.getUserDir()
                + "/target/screenshots/" + filename;

        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "PNG",
                    new File(screenshotPath));
            test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // validation methods
    public boolean isElementDisplayed(WebElement elementToCheck) {
        return elementToCheck.isDisplayed();
    }

    public boolean isElementEnabled(WebElement elementToCheck) {
        return elementToCheck.isEnabled();
    }

    // reporting methods
    public void reportInfo(String infoDetails) {
        test.log(LogStatus.INFO, infoDetails);
    }

    public void reportPass(String passDetails) {
        test.log(LogStatus.PASS, passDetails);
    }

    public void reportFail(String failDetails) {
        test.log(LogStatus.FAIL, failDetails);
        takeFullScreenshot();
    }

}
