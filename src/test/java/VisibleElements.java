import org.example.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisibleElements {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

    }

    @Test
    public void logoAndSearchField() {
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(driver.findElement(By.linkText("Softie Metal Shop")).isEnabled());
        Assertions.assertTrue(driver.findElement(By.cssSelector(".search-field")).isEnabled());
        homePage.goToMyAccount();
        Assertions.assertTrue(driver.findElement(By.linkText("Softie Metal Shop")).isEnabled());
        Assertions.assertTrue(driver.findElement(By.cssSelector(".search-field")).isEnabled());
    }


}
