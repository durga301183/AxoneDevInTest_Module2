package uk.axone.advancedtestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPracticalUsageOfParameterization {


    @Parameters({"browser"})
    @Test

    public void checkoutTest( String param){
        System.out.println("Executing browser tests: " + param);
    }













}
