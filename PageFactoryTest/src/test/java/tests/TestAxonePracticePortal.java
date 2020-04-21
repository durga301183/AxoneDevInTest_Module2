package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAxonePracticePortal {
    //1. Launch browser
    //2. Navigate to AUT
    //3. click on the sign-in link
    //4. enter email and password
    //5. verify my account page
    //6. logout

    public WebDriver driver;

    @Test
    public void axoneTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/");
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.id("email")).sendKeys("karthik@axone-tech.uk");
        driver.findElement(By.name("passwd")).sendKeys("password");
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='logout']")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
