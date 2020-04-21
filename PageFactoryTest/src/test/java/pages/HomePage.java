package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement lnkSignin;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickSigninLinkNavigateToLoginPage(){
        lnkSignin.click();
        return PageFactory.initElements(driver, LoginPage.class);

    }
}
