package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ShoppingBag extends BasePage {


    //  Panaudota:
    // - Scroll down/ scroll up;

    // RASTI BUG'AI : 1. Tik du kart paspaudus "back" gryžta į prieš tai būvusį naršyklės langą. Kaip pažymėti kad
    // mėgstamiausas?

    // ePardChoseCategory:
    private static final By eShopButton = By.cssSelector("li.header-button-1:nth-child(1) > div:nth-child(1) > " +
            "a:nth-child(1)");//"#wide-nav > div > div > ul > li.html.header-button-1 > " +
            //"div > a");
    //By.className("header-button"); //
    // Prekių kategorijos:
    private static final By chocolateFiguresButton = By.xpath("/html/body/div[1]/main/div/div[1]/div/" +
           "aside/ul/li[6]/a");
    private static final By dessertSweetsButton = By.xpath("/html/body/div[1]/main/div/div[1]/div" +
            "/aside/ul/li[3]/a");
    private static final By blackChocolate = By.xpath("/html/body/div[1]/main/div/div[1]/div/aside" +
            "/ul/li[3]/ul/li[2]/a");
    // Dedame prekes į krepšelį po 2vnt:
    private static final By product1 = By.linkText("Juodojo šokolado (50 %) figūrų rinkinys „Šokoladiniai " +
            "įrankiai“, 160 g");
    private static final By product2 = By.xpath("//a[contains(text(),'Pieninio šokolado figūra " +
            "„Mašinėlė“, 150 g')]");
    private static final By product3 = By.linkText("Juodojo šokolado saldainiai „Raimonda“, 680 g");
    private static final By plusOne = By.xpath("/html/body/div[2]/main/div/div[2]/div/div[1]/div/div" +
            "[2]/form/div[1]/input[3]");
    private static final By addToCart = By.cssSelector(".single_add_to_cart_button");
    // Tvarkomės su pirkiniu krepšeliu:
    private static final By shoppingBag = By.cssSelector("a[class='header-cart-link is-small']");
    private static final By removeProduct3 = By.cssSelector(".remove[data-gtm4wp_product_id='33835']");
    private static final By reduce = By.cssSelector("tr.woocommerce-cart-form__cart-item:nth-child(2) > " +
            "td:nth-child(5) > div:nth-child(1) > input:nth-child(1)");
    private static final By increase = By.cssSelector("tr.woocommerce-cart-form__cart-item:nth-child(1) > " +
            "td:nth-child(5) > div:nth-child(1) > input:nth-child(4)");
    private static final By cancelDelete3 = By.cssSelector(".restore-item");
    private static final By updateshoppingBag = By.cssSelector("button.button:nth-child(2)");
    private static final By updateMessageText = By.cssSelector(".message-container");
    // Prekių listo tikrinimas:
    private static final By productsBagList = By.tagName(".product-name a");
    private static final List<String> expectedTitles = List.of(
            "Juodojo šokolado (50 %) figūrų rinkinys „Šokoladiniai įrankiai“, 160 g",
            "Pieninio šokolado figūra „Mašinėlė“, 150 g");


    public ShoppingBag() {
        super(driver);
    }


    public static void eShopChoseCategory() throws IOException {


        WebDriverWait eShopButtonWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        try {
            // Einame į e.Parduotuvę, išsirenkam kategoriją "Šokoladinės Figūros":
            WebElement eShopButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eShopButton));
            eShopButton1.click();
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0, 100)");
            WebElement chocolateFigButton = eShopButtonWait.until(ExpectedConditions.visibilityOfElementLocated
                    (chocolateFiguresButton));
            chocolateFigButton.click();
        } catch (Exception e) {
            System.out.println("Chocolate Figures Button not in display");
        }
    }

    public static void chooseFirstProduct() throws IOException {


        // Pirma prekė (Šokoladiniai įrankiai):
        WebDriverWait eShopButtonWait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0)");
            WebElement products1 = eShopButtonWait1.until(ExpectedConditions.visibilityOfElementLocated(product1));
            products1.click();
            //  plusOne11.wait(3000) -  galimas variantas
            // Scroll - kad pasimatytų mygtukai "+1" ir "Į krepšelį".
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0, 300)");
            WebElement plusOne1 = eShopButtonWait1.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();
            WebElement addToCart1 = eShopButtonWait1.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
            addToCart1.click();
            // 5 kart paspausti back.
