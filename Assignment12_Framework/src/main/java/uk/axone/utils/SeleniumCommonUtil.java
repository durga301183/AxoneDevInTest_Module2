package uk.axone.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumCommonUtil {


    public void navigateToUrl(final WebDriver driver, final String urlToNavigate) {
        driver.navigate().to(urlToNavigate);
    }

    // clicking element
    public void clickElement(final WebElement element) {
        // 1. to identify the element
        // 2. to click on the element
        if (isElementEnabled(element)) {
            element.click();
        }
    }

    // type values, etc.
    public void typeValues(final WebElement element, final String valueToType) {
        // 1.identify the element
        // 2.type the value
        element.sendKeys(valueToType);
    }


    // validation methods
    public boolean isElementDisplayed(final WebElement elementToCheck) {
        return elementToCheck.isDisplayed();
    }

    public boolean isElementEnabled(final WebElement elementToCheck) {
        return elementToCheck.isEnabled();
    }

}
