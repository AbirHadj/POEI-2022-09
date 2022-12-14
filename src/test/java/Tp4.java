import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Tp4 {
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

    @Test
    public void testmeilleurproduit() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        buttonCookie.click();

        WebElement toutesButton = driver.findElement(By.cssSelector("[id=nav-hamburger-menu]"));
        toutesButton.click();

        //WebElement meilleuresventes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='hmenu-item'][1]")));
        //meilleuresventes.click(); //ceci est l'ancienne methode par selectors

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item")));

        List<WebElement> menuList = driver.findElements(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item"));
        menuList.get(0).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.a-carousel-card")));
        List<WebElement> productList = driver.findElements(By.cssSelector("li.a-carousel-card"));
        productList.get(8).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
/*@Test

    WebElement
    Assert.assertTrue(logo.isDisplayed();
    Assert.assertEquals(logo.isDisplayed));

    Assert.assertTrue(logo.isDisplayed();
    Assert.assertEquals (toutesMenu.getText(), "Meilleurs ventes");
    Assert.assertEquals (amazonBasics.isDsplayed()); */
/*@Test
public void testAsserts() {
    // Arrange
    final String expectedToutes = "Toutes";
    final String expectedMeilleuresVentes = "Meilleures ventes";
    final String expectedAmazonBasics = "Amazon Basics";
    final String expectedVentesLivres = "Meilleures ventes dans Livres";

    // Act
    WebElement logo = driver.findElement(By.cssSelector("#nav-logo"));
    WebElement barreRecherche = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
    WebElement toutesMenu = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
    WebElement meilleuresVentes = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_bestsellers]"));
    WebElement amazonBasics = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_amazonbasics]"));
    WebElement meilleuresVentesLivres = driver.findElement(By.cssSelector("[data-csa-c-slot-id=desktop-5] h2.as-title-block-left"));

    // Asserts
    Assert.assertTrue(logo.isDisplayed(), "The Amazon Logo is not displayed");
    Assert.assertTrue(barreRecherche.isDisplayed());
    Assert.assertEquals(toutesMenu.getText(), expectedToutes);

    Assert.assertTrue(meilleuresVentes.isDisplayed());
    Assert.assertEquals(meilleuresVentes.getText(), expectedMeilleuresVentes, "The button Meilleures Ventes is not correct");

    Assert.assertTrue(amazonBasics.isDisplayed());
    Assert.assertEquals(amazonBasics.getText(), expectedAmazonBasics);

    Assert.assertTrue(meilleuresVentesLivres.isDisplayed());
    Assert.assertEquals(meilleuresVentesLivres.getText(), expectedVentesLivres);
}



 */