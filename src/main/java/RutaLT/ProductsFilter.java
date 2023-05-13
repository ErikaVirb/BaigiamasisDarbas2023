package RutaLT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsFilter extends BasePage {


    private static final By newestProductsButton = By.cssSelector("#menu-item-36159 > a:nth-child(1)");
    private static final By sortByDropDown = By.cssSelector(".orderby");
    private static final By smollestPriceList = By.className(".woocommerce-Price-amount.amount");

    public ProductsFilter() {
        super(driver);
    }

    public static void smollestPrice() {
        WebDriverWait smollestPriseWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement newestProductsButton1 = smollestPriseWait.until(ExpectedConditions.visibilityOfElementLocated
                    (newestProductsButton));
            newestProductsButton1.click();
            WebElement sortByDropDown1 = smollestPriseWait.until(ExpectedConditions.visibilityOfElementLocated
                    (sortByDropDown));
            sortByDropDown1.click();
            sortByDropDown1.sendKeys(Keys.DOWN);
            sortByDropDown1.sendKeys(Keys.ENTER);
//            Select sortByDropDown1 = new Select(driver.findElement(sortByDropDown));
//            String sort1 =

        } catch (Exception e) {
            System.out.println("Product select group not found.");
        }
        try {
            List<WebElement> krepselioLista = driver.findElements(smollestPriceList);
            for (WebElement lists : krepselioLista) {
//            String title = lists.getText(); // Pašalina HTML "a" tagą ir gauna tik textą.
                System.out.println(lists.getText());
            }
            }catch(Exception r){
                System.out.println("Cheapest Products List not found.");

        }
    }
    public static void biggestPrice(){
        WebDriverWait biggestPriceWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try{
            WebElement newestProductsButton1 = biggestPriceWait.until(ExpectedConditions.visibilityOfElementLocated
                    (newestProductsButton));
            newestProductsButton1.click();
            WebElement sortByDropDown1 = biggestPriceWait.until(ExpectedConditions.visibilityOfElementLocated
                    (sortByDropDown));
            sortByDropDown1.click();
            sortByDropDown1.sendKeys(Keys.DOWN);
            sortByDropDown1.sendKeys(Keys.DOWN);
            sortByDropDown1.sendKeys(Keys.ENTER);

        }catch (Exception e){
            System.out.println("Biggest Price dropdown list not found.");
        }
    }
}