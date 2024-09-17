package POM;

import StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Login {

    By usernameField = By.xpath("//input[@name='username']");
    By passwordField = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@type='submit']");


    public void enterUserName(String username) {

        WebElement emailInput = Hooks.driver.findElement(usernameField);
        emailInput.sendKeys(username);
    }
    public void enterPassword(String password) {

        WebElement passwordInput = Hooks.driver.findElement(passwordField);
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton() {
        Hooks.driver.findElement(loginButton).click();
    }


}