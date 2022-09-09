import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ThepageObject {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    //nom de la classe.non de la classe à l'interieur de la grande classe();
    @Test
    public void testPO() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie();
        homePage.searchElement("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        SearchResultPage SearchResults = new SearchResultPage(driver);
        SearchResults.SearchResults();

        ProductPage productPage = new ProductPage(driver);
        productPage.addtoCart();
        productPage.RefuseAppleCare();
        productPage.openCart();



    }
    @Test
    public void test() {

        HomePage homePage = new HomePage(driver);
        WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton);
        actions.perform();
    }
}