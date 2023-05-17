package RutaLT;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
public class ArraySearchProduct extends BasePage {


    public ArraySearchProduct() {
        super(driver);
    }

    public static void searchByTitle() throws IOException {


        String[] searchTitles = {"traškučiai", "dražė", "apelsinų"};

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-LoopProduct-" +
                "link.woocommerce-loop-product__link")));

        List<String> productList1 = new ArrayList<>();
        List<String> productList2 = new ArrayList<>();
        List<String> productList3 = new ArrayList<>();

        for (String title : searchTitles) {
            driver.get("https://www.ruta.lt/");

            WebElement searchBox = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
            searchBox.sendKeys(title);
            searchBox.submit();

            List<WebElement> productTitles = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link" +
                    ".woocommerce-loop-product__link"));
            List<String> productList = null;
            if (title.equals("traškučiai")) {
                productList = productList1;
            } else if (title.equals("dražė")) {
                productList = productList2;
            } else if (title.equals("apelsinų")) {
                productList = productList3;
            }
            boolean allTitlesContainWord = true;
            for (WebElement productTitle : productTitles) {
                String productName = productTitle.getText();
                if (!productName.contains(title)) {
                    allTitlesContainWord = false;
                    break;
                } else {
                    productList.add(productName);
                }
            }
            if (allTitlesContainWord) {
                System.out.println("Word:  '" + title + "' is in every title in the list.");
            } else {
                System.out.println("Word:  '" + title + "' is NOT in every title in the list.");
            }
        }
        try {
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMdd-HHmmss");
            Date currentDate = new Date();
            String dateTime = dateFormat.format(currentDate);
            String fileName = "screenshot-" + dateTime + ".png";
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\\\Mano\\\\Mokslai\\\\IT mokymai\\\\" +
                    "Baigiamasis2023\\\\ScreenshotFilesreenshot.png" + fileName));
        }catch (Exception k){
            System.out.println("Screenshot disabled");
        }
    }
}