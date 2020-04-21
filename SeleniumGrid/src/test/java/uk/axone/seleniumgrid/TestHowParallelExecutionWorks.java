package uk.axone.seleniumgrid;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


    public class TestHowParallelExecutionWorks {

        DesiredCapabilities capabilities;
        URL remoteAddress;

        @Parameters("browserName")
        @Test
        public void testParallel(final String browserType) throws MalformedURLException, InterruptedException {
            new URL("http://172.17.0.2:4445/wd/hub");
            if (browserType.equalsIgnoreCase("chrome")){
                capabilities = DesiredCapabilities.chrome();
                capabilities.setPlatform(Platform.LINUX);
            } else if(browserType.equalsIgnoreCase("firefox")){
                capabilities = DesiredCapabilities.firefox();
                capabilities.setPlatform(Platform.LINUX);
            }


            WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities);
            driver.get("http://uitest.automationtester.uk/");
            System.out.println(driver.getTitle());
            Thread.sleep(20000);
            driver.quit();

        }

    }

