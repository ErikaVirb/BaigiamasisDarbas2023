package RutaLT;

import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static com.google.common.util.concurrent.Futures.withTimeout;
import static org.junit.Assert.assertEquals;

public class BandymaiIstrinti extends BasePage{


    // Tvarkomės su pirkiniu krepšeliu:
    private static final By shoppingBag = By.cssSelector("a[class='header-cart-link is-small']");
    private static final By removeProduct3 = By.cssSelector(".remove[data-gtm4wp_product_id='33835']");
    private static final By reduce = By.xpath("(//input[@value='-'])[2]");
    private static final By increase = By.xpath("(//input[@value='+'])[1]");
    private static final By updateshoppingBag = By.cssSelector("button.button:nth-child(2)");
    private static final By updateMessageText = By.cssSelector(".woocommerce-notices-wrapper");

    // Prekių listo tikrinimas:
    private static final By firstProductPrice = By.cssSelector("tr.woocommerce-cart-form__cart-item:nth-child(1) " +
            "> td:nth-child(6) > span:nth-child(1)");
    private static final By secondProductPrice = By.cssSelector("tr.woocommerce-cart-form__cart-item:nth-child(2)" +
            " > td:nth-child(6) > span:nth-child(1)");
    private static final By inTotal = By.cssSelector(".order-total > td:nth-child(2) > strong:nth-child(1) " +
            "> span:nth-child(1)");

    public BandymaiIstrinti() {
        super(driver);
    }

    public void manageShopBag() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(35))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        try {
            WebElement shoppingBagElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingBag));
            shoppingBagElement.click();

            WebElement removeProductElement = wait.until(ExpectedConditions.elementToBeClickable(removeProduct3));
            removeProductElement.click();
        } catch (Exception e) {
            System.out.println("Remove Button not found");
        }

        try {
            WebElement updateShoppingBagElement = wait.until(ExpectedConditions.visibilityOfElementLocated(updateshoppingBag));
            updateShoppingBagElement.click();
            Thread.sleep(5000);

            WebElement increaseElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(increase));
            increaseElement.sendKeys(Keys.ENTER);
            Thread.sleep(5000);

            WebElement reduceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(reduce));
            reduceElement.sendKeys(Keys.ENTER);

            WebElement updateShoppingBagElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(updateshoppingBag));
            updateShoppingBagElement2.click();
        } catch (Exception m) {
            System.out.println("Increase Button Not found");
        }

        String expectedUpdateText = "Krepšelis atnaujintas";
        String actualUpdateText = driver.findElement(updateMessageText).getText();

        if (actualUpdateText.contains(expectedUpdateText)) {
            System.out.println("The Update Text message is correct!");
        } else {
            System.out.println("The Update Text message is INCORRECT!");
        }

        try {
            String firstProductPriceText = driver.findElement(firstProductPrice).getText();
            String secondProductPriceText = driver.findElement(secondProductPrice).getText();
            firstProductPriceText = firstProductPriceText.substring(0, firstProductPriceText.length() - 1);
            secondProductPriceText = secondProductPriceText.substring(0, secondProductPriceText.length() - 1);

            double firstProductPrice = Double.parseDouble(firstProductPriceText);
            double secondProductPrice = Double.parseDouble(secondProductPriceText);
            double totalSum = firstProductPrice + secondProductPrice;

            String totalText = driver.findElement(inTotal).getText();
            totalText = totalText.substring(0, totalText.length() - 1);

            double total = Double.parseDouble(totalText);
            if (total == totalSum) {
                System.out.println("The calculated sum is correct!");
            } else {
                System.out.println("The calculated sum is incorrect.");
            }
        } catch (Exception m) {
            System.out.println("Price not displayed");
        }
    }

    }

