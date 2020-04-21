package uk.axone.seleniumgrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestHowGridWorks {

    @Test
    public void testSeleniumGrid() throws MalformedURLException, InterruptedException {
      //IP address of the hub
        URL remoteAddress = new URL("http://192.168.0.10:4444/wd/hub");
        DesiredCapabilities capabilities;
        capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WIN10);

        WebDriver driver = new RemoteWebDriver(remoteAddress,capabilities);
        driver.get("http://uitest.automationtester.uk/");
        System.out.println(driver.getTitle());
        Thread.sleep(10000);
        driver.quit();

    }
}
