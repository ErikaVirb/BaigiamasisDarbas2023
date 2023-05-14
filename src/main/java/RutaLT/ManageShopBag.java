package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManageShopBag extends BasePage{


    // Tvarkomės su pirkiniu krepšeliu:
    private static final By shoppingBag = By.cssSelector("a[class='header-cart-link is-small']");
    private static final By removeProduct3 = By.cssSelector(".remove[data-gtm4wp_product_id='33835']");
    private static final By reduce = By.className("(//input[@value='-'])[2]");//tr.woocommerce-cart-form__cart-item:nth-child(2) > " +
          //  "td:nth-child(5) > div:nth-child(1) > input:nth-child(1)
    private static final By increase = By.className("(//input[@value='+'])[1]");//tr.woocommerce-cart-form__cart-item:nth-child(1) > " +
           // "td:nth-child(5) > div:nth-child(1) > input:nth-child(4)
    private static final By updateshoppingBag = By.cssSelector("button.button:nth-child(2)");
    private static final By updateMessageText = By.cssSelector(".woocommerce-notices-wrapper");
    // Prekių listo tikrinimas:
    private static final By firstProductPrice = By.cssSelector("tr.woocommerce-cart-form__cart-item:nth-child(1) " +
            "> td:nth-child(6) > span:nth-child(1)");
    private static final By secondProductPrise = By.cssSelector("tr.woocommerce-cart-form__cart-item:nth-child(2)" +
            " > td:nth-child(6) > span:nth-child(1)");
    private static final By inTotal = By.cssSelector(".order-total > td:nth-child(2) > strong:nth-child(1) " +
            "> span:nth-child(1)");

//    private static final By productsBagList = By.tagName(".product-name a");
//    private static final List<String> expectedTitles = List.of(
//            "Juodojo šokolado (50 %) figūrų rinkinys „Šokoladiniai įrankiai“, 160 g",
//            "Pieninio šokolado figūra „Mašinėlė“, 150 g");

    public ManageShopBag() {
        super(driver);
    }

    public static void manageShopBag() {
        WebDriverWait manageShopWait = new WebDriverWait(driver, Duration.ofSeconds(25));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(35))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        try {
            WebElement shoppingBag1 = manageShopWait.until(ExpectedConditions.visibilityOfElementLocated(shoppingBag));
            shoppingBag1.click();
            WebElement remove3Product = manageShopWait.until(ExpectedConditions.visibilityOfElementLocated
                    (removeProduct3));
//            remove3Product.wait(3000);
            remove3Product.click();
        } catch (Exception e) {
            System.out.println("Remove Button not found");
        }
        try {
            WebElement updateshopBag = manageShopWait.until(ExpectedConditions.visibilityOfElementLocated(updateshoppingBag));
            updateshopBag.click();
            Thread.sleep(5000);

            WebElement increase1 = wait.until(ExpectedConditions.visibilityOfElementLocated(increase));
            increase1.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            WebElement reduce1 = manageShopWait.until(ExpectedConditions.visibilityOfElementLocated(reduce));
            reduce1.sendKeys(Keys.ENTER);
            WebElement updateshopBag1 = manageShopWait.until(ExpectedConditions.visibilityOfElementLocated(updateshoppingBag));
            updateshopBag1.click();
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
                System.out.println("The calculated sum is incorrect.");
            }
        } catch (Exception m) {
            System.out.println("Price not in display");
        }
////////////////////////////////////////////////////////////////////////////////////////////
//            WebElement plusOne11 = driver.findElement(plusOne);
//           if (plusOne11.isDisplayed()){ // dar gali būti : (plusOne11.isEnabled()). "Displayed" - matomas elementas,
//                                                                                  // "Enabled" - ar elementas yra aktyvus
//                                                                                  // (koks nors inputas arba mygtukas)
//               plusOne11.click();
//           }else{
//               System.out.println("Increase by one Button is not displayed.");
//           }
        //            List<WebElement> krepselioLista = driver.findElements(productsBagList);
//            for (WebElement lists : krepselioLista) {
//                String title = lists.getText(); // Pašalina HTML "a" tagą ir gauna tik textą.
//                System.out.println(title);
//            }
//////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
