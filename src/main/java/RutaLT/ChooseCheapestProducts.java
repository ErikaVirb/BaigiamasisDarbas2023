package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class ChooseCheapestProducts extends BasePage{


    private static final By listOfProducts = By.className("shop-container");
    private static final By eShopButton = By.cssSelector("#wide-nav > div > div > ul > li.html.header-button-1 > " +
            "div > a");

    public ChooseCheapestProducts() {
        super(driver);
    }
    public static void list() throws IOException {
        WebDriverWait eShopButtonWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement eShopButton1 = eShopButtonWait.until(ExpectedConditions.visibilityOfElementLocated(eShopButton));
        eShopButton1.click();
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0, 100)");

        List<WebElement> linkElements = driver.findElements(listOfProducts);
        for (WebElement title : linkElements) {
            String myTitle = title.getText();
            System.out.println(myTitle);
        }
        driver.quit();

    }
}
