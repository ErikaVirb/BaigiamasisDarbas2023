package RutaLT;

import com.google.common.base.Function;
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
import java.util.List;

public class ShoppingBag extends BasePage {


    //  Panaudota:
    // - Scroll down/ scroll up;

    // RASTI BUG'AI : 1. Tik du kart paspaudus "back" gryžta į prieš tai būvusį naršyklės langą. Kaip pažymėti kad
    // mėgstamiausas?

    // ePardChoseCategory:
    private static final By eShopButton = By.cssSelector("li.header-button-1:nth-child(1) > div:nth-child(1) > " +
            "a:nth-child(1)");
    // Prekių kategorijos:
    private static final By chocolateFiguresButton = By.xpath("/html/body/div[1]/main/div/div[1]/div/" +
            "aside/ul/li[6]/a");
    private static final By dessertSweetsButton = By.xpath("/html/body/div[1]/main/div/div[1]/div" +
            "/aside/ul/li[3]/a");
    private static final By blackChocolate = By.xpath("/html/body/div[1]/main/div/div[1]/div/aside" +
            "/ul/li[3]/ul/li[2]/a");
    // Dedame prekes į krepšelį po 2vnt:
    private static final By product1 = By.linkText("Juodojo šokolado (50 %) figūra „Zuikutis“, 100 g");
    private static final By product2 = By.xpath("//a[contains(text(),'Pieninio šokolado figūra " +
            "„Mašinėlė“, 150 g')]");
    private static final By product3 = By.linkText("Juodojo šokolado saldainiai „Raimonda“, 680 g");
    private static final By plusOne = By.xpath("/html/body/div[2]/main/div/div[2]/div/div[1]/div/div" +
            "[2]/form/div[1]/input[3]");
    private static final By addToCart = By.cssSelector(".single_add_to_cart_button");

    public ShoppingBag() {
        super(driver);
    }



