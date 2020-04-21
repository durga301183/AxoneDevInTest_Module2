package Assignment11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Question2_DragnDrop {


    WebDriver driver;

    @BeforeTest
    public void setupBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://uitest.automationtester.uk/drag-and-drop-demo.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        Thread.sleep(2000);
    }

    @Test
    public void dragDrop() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement source = driver.findElement(By.xpath("//span[contains(text(), 'Draggable 1')]"));
        WebElement target = driver.findElement(By.cssSelector("#mydropzone"));
        Actions drag = new Actions(driver);
        drag.dragAndDrop(source, target).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppedlist")));
        Thread.sleep(3000);
    }


    @AfterTest
    public void tearDownBrowser() {
        driver.quit();
    }

}



