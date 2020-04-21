package uk.axone.managingcontrols;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHowToHandleLinkText {

    WebDriver driver;

        @BeforeTest
        public void setUpBrowser(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        @Test
        public void testMnaagerBox() throws InterruptedException {

            driver.get("https://www.bbc.co.uk/");
           driver.findElement(By.linkText("Weather")).click();
           driver.findElement(By.partialLinkText("Virus")).click();
            Thread.sleep(2000);

        }

        @AfterTest
        public void teardown() throws InterruptedException {
            Thread.sleep(1000);
            driver.quit();
        }

}













