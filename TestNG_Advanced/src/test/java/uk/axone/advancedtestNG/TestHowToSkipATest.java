package uk.axone.advancedtestNG;

import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 *
 * ways to skip a test
 * 1. adding @Ignore annotation. PS: adding this at the class level will disable all the test methods.
 * 2. using enabled=false.
 * 3. using throw new SkipException()
 */

public class TestHowToSkipATest {

    @Test
    public void doLoginTest(){
        System.out.println("Login Test");
    }

    @Test
    public void xLogoutTest(){
        System.out.println("Logout Test");
    }
  // @Ignore
    //@Test(enabled = false)
    @Test
    public void verifyHomePageTest(){
        System.out.println("Begin - Home page Test");
       // if(!DataAvailability)
        throw new SkipException("Data still unavailable");


    }

    @Test
    public void verifyLandingPageTest(){
        System.out.println("Landingpage Test");
    }


}
