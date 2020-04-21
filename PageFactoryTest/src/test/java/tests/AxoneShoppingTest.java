package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class AxoneShoppingTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void shoppingCartTest() throws InterruptedException {
        LaunchPage launch = PageFactory.initElements(driver, LaunchPage.class);
        HomePage home = launch.navigateToHomePage("http://seleniumpractice.axone-tech.uk/");
        LoginPage login = home.clickSigninLinkNavigateToLoginPage();
        MyAccountsPage accounts = login.doLoginNavigteToMyAccPage("karthik@axone-tech.uk", "password");
        IdentityPage identity = accounts.navigateToIdentityPage();
        identity.TopMenuPage.Logout();
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
