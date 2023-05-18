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


        // ĮSPĖJIMAS: BE KLASĖS "ShoppingBag" NEVEIKS. Pradžioje teste turi praeiti "ShoppingBag" ir tik po to ši klasė.

        // Apsibrėžiam wait'a naudojimui visam metodui.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(35))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        try {
            // Spaudžiame įkoną "Pirkinių Krepšelis"
            WebElement shoppingBagElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingBag));
            shoppingBagElement.click();
            Thread.sleep(5000);
            // Pašaliname trečią prekę
            WebElement removeProductElement = wait.until(ExpectedConditions.elementToBeClickable(removeProduct3));
            removeProductElement.click();
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Remove Button not found");
        }
        try {
            // Spaudžiame mygtuką "Atnaujinti krepšelį"
            WebElement updateShoppingBagElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (updateshoppingBag));
            updateShoppingBagElement.click();
            Thread.sleep(6000);
            // Padidiname pirmosios prekės kiekį iki 3 vnt.
            WebElement increaseElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(increase));
            increaseElement.sendKeys(Keys.ENTER);
            Thread.sleep(6000);
            // Sumažiname antrosios prekės kiekį iki 1 vnt.
            WebElement reduceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(reduce));
            reduceElement.sendKeys(Keys.ENTER);
            Thread.sleep(4000);
            // Atnaujiname prekių krepšelį spausdami mygtuką: "Atnaujinti krepšelį"
            WebElement updateShoppingBagElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (updateshoppingBag));
            updateShoppingBagElement2.click();
            Thread.sleep(4000);


        } catch (Exception m) {
            System.out.println("Increase Button Not found");
        }
            // Nusistatom Informacinio pranešimo iškomus žodžius
            String expectedUpdateText = "Krepšelis atnaujintas";
            // Nusiskaitom Informacinio pranešimo textą iš web page
            String actualUpdateText = driver.findElement(updateMessageText).getText();

        // Atliekame tekstų palyginimą ir išvedam į consolę ar nustatyta reikšmė yra dalis Informacinio teksto
        if (actualUpdateText.contains(expectedUpdateText)) {
            System.out.println("The Update Text message is correct!");
        } else {
            System.out.println("The Update Text message is INCORECT!");
        }
        try{
            // Darome sceenshot'us:
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
            // Nusiskaitome Pirmosios prekės kainą
            String firstProductPriceText = driver.findElement(firstProductPrice).getText();
            // Nusiskaitome Antrosios prekės kainą
            String secondProductPriceText = driver.findElement(secondProductPrise).getText();
            // Imam visą nusiskaitytą reikšmę (šiuo atveju kaip pvz. turiu tokį formatą "10.12 €") ir atimu paskutinį
            // simbolį/reikšmę
            firstProductPriceText = firstProductPriceText.substring(0, firstProductPriceText.length() - 1);
            secondProductPriceText = secondProductPriceText.substring(0, secondProductPriceText.length() - 1);

            //Konvertuojam String i double ir sudedam
            double firstProductPrice = Double.parseDouble(firstProductPriceText);
            double secondProductPrice = Double.parseDouble(secondProductPriceText);
            double totalSum = firstProductPrice + secondProductPrice;

            // Nusiskaitom Sumos reikšmę
            String totalText = driver.findElement(inTotal).getText();
            // atimam paskutinį simbolį "€".
            totalText = totalText.substring(0, totalText.length() - 1);

            //Konvertuojam Sumos String i double
            double total = Double.parseDouble(totalText);
            // Lyginam ar sumos yra lygios/tokios pačios ir išvedam atsakymą į konsolę
            if (total == totalSum) {
                System.out.println("The calculated sum is correct!");
            } else {
                System.out.println("The calculated sum is INCORECT!");
            }
        } catch (Exception m) {
            System.out.println("Price not in display");
        }
        try{
            // Darome sceenshot'us:
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
