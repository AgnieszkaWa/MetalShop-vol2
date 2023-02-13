package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    WebDriver driver;

    @FindBy(name = "your-name")
    private WebElement nameInput;

    @FindBy(name = "your-email")
    private WebElement emailInput;

    @FindBy(name = "your-message")
    private WebElement messageInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement sendButton;


    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendingMessage() {

        nameInput.sendKeys("Agnieszka Wacholc");
        emailInput.sendKeys("aga@wp.pl");
        messageInput.sendKeys("Dzień dobry");
        sendButton.click();

    }



}
