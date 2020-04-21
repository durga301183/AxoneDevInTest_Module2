package uk.axone.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*

public class Actions
extends java.lang.Object
The user-facing API for emulating complex user gestures. Use this class rather than using the Keyboard or Mouse directly.
Constructors
Constructor and Description
Actions(Keyboard keyboard)
Deprecated.
Use the new interactions API.
Actions(Keyboard keyboard, Mouse mouse)
Deprecated.
Use the new interactions APIs.
Actions(WebDriver driver)
 */
public class TestHowToHover {

        WebDriver driver;

        @BeforeTest

        public void setupBrowser() {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.americangolf.co.uk");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        @Test
        public void hoverMouse() throws InterruptedException {
            Thread.sleep(3000);
            WebElement golfclub = driver.findElement(By.xpath("//a[@class='a-level-1'][contains(text(),'Golf Clubs')]"));
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(golfclub));
//create Actions class which is a concrete class and used a default constructor
            //Use the new interactions APIs.
            //Actions(WebDriver driver)
            Actions actions = new Actions(driver);
            actions.moveToElement(golfclub).perform();
            driver.findElement(By.xpath("//div[@id='CLUBS_1']//span[@class='name'][contains(text(), 'Sets of Irons')]")).click();

        }

@AfterTest
        public void tearDown() {
            driver.quit();
        }
    }




