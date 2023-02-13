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

public class CartTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

    }

    @Test
    public void shoppingCart() {

        HomePage homePage = new HomePage(driver);
        homePage.goToCart();
        String cart = driver.findElement(By.cssSelector(".cart-empty")).getText();
        Assertions.assertEquals("Twój koszyk aktualnie jest pusty.", cart);
        driver.findElement(By.linkText("Wróć do sklepu")).click();
        driver.findElement(By.cssSelector(".post-24")).click();
        driver.findElement(By.name("add-to-cart")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement addToCart = driver.findElement(By.cssSelector(".woocommerce-message"));
        Assertions.assertTrue(addToCart.isEnabled());

    }

    @Test
    public void removingProductFromCart() {
        driver.findElement(By.cssSelector(".post-24")).click();
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("add-to-cart")));
        driver.findElement(By.name("add-to-cart")).click();
        driver.findElement(By.cssSelector(".wc-forward")).click();
        driver.findElement(By.cssSelector(".remove")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message")));
        String deleted = driver.findElement(By.cssSelector(".woocommerce-message")).getText();
        Assertions.assertTrue(deleted.contains("Usunięto: „Srebrna moneta 5g - UK 1980"));

    }
}