package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;



    private By addToCartSelector = By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']");
    private By refuseAppleCareSelector = By.cssSelector("[class=a-button a-button-grouplast a-button-base]");
    private By openCartSelector = By.cssSelector("[aria-labelledby=submit.add-to-cart-announce]");

public ProductPage (WebDriver driver) {
    this.driver=driver;

}
 public void addtoCart (){
     WebElement ajouterAuPanierButton = driver.findElement(addToCartSelector);
     ajouterAuPanierButton.click();
 }

 public void RefuseAppleCare (){
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     WebElement nonmerciButton = wait.until(ExpectedConditions.elementToBeClickable(refuseAppleCareSelector));
     nonmerciButton.click();
 }

 public void openCart() {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     WebElement ouvrirpanierButton = wait.until(ExpectedConditions.elementToBeClickable(openCartSelector));
     ouvrirpanierButton.click();
 }

}
