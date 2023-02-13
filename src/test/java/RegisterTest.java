import org.example.HomePage;
import org.example.RegisterPage;
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

public class RegisterTest {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

    }

    @Test
    public void registerSuccess() {
        HomePage homePage = new HomePage(driver);
        homePage.goToRegisterPage().register();
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".user-registration-message")));
        WebElement error = driver.findElement(By.cssSelector(".user-registration-message"));
        Assertions.assertEquals("User successfully registered.", error.getText());
    }
}
