import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class Tp5 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver= new ChromeDriver();
        driver.get ("https://www.amazon.fr/") ;
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    @Test
    public void testlisteproduitsamazon () {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Fermer cookies
        WebElement buttonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=sp-cc-rejectall-link]")));
        buttonCookie.click();

        // Chercher: Apple iPhone 13 Pro Max (256 Go) - Vert Alpin

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");

        WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
        loupeButton.click();

        // Ouvrir premier resultat METHODE 1 SELECTOR
        WebElement premierResultat = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=search_result_2]")));
        premierResultat.click();
       // Ouvrir premier resultat METHODE 2 LISTE
       /* wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.data-cel-widget=search_result_2")));
        List<WebElement> productList = driver.findElements(By.cssSelector("li.data-cel-widget=search_result_2"));
        productList.get(0).click();
*/

        //Ajouter au panier
        WebElement ajouterAuPanierButton = driver.findElement(By.cssSelector("[aria-labelledby=submit.add-to-cart-announce]"));
        ajouterAuPanierButton.click();


        //Selectionner Non, Merci pour l'apple care
        WebElement nonmerciButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class=a-button a-button-grouplast a-button-base]")));
        nonmerciButton.click();


        //Ouvrir le panier
        WebElement ouvrirpanierButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-labelledby=submit.add-to-cart-announce]")));
      ouvrirpanierButton.click();


        //Changer quantite a 2

        WebElement dropdown = driver.findElement(By.cssSelector("class=a-native-dropdown a-declarative sc-update-quantity-select"));
        Select categoriesSelect =new Select(dropdown);
        categoriesSelect.selectByValue("value=2");


        //verfication/Verifier titre du produit: Apple iPhone 13 Pro Max (256 Go) - Vert Alpin
        //Verifier sous total (2 articles)
        // Verifier taille 256Go
        //- Verifier Couleur vert alpin
        //- Verifier configuration sans appleCare+


        // Arrange
        final String expectedTitreProduct = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
        final int expectedsousTotal = 2;
        final String expectedTaille = "256Go";
        final String expectedConfiguration = "Sans AppleCare+";



        // Act
        WebElement TitreProduct = driver.findElement(By.cssSelector("[class=a-truncate-full a-offscreen]"));
        WebElement sousTotal = driver.findElement(By.cssSelector("[class=a-dropdown-prompt]"));
        WebElement Taille = driver.findElement(By.cssSelector("[class=a-size-small a-text-bold]"));
        WebElement Configuration = driver.findElement(By.cssSelector("[class=a-dropdown-prompt]"));



        // Asserts








    }

/*

@Test
  public void testAmazon() {
    final String expectedTaille  = "256Go";
    final String expectedCouleur  = "Vert alpin";
    final String expectedConfiguration  = "Sans AppleCare+";
    final String expectedTotale  = "Sous-total (2 articles):";
    final String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
    buttonCookie.click();

    WebElement searchBar = driver.findElement(By.cssSelector("[aria-label=Rechercher]"));
    searchBar.sendKeys(searchKeyword);

    WebElement loupeButton = driver.findElement(By.cssSelector("[type=submit]"));
    loupeButton.click();

    List<WebElement> resultatList = driver.findElements(By.cssSelector("img.s-image"));
    resultatList.get(0).click();

    WebElement ajouterAuPanierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']")));
    ajouterAuPanierButton.click();

    WebElement nonmerci = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']")));
    nonmerci.click();

    WebElement panierButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#attach-sidesheet-view-cart-button")));
    panierButton.click();

    WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
    Select quantiteDropdown = new Select(dropdown);
    quantiteDropdown.selectByIndex(2);

    List<WebElement> informations = driver.findElements(By.cssSelector(".a-text-bold + span"));
    WebElement taille = informations.get(0);
    WebElement couleur = informations.get(1);
    WebElement configuration = informations.get(2);
    WebElement soustotale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sc-subtotal-label-activecart")));

    Assert.assertEquals(taille.getText(),expectedTaille,"Taille pas bon");
    Assert.assertEquals(couleur.getText(),expectedCouleur ,"couleur pas bon");
    Assert.assertEquals(configuration.getText(),expectedConfiguration ,"config pas bon");
    Assert.assertEquals(soustotale.getText(),expectedTotale,"sous total pa bon");
  }
 */

}

