package uk.axone.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestUIElementToDissapear {

    WebDriver driver;

    @BeforeTest

    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testUIElementsToAppear() throws IOException, InterruptedException {
        driver.get("http://uitest.automationtester.uk/dynamic-data-loading-demo.html");
        driver.findElement(By.id("save")) .click();
//creating webdriver wait instance
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //specify the condition to wait
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("loading"),"loading..."));
        System.out.println(driver.findElement(By.id("loading")).getText());
        Thread.sleep(10000);

    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}




