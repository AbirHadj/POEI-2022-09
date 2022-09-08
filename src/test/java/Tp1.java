import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class Tp1 {

    @Test

    public void test1() {
        System.out.println("test abouuuuzaa" +
                "");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.leboncoin.fr/");
        driver.get("https://www.google.fr/");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

    @Test
    public void testAmazon () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("playstation5");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }



}