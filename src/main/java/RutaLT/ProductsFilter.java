package RutaLT;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductsFilter extends BasePage {

    private static final By eShopButton = By.cssSelector("li.header-button-1:nth-child(1) > div:nth-child(1) > " +
            "a:nth-child(1)");
    private static final By newestProductsButton = By.cssSelector("#menu-item-36159 > a:nth-child(1)");
    private static final By sortByDropDownBig = By.cssSelector(".orderby");

    public ProductsFilter() {
        super(driver, firefoxDriver);
    }

    public static void biggestPriceDescending() {


        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement eShopButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eShopButton));
        eShopButton1.click();
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

//        for (int i = 1; i < numbers.size(); i++) {
//            if (Double.parseDouble(numbers.get(i)) > Double.parseDouble(numbers.get(i-1))) {
//                isDescending = false;
//                break;
//            }
//        }
        for (int i = 1; i < numbers.size(); i++) {
            if (!numbers.get(i).isEmpty() && !numbers.get(i-1).isEmpty()) {
                if (Double.parseDouble(numbers.get(i)) > Double.parseDouble(numbers.get(i-1))) {
                    isDescending = false;
                    break;
                }
            }
        }
        if (isDescending) {
            System.out.println("The numbers are in descending order");
        } else {
            System.out.println("The numbers are not in descending order");
        }
        try{
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

//        boolean isAscending = true;
//        for (int i = 1; i < numbers.size(); i++) {
//            if (Double.parseDouble(numbers.get(i)) < Double.parseDouble(numbers.get(i-1))) {
//                isAscending = false;
//                break;
//            }
//        }
        boolean isAscending = true;
        for (int i = 1; i < numbers.size(); i++) {
            String current = numbers.get(i);
            String previous = numbers.get(i-1);
            if (!current.isEmpty() && !previous.isEmpty() && Double.parseDouble(current) < Double.parseDouble(previous)) {
                isAscending = false;
                break;
            }
        }

        if (isAscending) {
            System.out.println("The numbers are in ascending order");
        } else {
            System.out.println("The numbers are not in ascending order");
        }
        try{
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