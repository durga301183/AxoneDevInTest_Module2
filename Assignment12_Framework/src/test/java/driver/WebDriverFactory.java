package driver;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * The anchor point for handling the drivers, is responsible for the desired
 * WebDriver instance.
 *
 * @author Karthik.Gandhinathan
 */
public class WebDriverFactory {
    static WebDriver driver = null;

    public static synchronized WebDriver getDriver(final String browserType,
                                                   final String platformName, final String browserVersion,
                                                   final boolean isSeleniumGridEnabled, final String gridConfigUrl)
            throws MalformedURLException {
        if (!isSeleniumGridEnabled) {
            // code to handle the individual drivers
            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().version(browserVersion).setup();
                    return driver = new ChromeDriver();
                case "ie":
                    WebDriverManager.iedriver().version(browserVersion).setup();
                    return driver = new InternetExplorerDriver();
                default:
                    break;
            }
        } else {
            // code to handle the grid
            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setBrowserName(browserType);
            capability.setCapability(CapabilityType.PLATFORM_NAME,
                    platformName);
            capability.setCapability(CapabilityType.BROWSER_VERSION,
                    browserVersion);
            driver = new RemoteWebDriver(new URL(gridConfigUrl), capability);
        }

        return driver;

    }

}
