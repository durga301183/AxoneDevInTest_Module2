package Assignment10;
/*
Using	Smart	customised	XPath selector	achieve	the	following
a)	Login	to	http://uitest.automationtester.uk/basic-first-form-demo.html
b)	Write	your	own	custom	css	selector	to	click	on	the	All	Examples menu on	the
left	hand	tree	structure.	Navigate	to	Input	Forms	>	Radio	Buttons Demo page
PS: Don’t	navigate	directly	to	the	URL.
c)	Navigate	to	“Group	Radio	Buttons	demo”	section
d)	Write	a	test	to	fetch	all	the	values	of	the	Age	group	radio	buttons	and	print
them.	Also	print	whether	they	are	selected	or	not
e)	Write	another	test	to	validate	“Get	Values”	logic.
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestQuestion6_key {
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

        WebElement radioButtonDemo = driver.findElement(By.xpath(" //a[contains(text(),'Radio Buttons Demo')]"));
        radioButtonDemo.click();

        Thread.sleep(3000);

        List<WebElement> genderList = driver.findElements(By.name("gender"));

        for (WebElement element : genderList) {
            System.out.println("Gender : " + element.getAttribute("value")
                    + "---" + element.isSelected());

            if (element.getAttribute("value").equalsIgnoreCase("female")) {
                element.click();
            }
        }

        List<WebElement> list = driver.findElements(By.name("ageGroup"));

        for (WebElement element : list) {

            System.out.println("Agegroup:" + element.getAttribute("value") + "  " + element.isSelected());
            if (element.getAttribute("value").equalsIgnoreCase("5-15")) {
                element.click();
            }
        }
        driver.findElement(By.xpath("//button[contains(text(),'Get values')]")).click();
        driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();

        String actualGender = driver.findElement(By.xpath("//p[@class='groupradiobutton']")).
                getText().replaceAll("Sex : ", "").replaceAll(" Age group: ", ":").split(":")[0];
        String actualAgeGroup = driver.findElement(By.xpath("//p[@class='groupradiobutton']")).
                getText().replaceAll("Sex : ", "").replaceAll(" Age group: ", ":").split(":")[1];

        Assert.assertEquals(actualGender, "Female");
      Assert.  assertEquals(actualAgeGroup, "5 - 15");

    }
    @AfterTest
    public void tearDowwn() {
        driver.quit();
    }

}