    public static void eShopChoseCategory() throws IOException {


        // Apsibrėžiam wait'us naudojimui visam metodui.
        WebDriverWait eShopButtonWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        try {
            // Einame į e.Parduotuvę, išsirenkam kategoriją "Šokoladinės Figūros":
            // e.Parduotuvės mygtuko paspaudimas
            WebElement eShopButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eShopButton));
            eShopButton1.click();
            // Scroll'inam 100 pikselių žemyn
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0, 100)");
            // Spaudžiame pasirinkimo mygtuką "Šokoladinės figūros"
            WebElement chocolateFigButton = eShopButtonWait.until(ExpectedConditions.visibilityOfElementLocated
                    (chocolateFiguresButton));
            chocolateFigButton.click();
        } catch (Exception e) {
            System.out.println("Chocolate Figures Button not in display");
        }
        try{
            // Darome sceenshot'us:
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ScreenshotFilesreenshot.png" + fileName));
        }catch (Exception k){
            System.out.println("Screenshots disabled");
        }
    }

    public static void chooseFirstProduct() throws IOException {


        // Pirma prekė (zuikutis):
        // Apsibrėžiam wait'us naudojimui visam metodui.
        WebDriverWait eShopButtonWait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            // Scroll'inam su JavaScript iki pat puslapio apačios vertikalei, bet 0-niame taške kairės ekrano pusės.
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            // Scroll'inam su JavaScript iki pat puslapio viršaus vertikalei, bet 0-niame taške kairės ekrano pusės.
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0)");
            // Spaudžiame ant pirmos pasirinktos prekės "Zuikutis"
            WebElement products1 = eShopButtonWait1.until(ExpectedConditions.visibilityOfElementLocated(product1));
            products1.click();
            // Scroll 300 pixel'ių, kad pasimatytų mygtukai "+1" ir "Į krepšelį".
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0, 300)");
            // Padidinam pirmosios prekės kiekį iki 2jų
            WebElement plusOne1 = eShopButtonWait1.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();
            // Spaudžiame mygtuką "Pridėti Į Krepšelį
            WebElement addToCart1 = eShopButtonWait1.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
            addToCart1.click();
            // Imituojam "back", du kart "paspaudžiam" atgal, kad gryžti į "e.Parduotuvė"
            driver.navigate().back(); // Be dvigubo "back" negryžta atgal.
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Plus One Button not in display");
        }
        try{
            // Darome sceenshot'us:
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ScreenshotFilesreenshot.png" + fileName));
        }catch (Exception k){
            System.out.println("Screenshots disabled");
        }
    }

    public static void chooseSecondProduct() throws IOException {


        // Antra prekė (Mašinėlė):
        // Apsibrėžiam wait'us naudojimui visam metodui.
        WebDriverWait eShopButtonWait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            // Scroll'inam su JavaScript iki pat puslapio apačios vertikalei, bet 0-niame taške kairės ekrano pusės.
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            // Scroll'inam su JavaScript iki pat puslapio viršaus vertikalei, bet 0-niame taške kairės ekrano pusės.
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0)");
            // Spaudžiame ant antros pasirinktos prekės "Mašinėlė"
            WebElement produc2 = eShopButtonWait2.until(ExpectedConditions.visibilityOfElementLocated(product2));
            produc2.click();
            // Scroll 400 pixel'ių, kad pasimatytų mygtukai "+1" ir "Į krepšelį".
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("window.scrollBy(0, 400)");
            // Padidinam antrosios prekės kiekį iki 2jų
            WebElement plusOne1 = eShopButtonWait2.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();
            // Spaudžiame mygtuką "Pridėti Į Krepšelį
            WebElement addToCart2 = driver.findElement(addToCart);
            addToCart2.click();
            // Imituojam "back", du kart "paspaudžiam" atgal, kad gryžti į "e.Parduotuvė"
            driver.navigate().back();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Product: Chocolate car not in display");
        }
        try{
            // Darome sceenshot'us:
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ScreenshotFilesreenshot.png" + fileName));
        }catch (Exception k){
            System.out.println("Screenshots disabled");
        }
    }

    public static void chooseThirdProduct() throws IOException {


        // Einame į e.Parduotuvę, išsirenkam kategoriją "Desertiniai saldainiai":
        // Apsibrėžiam wait'us naudojimui visam metodui.
        WebDriverWait eShopButtonWait = new WebDriverWait(driver, Duration.ofSeconds(35));

        try {
            // Scroll'inam su JavaScript iki pat puslapio viršaus vertikalei, bet 0-niame taške kairės ekrano pusės.
            //(Apsisaugau nuo ekrano neprognozuotino pasislinkimo)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0)");
            // Einame į e.Parduotuvę, išsirenkam kategoriją "Desertiniai Saldainiai" ir paspaudžiam ant jo:
            WebElement chocolateFigButton = eShopButtonWait.until(ExpectedConditions.visibilityOfElementLocated
                    (dessertSweetsButton));
            chocolateFigButton.click();
            // Išsirenkam pokategoriją "Juodojo Šokolado" ir paspaudžiam ant jo:
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
            // Scroll'inam su JavaScript iki pat puslapio apačios vertikalei, bet 0-niame taške kairės ekrano pusės.
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            // Scroll'inam su JavaScript iki pat puslapio viršaus vertikalei, bet 0-niame taške kairės ekrano pusės.
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0)");
            // Spaudžiame ant trečios pasirinktos prekės "Raimoda"
            WebElement produc2 = eShopButtonWait2.until(ExpectedConditions.visibilityOfElementLocated(product3));
            produc2.click();
            // Scroll 400 pixel'ių, kad pasimatytų mygtukai "+1" ir "Į krepšelį".
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("window.scrollBy(0, 400)");
            // Padidinam antrosios prekės kiekį iki 2jų
            WebElement plusOne1 = plusOneWait.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();
            // Spaudžiame mygtuką "Pridėti Į Krepšelį
            WebElement addToCart2 = driver.findElement(addToCart);
            addToCart2.click();
        } catch (Exception r) {
            System.out.println("Product: Button not in displayed");
        }
        try{
            // Darome sceenshot'us:
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ScreenshotFilesreenshot.png" + fileName));
        }catch (Exception k){
            System.out.println("Screenshots disabled");
        }
    }
}