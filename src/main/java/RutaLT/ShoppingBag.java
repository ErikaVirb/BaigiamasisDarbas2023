package RutaLT;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ShoppingBag extends BasePage {


    //  Panaudota:
    // - Scroll down/ scroll up;
    //
    // RASTI BUG'AI : 1. Tik du kart paspaudus "back" gryžta į prieš tai būvusį naršyklės langą.

    // ePardChoseCategory:
    private static final By eParduotuveButton = By.className("header-button");
    private static final By sokoladinesFigurosButton = By.xpath("/html/body/div[1]/main/div/div[1]/div/aside/ul/li[6]/a");
    // Dedame prekes į krepšelį po 2vnt:
    private static final By product1 = By.linkText("Juodojo šokolado (50 %) figūrų rinkinys „Šokoladiniai įrankiai“, 160 g");

    //    private static final By popUp = By.className("close");
    private static final By popUp1 = By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/button");
    private static final By plusOne = By.xpath("/html/body/div[2]/main/div/div[2]/div/div[1]/div/div[2]/form/div[1]/input[3]");
    private static final By pridetIKrep = By.xpath("/html/body/div[2]/main/div/div[2]/div/div[1]/div/div[2]/form/button");
    private static final By product2 = By.xpath("//a[contains(text(),'Pieninio šokolado figūra „Mašinėlė“, 150 g')]");

    // ....
    public ShoppingBag() {
        super(driver);
    }


    public static void ePardChoseCategory() {


        WebDriverWait ePardButtonWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Einame į e.Parduotuvę, išsirenkam kategoriją "Šokoladinės Figūros":
            WebElement ePardButton = ePardButtonWait.until(ExpectedConditions.visibilityOfElementLocated(eParduotuveButton));
            ePardButton.click();
            WebElement sokoladFigurosButton = ePardButtonWait.until(ExpectedConditions.visibilityOfElementLocated
                    (sokoladinesFigurosButton));
            sokoladFigurosButton.click();
        } catch (Exception e) {
            System.out.println("Šokoladinės figūros Button not in display");
        }
    }

    public static void chooseFirstProduct() {


        WebDriverWait ePardButtonWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Dedame prekes į krepšelį po 2vnt:
            // Pirma prekė (Šokoladiniai įrankiai):
            WebElement products1 = driver.findElement(product1);
            products1.click();
            Thread.sleep(5000);

            Actions actions = new Actions(driver);
            actions.moveByOffset(100, 200).click().build().perform();

            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(5000);
            WebElement plusOne1 = ePardButtonWait.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();

            WebElement pridetIKr = driver.findElement(pridetIKrep);
            pridetIKr.click();

            driver.navigate().back(); // Be dvigubo "back" negryžta atgal.
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Product: Šokoladiniai įrankiai Button not in display");
        }
    }

    public static void chooseSecondProduct() {


        WebDriverWait ePardButtonWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Antra prekė (Mašinėlė??????):
            WebElement product3 = ePardButtonWait.until(ExpectedConditions.visibilityOfElementLocated(product2));
            product3.click();
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("window.scrollBy(0, 400)");
            Thread.sleep(50);
            WebElement plusOne1 = ePardButtonWait.until(ExpectedConditions.visibilityOfElementLocated(plusOne));
            plusOne1.click();
            Thread.sleep(1000);
            WebElement pridetIKr = driver.findElement(pridetIKrep);
            pridetIKr.click();
            driver.navigate().back();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Product: Šokoladinė pica Button not in display");
        }

    }
}
