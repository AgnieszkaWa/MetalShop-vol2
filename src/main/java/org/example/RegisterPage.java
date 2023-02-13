package org.example;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    @FindBy(id = "user_login")
    private WebElement userLoginInput;

    @FindBy(id = "user_email")
    private WebElement userEmailInput;

    @FindBy(id = "user_pass")
    private WebElement userPasswordInput;

    @FindBy(id = "user_confirm_password")
    private WebElement userConfirmationPassInput;

    @FindBy(css = ".ur-submit-button")
    private WebElement submitButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegisterPage register() {
        Faker faker = new Faker();
        String registerUsername = faker.name().username();
        String email = registerUsername + faker.random().nextInt(10000) + "@wp.pl";
        userEmailInput.sendKeys(email);
        userLoginInput.sendKeys(registerUsername);
        userPasswordInput.sendKeys("gitara123");
        userConfirmationPassInput.sendKeys("gitara123");
        submitButton.click();
        return new RegisterPage(driver);
    }

}
