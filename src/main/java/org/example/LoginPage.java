package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement signInButton;

    String username = "proba123@wp.pl";
    String password = "1234@!";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();

    }

    public void loginWithoutPassword() {
        usernameInput.sendKeys(username);
        signInButton.click();
    }

    public void loginWithoutUsername() {
        passwordInput.sendKeys(password);
        signInButton.click();
    }


}
