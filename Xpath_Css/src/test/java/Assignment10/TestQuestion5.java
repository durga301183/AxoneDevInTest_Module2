package Assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestQuestion5 {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://uitest.automationtester.uk/");
    }

    @Test(priority = 0)
    public void testSimpleFormDemo() throws InterruptedException {

        WebElement inputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        inputForms.click();

        WebElement checkBoxDemo = driver.findElement(By.xpath(" //a[contains(text(),'Checkbox Demo')]"));
        checkBoxDemo.click();

        Thread.sleep(3000);

        List<WebElement> list = driver.findElements(By.xpath("//div[contains(text(),'Multiple Checkbox Demo')]/following-sibling::div/div[contains(@class,'checkbox')]"));

        for (WebElement element : list) {
            System.out.println("Check box options are : " + element.getText()
                    + "---" + element.isSelected());
        }
    }
        @Test(priority = 1)
        public void test2 () throws InterruptedException {
            Thread.sleep(200);
            WebElement checkAll = driver.findElement(By.cssSelector("input.btn.btn-primary"));
            checkAll.click();

            if (checkAll.getAttribute("value").equals("Uncheck All")) {
                System.out.println("All checkboxes are checked");
            }

            Thread.sleep(3000);
            checkAll.click();

            if (checkAll.getAttribute("value").equals("Check All")) {
                System.out.println("All checkboxes are unchecked");
            }

            Thread.sleep(300);
        }

        @AfterTest
        public void tearDown () {
            driver.quit();
        }

    }









