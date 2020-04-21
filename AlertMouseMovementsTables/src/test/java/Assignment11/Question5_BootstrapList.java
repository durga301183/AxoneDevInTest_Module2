package Assignment11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Question5_BootstrapList {
    WebDriver driver;

    @BeforeTest
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://uitest.automationtester.uk/bootstrap-dual-list-box-demo.html");

    }
@Test(priority = 1)
    public void selectBootStrap() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement textbox = driver.findElement(By.xpath("//div[@class='well text-right']//input[@placeholder='search']"));
        textbox.sendKeys("bootstrap");

      WebElement bootStrapListSelected = driver.findElement(By.xpath("//li[contains(text(),'bootstrap-duallist')]"));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'bootstrap-duallist')]")));
                 bootStrapListSelected.click();
                 Thread.sleep(2000);
    }

@Test(priority = 2)
    public void moveToRightSide() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-right']")).click();
        driver.findElement(By.xpath("//div[@class='well']//ul[@class='list-group']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='list-group-item active']")));
         Thread.sleep(2000);

    }


    @AfterTest
    public void tearDownBrowser() {
        driver.quit();

    }

}



















