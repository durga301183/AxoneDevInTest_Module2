package uk.axone.bdd.testng;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



    @CucumberOptions(features = "src/test/resources/Featurefiles",
                      glue ="uk.axone.stepdefinitions",
                      tags = {"@Smoke"})

    public class Runner extends AbstractTestNGCucumberTests {
    }


