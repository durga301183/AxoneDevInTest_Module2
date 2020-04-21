package Assignment11;

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

public class Question3_Slide {

    WebDriver driver;

    @BeforeTest
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");

    }

    @Test
    public void slideMethod() throws InterruptedException {

        WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/input"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);

        actions.dragAndDropBy(slider, 30, 0).perform();
// actions.clickAndHold(slider).moveByOffset(30,0).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() ='4']")));
        Thread.sleep(3000);


    }


    @AfterTest
    public void tearDownBrowser() {
        driver.quit();

    }

}
