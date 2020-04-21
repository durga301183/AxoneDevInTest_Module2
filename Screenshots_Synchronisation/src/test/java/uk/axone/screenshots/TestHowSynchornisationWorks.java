package uk.axone.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestHowSynchornisationWorks {

    WebDriver driver;

        @BeforeTest

        public void openBrowser(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        @Test
        public void testTakingScreenshots() throws IOException {

            driver.get("https://www.amazon.co.uk/");
            //implicit wait is applied for entire session after initialisating the webdriver until it finds the element
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

@Test
public void testExplicitSync() {
//1.explicit wait= create an instance of webdriver wait
    WebDriverWait wait = new WebDriverWait(driver, 10);
    //is element clickable
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));
    //is element visible
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
    //is element invisible
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));

        }

        @AfterTest

        public void tearDown(){
            driver.close();
        }
}
