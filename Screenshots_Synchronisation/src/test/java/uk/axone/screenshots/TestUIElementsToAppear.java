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

public class TestUIElementsToAppear {

    WebDriver driver;

    @BeforeTest

    public void openBrower(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testUIElementsToAppear() throws IOException, InterruptedException {
        driver.get("http://uitest.automationtester.uk/jquery-download-progress-bar-demo.html");
        driver.findElement(By.id("downloadButton")) .click();
//creating webdriver wait instance
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //specify the condition to wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#dialog > div.progress-label"))).getText().equalsIgnoreCase("Complete!");
    Thread.sleep(10000);

    }


    @AfterTest

    public void tearDown()
    {
        driver.close();
    }
}