//            for(int i = 0; i < 5; i++){
//                driver.navigate().back();
//            }
            driver.navigate().back(); // Be dvigubo "back" negryžta atgal.
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Plus One Button not in display");
        }
    }

    public static void chooseSecondProduct() throws IOException {


        // Antra prekė (Mašinėlė):
        WebDriverWait eShopButtonWait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0)");
            WebElement produc2 = eShopButtonWait2.until(ExpectedConditions.visibilityOfElementLocated(product2));
            produc2.click();
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("window.scrollBy(0, 400)");
            WebElement plusOne1 = eShopButtonWait2.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();
            WebElement addToCart2 = driver.findElement(addToCart);
            addToCart2.click();
            driver.navigate().back();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Product: Chocolate car not in display");
        }
    }

    public static void chooseThirdProduct() throws IOException {


        // Einame į e.Parduotuvę, išsirenkam kategoriją "Desertiniai saldainiai":
        WebDriverWait eShopButtonWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0)");
            WebElement chocolateFigButton = eShopButtonWait.until(ExpectedConditions.visibilityOfElementLocated
                    (dessertSweetsButton));
            chocolateFigButton.click();
            WebElement blackChocolate1 = eShopButtonWait.until(ExpectedConditions.visibilityOfElementLocated
                    (blackChocolate));
            blackChocolate1.click();
        } catch (Exception e) {
            System.out.println("Dessert Sweets Button not in display");
        }
        // Trečia prekė (Juodojo šokolado saldainiai „Raimonda“):
        WebDriverWait eShopButtonWait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebDriverWait plusOneWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0)");
            WebElement produc2 = eShopButtonWait2.until(ExpectedConditions.visibilityOfElementLocated(product3));
            produc2.click();
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("window.scrollBy(0, 400)");
            WebElement plusOne1 = plusOneWait.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();
            WebElement addToCart2 = driver.findElement(addToCart);
            addToCart2.click();


        } catch (Exception r) {
            System.out.println("Product: Button not in displayed");
        }
    }

    public static void manageShopBag() {
        WebDriverWait manageShopWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
            try {
                WebElement shoppingBag1 = manageShopWait.until(ExpectedConditions.visibilityOfElementLocated(shoppingBag));
                shoppingBag1.click();
                WebElement remove3Product = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (removeProduct3));
                remove3Product.click();
                WebElement cancel3Delete = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (cancelDelete3));
                cancel3Delete.click();
                WebElement removeProduct = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (removeProduct3));
                removeProduct.click();
            } catch (Exception e) {
                System.out.println("Remove Button not found");
            }
            try {
                WebElement updateshopBag = wait.until(ExpectedConditions.visibilityOfElementLocated(updateshoppingBag));
                updateshopBag.click();
                WebElement increase1 = manageShopWait.until(ExpectedConditions.visibilityOfElementLocated(increase));
                increase1.sendKeys(Keys.ENTER);
                WebElement reduce1 = manageShopWait.until(ExpectedConditions.visibilityOfElementLocated(reduce));
                reduce1.sendKeys(Keys.ENTER);
                WebElement updateshopBag1 = manageShopWait.until(ExpectedConditions.visibilityOfElementLocated(updateshoppingBag));
                updateshopBag1.click();
            }catch (Exception m){
                System.out.println("Increase Button Not found");
            }

/////////////////////////////////////////////////////////////////////////
        String expectedUpdateText = "Krepšelis atnaujintas";
        String actualUpdateText = driver.findElement(updateMessageText).getText();

        if (actualUpdateText.contains(expectedUpdateText)) {
            System.out.println("The error message is correct!");
        } else {
            System.out.println("The error message is INCORECT!");
        }
//////////////////////////////////////////////////////////////////////////
        /*
//        WebDriverWait manageBagWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        List<WebElement> krepselioLista = driver.findElements(productsBagList);
        for (WebElement lists : krepselioLista) {
//            String title = lists.getText(); // Pašalina HTML "a" tagą ir gauna tik textą.
            System.out.println(lists.getText());
        }
        return krepselioLista;

            driver.quit();
            List<String> actualTitles = new ArrayList<>();
            List<WebElement> elements = driver.findElements(productsBagList);
            for (WebElement element : elements) {
                actualTitles.add(element.getText().trim());
                System.out.println("Produktu sarasas:" + actualTitles);
            }
            if (actualTitles.contains(expectedTitles)) {
                System.out.println("The shopping bag is correct");
            } else {
                System.out.println("The shopping bag titles are not correct");
            }
                    Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(15))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            */
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
