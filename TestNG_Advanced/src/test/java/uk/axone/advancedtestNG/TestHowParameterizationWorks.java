package uk.axone.advancedtestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 *
 * Step1. specify the exact parameters as specified in the testng.xml
 *
 *    executing test using multiple test data
 *    step 2: access the parameters using the method params
 */
public class TestHowParameterizationWorks {
    @Parameters({"username", "password"})
    @Test
    public void loginTest(String uName, String password){
        System.out.println("My username: " + uName +  " My password is: " + password);

    }
}
