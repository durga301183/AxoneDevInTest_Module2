package Assignment11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Question_AscendingOrder {

    WebDriver driver;

    @BeforeTest
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/tables");

    }

//@Test(priority = 1)
    public void sortDues() throws InterruptedException {
        List<WebElement> Dues = driver.findElements(By.xpath("//table[1]/tbody/tr/td[4]"));
            for (WebElement element : Dues) {
                System.out.println(element.getText());
            }

    System.out.println("Sorted list is  .....");
    WebElement duesSort=  driver.findElement(By.xpath("//th[@class='header']//span[contains(text(), 'Due')]"));
    duesSort.click();
    Thread.sleep(2000);
    List<WebElement> newDues = driver.findElements(By.xpath("//table[1]/tbody/tr/td[4]"));
    for (WebElement newDue : newDues) {
        System.out.println(newDue.getText());
    }

    }
@Test
   public void sortEmail(){

        List<WebElement> email = driver.findElements(By.xpath("//table[1]/tbody/tr/td[3]"));
       for (WebElement element : email) {

           System.out.println(element.getText());
       }
       System.out.println("Sorted email list is:");
       WebElement Email = driver.findElement(By.xpath("//th[@class='header']//span[contains(text(), 'Email')]"));
       Email.click();
       List<WebElement> element1 = driver.findElements(By.xpath("//table[1]/tbody/tr/td[3]"));
       for (WebElement ele : element1) {
           System.out.println(ele.getText());

       }
    }

    @AfterTest
    public void tearDownBrowser() {
        driver.quit();

    }
}





