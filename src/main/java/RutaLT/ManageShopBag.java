package RutaLT;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ManageShopBag extends BasePage{


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
    private static final By secondProductPrise = By.cssSelector("tr.woocommerce-cart-form__cart-item:nth-child(2)" +
            " > td:nth-child(6) > span:nth-child(1)");
    private static final By inTotal = By.cssSelector(".order-total > td:nth-child(2) > strong:nth-child(1) " +
            "> span:nth-child(1)");


//    public ManageShopBag() {
//        super(driver, firefoxDriver);
//    }
    public ManageShopBag() {
        super(driver);
    }


    public static void manageShopBag() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(35))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        try {
            WebElement shoppingBagElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingBag));
            shoppingBagElement.click();
            Thread.sleep(5000);

            WebElement removeProductElement = wait.until(ExpectedConditions.elementToBeClickable(removeProduct3));
            removeProductElement.click();
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Remove Button not found");
        }
        try {
            WebElement updateShoppingBagElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (updateshoppingBag));
            updateShoppingBagElement.click();
            Thread.sleep(6000);

            WebElement increaseElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(increase));
            increaseElement.sendKeys(Keys.ENTER);
            Thread.sleep(6000);

            WebElement reduceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(reduce));
            reduceElement.sendKeys(Keys.ENTER);
            Thread.sleep(4000);

            WebElement updateShoppingBagElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (updateshoppingBag));
            updateShoppingBagElement2.click();
            Thread.sleep(4000);


        } catch (Exception m) {
            System.out.println("Increase Button Not found");
        }
            String expectedUpdateText = "Krepšelis atnaujintas";
            String actualUpdateText = driver.findElement(updateMessageText).getText();

        if (actualUpdateText.contains(expectedUpdateText)) {
            System.out.println("The Update Text message is correct!");
        } else {
            System.out.println("The Update Text message is INCORECT!");
        }
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ManageShopBag\\\\UpdateShopBag\\\\ScreenshotFilesreenshot.png" + fileName));
        }catch (Exception k){
            System.out.println("Screenshots disabled.");
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            // Imam reikšmę ir atimam paskutinį simbolį "$".
            String firstProductPriceText = driver.findElement(firstProductPrice).getText();
            String secondProductPriceText = driver.findElement(secondProductPrise).getText();
            firstProductPriceText = firstProductPriceText.substring(0, firstProductPriceText.length() - 1);
            secondProductPriceText = secondProductPriceText.substring(0, secondProductPriceText.length() - 1);

            //Konvertuojam String i double ir sudedam
            double firstProductPrice = Double.parseDouble(firstProductPriceText);
            double secondProductPrice = Double.parseDouble(secondProductPriceText);
            double totalSum = firstProductPrice + secondProductPrice;

            // Imam Sumos reikšmę ir atimam paskutinį simbolį "$".
            String totalText = driver.findElement(inTotal).getText();
            totalText = totalText.substring(0, totalText.length() - 1);

            //Konvertuojam Sumos String i double ir palyginam
            double total = Double.parseDouble(totalText);
            if (total == totalSum) {
                System.out.println("The calculated sum is correct!");
            } else {
                System.out.println("The calculated sum is INCORECT!");
            }
        } catch (Exception m) {
            System.out.println("Price not in display");
        }
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ManageShopBag\\\\AssertPrice\\\\ScreenshotFilesreenshot.png" + fileName));
        }catch (Exception k){
            System.out.println("Screenshots disabled.");
        }

    }
}
