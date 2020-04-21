
      Feature: Validating sign in Functionality

        @Smoke
        Scenario:
          Given user navigates to "http://seleniumpractice.axone-tech.uk/index.php"
          When user clicks on sign-in link
          And  user enters the mail as "durga.makkapati@gmail.com"
          And  user enters the code as "password"
          When  user clicks on the Signin button
          Then  user should see the Header as "MY ACCOUNT"
          When  user click on logout
          Then  user should see the Header page with  "Sign in"
          And   user quits the browser
