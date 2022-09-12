package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingPage {

    private WebDriver driver;

    private By ouvrirMenuRayonSelector = By.cssSelector("[class=mainbar__nav-toggle-label]");
    private By listeSportsLoisirsEtMobiliteSelector = By.cssSelector("[id=data-menu-level-1_promotions]");
    private By listeMeilleursVentesSelector = By.cssSelector("[class=nav-item nav-item--see-all]");
    final int TIMEOUT_COOKIE = 5;



    public ShoppingPage(WebDriver driver) {
        this.driver=driver;
    }

    public void ouvrirMenuRayon () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement ouvrirMenuRayon = wait.until(ExpectedConditions.visibilityOfElementLocated(ouvrirMenuRayonSelector));
        ouvrirMenuRayon.click();
    }

    public void ouvrirSportetLoisirs () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
         wait.until(ExpectedConditions.elementToBeClickable(listeSportsLoisirsEtMobiliteSelector));
        List<WebElement> productList = driver.findElements(listeSportsLoisirsEtMobiliteSelector);
        productList.get(3).click();
}

public void MeilleursVentes () {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
    wait.until(ExpectedConditions.elementToBeClickable(listeMeilleursVentesSelector));
    List<WebElement> productList = driver.findElements(listeMeilleursVentesSelector);
    productList.get(1).click();
}



}
