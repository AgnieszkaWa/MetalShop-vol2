package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "//a[text() = 'Softie Metal Shop']")
    private WebElement logo;

    @FindBy(linkText = "Moje konto")
    private WebElement myAccount;

    @FindBy(linkText = "register")
    private WebElement register;

    @FindBy(linkText = "Kontakt")
    private WebElement contact;

    @FindBy(css = ".cart-contents")
    private WebElement cart;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToMyAccount() {

        myAccount.click();
        return new LoginPage(driver);

    }

    public RegisterPage goToRegisterPage() {
        register.click();
        return new RegisterPage(driver);

    }

    public ContactPage goToContact() {
        contact.click();
        return new ContactPage(driver);
    }

    public CartPage goToCart() {
        cart.click();
        return new CartPage(driver);


    }


}


