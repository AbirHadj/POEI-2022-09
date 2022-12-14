package amazon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private By acceptCookieSelector = By.cssSelector("[data-cel-widget=sp-cc-accept]");
    private  By searchElementsSelector  = By.cssSelector("[aria-label=Rechercher]");
    private  By loupeButtonSelector  = By.cssSelector("[type=submit]");

    final int TIMEOUT_COOKIE = 5;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
        buttonCookie.click();
    }

    //survoler la souris
    public void searchElement (String keyword) {
        WebElement searchBar = driver.findElement(searchElementsSelector);
        searchBar. sendKeys(keyword);

        WebElement loupeButton = driver.findElement(loupeButtonSelector);
        loupeButton.click();
    }


}

