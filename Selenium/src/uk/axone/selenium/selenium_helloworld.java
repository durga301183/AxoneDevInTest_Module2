package uk.axone.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class selenium_helloworld {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/G S Sastry/Selenium drivers/chromedriver_win32/chromedriver.exe");
// any object of system class , all methods with in system, class are static in nature
        //set property is also static thats y we use system.setproperty
        // idealised browser
        //this is so far with 7 libraries donloaded is  a client component. We have to also install the server compoent

        // ideally if we run it should launch the chrome browser but it gives an error saying exception in thread and
        //illegal exception i.e path should be set.expecting server component
        /*
        The ChromeDriver consists of three separate pieces. There is the browser itself ("chrome"),
         the language bindings provided by the Selenium project ("the driver") and an executable downloaded from the
          Chromium project which acts as a bridge between "chrome" and the "driver".
          This executable is called "chromedriver", but we'll try and refer to it as the "server"
          in this page to reduce confusion.

*/
        ChromeDriver cd = new ChromeDriver();
        Thread.sleep(5000);
        cd.quit();

        System.setProperty("webdriver.gecko.driver", "C:/Users/G S Sastry/Selenium drivers/ffdriver_win64/geckodriver.exe");
             FirefoxDriver ff =new FirefoxDriver();
             Thread.sleep(3000);
             ff.quit();
    }
}