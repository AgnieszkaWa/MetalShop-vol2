package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(css = ".cart-empty")
    private WebElement emptyCart;

    @FindBy(linkText = "Wróć do sklepu")
    private WebElement goBackToShop;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


}
