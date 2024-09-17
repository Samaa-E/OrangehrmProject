package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class Login {

    POM.Login login = new POM.Login();

    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {

        Hooks.driver.navigate().to(url);
    }


    @And("User enters a valid username {string} and password {string}")
    public void userEntersAValidUsernameAndPassword(String arg0, String arg1) {
        login.enterUserName(arg0);
        login.enterPassword(arg1);
        login.clickLoginButton();
    }


}

