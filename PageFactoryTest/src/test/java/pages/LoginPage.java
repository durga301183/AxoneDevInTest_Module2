package pages;

import base.BasePage;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    public static WebElement txtEmail;

    @FindBy(name = "passwd")
    public static WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    public static WebElement btnSignIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountsPage dologinnavigateToMyAccPage (final String emailAddress, final String password){

        txtEmail.sendKeys(emailAddress);
        txtPassword.sendKeys(password);
        btnSignIn.click();
        return PageFactory.initElements(driver, MyAccountsPage.class);
    }



}
