package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'My personal information')]")
    private WebElement lnkMyPersonalInformation;

    public MyAccountsPage(WebDriver driver) {
        super(driver);
    }

    public IdentityPage navigateToIdentityPage(){
        lnkMyPersonalInformation.click();
        return PageFactory.initElements(driver, IdentityPage.class);
    }


    }

