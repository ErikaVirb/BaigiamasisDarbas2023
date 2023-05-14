package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsFilter extends BasePage {

    private static final By eShopButton = By.cssSelector("li.header-button-1:nth-child(1) > div:nth-child(1) > " +
            "a:nth-child(1)");
    private static final By newestProductsButton = By.cssSelector("#menu-item-36159 > a:nth-child(1)");
    private static final By sortByDropDownBig = By.cssSelector(".orderby");

    public ProductsFilter() {
        super(driver);
    }

    public static void biggestPriceDescending() {


        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement eShopButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eShopButton));
        eShopButton1.click();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //PAVADINIMAI. Veikia, ir viską sukelia į vieną array Listą.
        List<String> productNames = new ArrayList<>();
        List<WebElement> products = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link.woocommerce" +
                "-loop-product__link"));

        for (WebElement product : products) {
            String productName = product.getText();
            productNames.add(productName);
        }
        System.out.println("Titles: " + productNames);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Skaičiams int formatu ir be valiutos simbolio:
//        List<Integer> numbers = new ArrayList<>();
//        List<WebElement> numberElements = driver.findElements(By.cssSelector(".woocommerce-Price-amount.amount"));
//        for (WebElement element : numberElements) {
//            numbers.add(Integer.parseInt(element.getText()));
//    }
        // Skaičiams int su valiutos simboliu :
//        List<Integer> numbers = new ArrayList<>();
//        List<WebElement> numberElements = driver.findElements(By.cssSelector(".woocommerce-Price-amount.amount"));
//        for (WebElement element : numberElements) {
//            String numberString = element.getText().replaceAll("[^\\d.]", "");
//            numbers.add(Integer.parseInt(numberString));
//      }
        // KAINOS: Veikia su Original Prices layout.
//        List<WebElement> webElements = driver.findElements(By.cssSelector(".woocommerce-Price-amount.amount"));
//        List<String> numbers = new ArrayList<String>();
//        for (WebElement element : webElements) {
//            String text = element.getText().replaceAll("€", "").trim();
//            numbers.add(text);
//        }
//        System.out.println("Original Prices layout: " + numbers);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Einame į Naujausi produktai skiltį:
        WebDriverWait biggestPriceWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement newestProductsButton1 = biggestPriceWait.until(ExpectedConditions.visibilityOfElementLocated
                    (newestProductsButton));
            newestProductsButton1.click();
            // Didžiausia kaina:
            WebElement sortByDropDown1 = biggestPriceWait.until(ExpectedConditions.visibilityOfElementLocated
                    (sortByDropDownBig));
            sortByDropDown1.click();
            sortByDropDown1.sendKeys(Keys.DOWN);
            sortByDropDown1.sendKeys(Keys.DOWN);
            sortByDropDown1.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Biggest Price dropdown list not found.");
        }
        // KAINOS: Su Original Prices layout.
        List<WebElement> webElements = driver.findElements(By.cssSelector(".woocommerce-Price-amount.amount"));
        List<String> numbers = new ArrayList<String>();

        for (WebElement element : webElements) {
            String text = element.getText().replaceAll("€", "").trim();
            numbers.add(text);
        }
        System.out.println("'Biggest' Prices layout : " + numbers);

        boolean isDescending = true;
        for (int i = 1; i < numbers.size(); i++) {
            if (Double.parseDouble(numbers.get(i)) > Double.parseDouble(numbers.get(i-1))) {
                isDescending = false;
                break;
            }
        }
        if (isDescending) {
            System.out.println("The numbers are in descending order");
        } else {
            System.out.println("The numbers are not in descending order");
        }
    }
    public static void smollestPriceAscending(){

        // Einame į Naujausi produktai skiltį:
        WebDriverWait biggestPriceWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement newestProductsButton1 = biggestPriceWait.until(ExpectedConditions.visibilityOfElementLocated
                    (newestProductsButton));
            newestProductsButton1.click();
            // Mažiausia kaina:
            WebElement sortByDropDown1 = biggestPriceWait.until(ExpectedConditions.visibilityOfElementLocated
                    (sortByDropDownBig));
            sortByDropDown1.click();
//            sortByDropDown1.sendKeys(Keys.DOWN);
            sortByDropDown1.sendKeys(Keys.DOWN);
            sortByDropDown1.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Smollest Price dropdown list not found.");
        }
        // KAINOS: Su Original Prices layout.
        List<WebElement> webElements = driver.findElements(By.cssSelector(".woocommerce-Price-amount.amount"));
        List<String> numbers = new ArrayList<String>();

        for (WebElement element : webElements) {
            String text = element.getText().replaceAll("€", "").trim();
            numbers.add(text);
        }
        System.out.println("'Smollest' Prices layout : " + numbers);

        boolean isAscending = true;
        for (int i = 1; i < numbers.size(); i++) {
            if (Double.parseDouble(numbers.get(i)) < Double.parseDouble(numbers.get(i-1))) {
                isAscending = false;
                break;
            }
        }
        if (isAscending) {
            System.out.println("The numbers are in ascending order");
        } else {
            System.out.println("The numbers are not in ascending order");
        }
    }
}