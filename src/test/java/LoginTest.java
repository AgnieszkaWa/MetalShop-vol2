import org.example.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");

    }

    @Test
    public void sucessLogIn() {
        HomePage homePage = new HomePage(driver);
        homePage.goToMyAccount().login();
        String hello = driver.findElement(By.linkText("Wyloguj się")).getText();
        Assertions.assertEquals("Wyloguj się", hello);
    }

    @Test
    public void emptyPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.goToMyAccount().loginWithoutPassword();
        String error = driver.findElement(By.cssSelector(".woocommerce-error")).getText();
        Assertions.assertEquals("Błąd: pole hasła jest puste.", error);

    }

    @Test
    public void emptyUsername() {
        HomePage homePage = new HomePage(driver);
        homePage.goToMyAccount().loginWithoutUsername();
        String error = driver.findElement(By.cssSelector(".woocommerce-error")).getText();
        Assertions.assertEquals("Błąd: Nazwa użytkownika jest wymagana.", error);

    }
}
