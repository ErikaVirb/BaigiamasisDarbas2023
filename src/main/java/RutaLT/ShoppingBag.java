package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ShoppingBag extends BasePage {


    //  Panaudota:
    // - Scroll down/ scroll up;

 // RASTI BUG'AI : 1. Tik du kart paspaudus "back" gryžta į prieš tai būvusį naršyklės langą. Kaip pažymėti kad mėgstamiausas?

  // ePardChoseCategory:
    private static final By eShopButton = By.className("header-button");
    private static final By chocolateFiguresButton = By.xpath("/html/body/div[1]/main/div/div[1]/div/aside/ul/li[6]/a");
  // Dedame prekes į krepšelį po 2vnt:
    private static final By product1 = By.linkText("Juodojo šokolado (50 %) figūrų rinkinys „Šokoladiniai įrankiai“, 160 g");
    private static final By plusOne = By.xpath("/html/body/div[2]/main/div/div[2]/div/div[1]/div/div[2]/form/div[1]/input[3]");
    private static final By addToCart = By.cssSelector(".single_add_to_cart_button");
    private static final By product2 = By.xpath("//a[contains(text(),'Pieninio šokolado figūra „Mašinėlė“, 150 g')]");


    public ShoppingBag() {
        super(driver);
    }


    public static void eShopChoseCategory() throws IOException {


        WebDriverWait eShopButtonWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
     // Einame į e.Parduotuvę, išsirenkam kategoriją "Šokoladinės Figūros":
            WebElement eShopButton1 = eShopButtonWait.until(ExpectedConditions.visibilityOfElementLocated(eShopButton));
            eShopButton1.click();
            WebElement chocolateFigButton = eShopButtonWait.until(ExpectedConditions.visibilityOfElementLocated
                    (chocolateFiguresButton));
            chocolateFigButton.click();
        } catch (Exception e) {
            System.out.println("Chocolate Figures Button not in display");
        }
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("sreenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);
    }
  // Dedame prekes į krepšelį po 2vnt:
    public static void chooseFirstProduct() throws IOException {

  // Pirma prekė (Šokoladiniai įrankiai):
        WebDriverWait eShopButtonWait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement products1 = driver.findElement(product1);
            products1.click();
//            WebElement plusOne11 = eShopButtonWait1.until(ExpectedConditions.visibilityOfElementLocated(plusOne));

////////////////////////////////////////////////////////////////////////////////////////////
            WebElement plusOne11 = driver.findElement(plusOne);
           if (plusOne11.isDisplayed()){ // dar gali būti : (plusOne11.isEnabled()). "Displayed" - matomas elementas,
                                                                                  // "Enabled" - ar elementas yra aktyvus
                                                                                  // (koks nors inputas arba mygtukas)
               plusOne11.click();
           }else{
               System.out.println("Increase by one Button is not displayed.");
           }
//////////////////////////////////////////////////////////////////////////////////////////////////
         //  plusOne11.wait(3000);
         // Scroll - kad pasimatytų mygtukai "+1" ir "Į krepšelį".
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0, 300)");
            Thread.sleep(5000);

            WebElement plusOne1 = eShopButtonWait1.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();

            WebElement addToCart1 = eShopButtonWait1.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
            addToCart1.click();

            driver.navigate().back(); // Be dvigubo "back" negryžta atgal.
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Plus One Button not in display");
        }
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("sreenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);
    }

    public static void chooseSecondProduct() throws IOException {


        WebDriverWait eShopButtonWait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
     // Antra prekė (Mašinėlė):
            WebElement produc2 = eShopButtonWait2.until(ExpectedConditions.visibilityOfElementLocated(product2));
            produc2.click();

            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(50);

            WebElement plusOne1 = eShopButtonWait2.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();
            Thread.sleep(1000);

            WebElement addToCart2 = driver.findElement(addToCart);
            addToCart2.click();
            driver.navigate().back();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Product: Šokoladinė pica Button not in display");
        }

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("sreenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);
    }
}
