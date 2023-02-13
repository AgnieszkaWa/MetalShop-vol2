import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ProductsOnSaleTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

    }

    @Test
    public void sale() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".onsale"));

        for (int i = 0; i < elements.size(); i++) {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.findElements(By.cssSelector(".onsale")).get(i).click();
            WebElement addToCart = driver.findElement(By.name("add-to-cart"));
            addToCart.click();
            WebElement backToSklep = driver.findElement(By.linkText("Softie Metal Shop"));
            backToSklep.click();
        }
        driver.findElement(By.cssSelector(".cart-contents")).click();
        WebElement amount = driver.findElement(By.cssSelector(".woocommerce-Price-amount"));
        Assertions.assertTrue(amount.isEnabled());


    }

}
