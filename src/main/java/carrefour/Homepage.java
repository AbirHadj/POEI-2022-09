package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class Homepage {

    private WebDriver driver;
    private By fermerCookieSelector = By.cssSelector("[id=onetrust-reject-all-handler]");
    private  By ouvrirpagesports  = By.cssSelector("[id=header-tab-non-food]");

    final int TIMEOUT_COOKIE = 5;

    public Homepage (WebDriver driver){
        this.driver=driver;
        }

    public void FermerCookie () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(fermerCookieSelector));
        buttonCookie.click();
    }
    public void Ouvrirpagesports () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement pagesport = wait.until(ExpectedConditions.elementToBeClickable(ouvrirpagesports));
        pagesport.click();
    }

    }

