import org.example.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

    }

    @Test
    public void goToContact() {
        HomePage homePage = new HomePage(driver);
        homePage.goToContact();
        WebElement title = driver.findElement(By.cssSelector(".entry-title"));
        Assertions.assertEquals("Kontakt", title.getText());
    }

    @Test
    public void sendMessage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToContact().sendingMessage();
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".wpcf7-response-output")));
        WebElement sendMessage = driver.findElement(By.cssSelector(".wpcf7-response-output"));
        Assertions.assertTrue(sendMessage.isEnabled());


    }

}
