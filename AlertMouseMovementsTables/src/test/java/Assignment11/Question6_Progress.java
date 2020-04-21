package Assignment11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Question6_Progress {

    WebDriver driver;

    @BeforeTest
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://uitest.automationtester.uk/bootstrap-download-progress-demo.html");

    }
@Test
    public void checkProgression() {

        driver.findElement(By.id("cricle-btn")).click();
        WebElement element = driver.findElement(By.xpath("//div[@class='percenttext']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(element, "100%"));
        System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "100%");

    }

    @AfterTest
    public void tearDownBrowser() {
        driver.quit();

    }


}