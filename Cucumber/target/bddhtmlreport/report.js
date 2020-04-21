$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Featurefiles/sign-in.feature");
formatter.feature({
  "name": "Validating sign in Functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.scenarioOutline({
  "name": "",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I enter the e-mail",
  "keyword": "Given "
});
formatter.step({
  "name": "I enter the Password",
  "keyword": "And "
});
formatter.step({
  "name": "I click on the Signin button",
  "keyword": "When "
});
formatter.step({
  "name": "I should see the Header as MyAccount",
  "keyword": "Then "
});
formatter.step({
  "name": "I click on logout",
  "keyword": "When "
});
formatter.step({
  "name": "I should see the Header with signin link appearing",
  "keyword": "Then "
});
formatter.step({
  "name": "Browser quits",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "e-mail",
        "Password"
      ]
    },
    {
      "cells": [
        "durga.makkapati@gmail.com",
        "password"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I enter the URL as \"http://seleniumpractice.axone-tech.uk/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.Stepdef.iEnterTheURLAs(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Sign-in Button",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.Stepdef.iClickOnSignInButton()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "I enter the e-mail",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.Stepdef.iEnterTheEmail(java.lang.String)"
});
formatter.result({
  "error_message": "io.cucumber.core.exception.CucumberException: Step [I enter the e-mail] is defined with 1 parameters at \u0027StepDefinition.Stepdef.iEnterTheEmail(java.lang.String)\u0027.\nHowever, the gherkin step has 0 arguments.\nStep text: I enter the e-mail\r\n\tat io.cucumber.core.runner.PickleStepDefinitionMatch.arityMismatch(PickleStepDefinitionMatch.java:134)\r\n\tat io.cucumber.core.runner.PickleStepDefinitionMatch.runStep(PickleStepDefinitionMatch.java:42)\r\n\tat io.cucumber.core.runner.TestStep.executeStep(TestStep.java:64)\r\n\tat io.cucumber.core.runner.TestStep.run(TestStep.java:49)\r\n\tat io.cucumber.core.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\r\n\tat io.cucumber.core.runner.TestCase.run(TestCase.java:51)\r\n\tat io.cucumber.core.runner.Runner.runPickle(Runner.java:67)\r\n\tat io.cucumber.testng.TestNGCucumberRunner.runScenario(TestNGCucumberRunner.java:124)\r\n\tat io.cucumber.testng.AbstractTestNGCucumberTests.runScenario(AbstractTestNGCucumberTests.java:29)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:134)\r\n\tat org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:597)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:173)\r\n\tat org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)\r\n\tat org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:816)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:146)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)\r\n\tat java.util.ArrayList.forEach(ArrayList.java:1257)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:766)\r\n\tat org.testng.TestRunner.run(TestRunner.java:587)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:384)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:378)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:337)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:286)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1187)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1109)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1039)\r\n\tat org.testng.TestNG.run(TestNG.java:1007)\r\n\tat com.intellij.rt.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:66)\r\n\tat com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:110)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I enter the Password",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.Stepdef.iEnterThePassword(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on the Signin button",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.Stepdef.iClickOnTheSigninButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I should see the Header as MyAccount",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.Stepdef.iShouldSeeTheHeaderAsMyAccount(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on logout",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.Stepdef.iClickOnLogout()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I should see the Header with signin link appearing",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.Stepdef.iShouldSeeTheHeaderWithSigninLinkAppearing(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Browser quits",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.Stepdef.browserQuits()"
});
formatter.result({
  "status": "skipped"
});
});