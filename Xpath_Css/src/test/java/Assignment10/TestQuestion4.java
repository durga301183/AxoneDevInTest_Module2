
package Assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
/*
Using	Smart	customised	css	selector	achieve	the	following
a)	Login	to	http://uitest.automationtester.uk/basic-first-form-demo.html
b)	Write	your	own	custom	css	selector	to	click	on	the	All	Examples menu on	the
left	hand	tree	structure.	Navigate	to	Input	Forms	>	Simple	Form	Demo
PS: Don’t	navigate	directly	to	the	URL.
c)	Navigate	to	“Two	Input	Fields”	section
d)	Write	a	test	to	validate	the	addition	operation	for	the	given	fields.
 */
public class TestQuestion4 {

    WebDriver driver;
    FileInputStream fis;
    Properties props;
    String browser = "Chrome";

    @BeforeTest
    public void launchBrowser() {
        //  to read the properties file

        try {
            fis = new FileInputStream("C:/Users/G S Sastry/Axone Workspace/Xpath_Css/src/test/resources/inputparameters.properties");
            //to load the fis object
            Properties props = new Properties();
            props.load(fis);
            String browserDetails = props.getProperty("Browser");
            if (browser.equalsIgnoreCase(browserDetails)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void navigatetoURL() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(props.getProperty("http://uitest.automationtester.uk"));
    }

    @Test(priority = 2, dependsOnMethods = {"navigatetoURL"})

    public void findWebElements() throws InterruptedException {

        driver.findElement(By.xpath("//ul[@id=\"treemenu\"]/li/a")).click();
        WebElement inputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        inputForms.click();
        WebElement checkBoxDemo = driver.findElement(By.xpath(" //a[contains(text(),'Simple Form Demo')]"));
        checkBoxDemo.click();

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        driver.findElement(By.id("sum1")).sendKeys("25");
        driver.findElement(By.id("sum2")).sendKeys("25");
        driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();

        Assert.assertEquals(driver.findElement(By.id("displayvalue")).getText(), "50");
    }
@AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
}







