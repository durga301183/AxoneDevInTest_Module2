package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimplePageFactoryTest {
    //driver.findElement(By.xpath("//a[@class='login']"))
    @FindBy(xpath = "//a[@class='login']")
    public static WebElement lnkSignin;

    @FindBy(id = "email")
    public static WebElement txtEmail;

    @FindBy(name = "passwd")
    public static WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    public static WebElement btnSignIn;

    @FindBy(xpath = "//a[@class='logout']")
    public static WebElement lnkSingout;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/");

        PageFactory.initElements(driver, SimplePageFactoryTest.class);
        lnkSignin.click();
        Thread.sleep(5000);
        txtEmail.sendKeys("karthik@axone-tech.uk");
        txtPassword.sendKeys("password");
        btnSignIn.click();
        lnkSingout.click();
        driver.quit();

    }

}
