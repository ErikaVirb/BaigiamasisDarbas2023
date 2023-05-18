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


        // Kuriame masyvą su žodžiais kuriuos įvesime į paieškos laukelį ir tikrinsime ar paieškos rezultatuose
        // t.y. produktų pavadinimuose yra ieškomas žodis.
        String[] searchTitles = {"traškučiai", "dražė", "apelsinų"};

        // Apsibrėžiam wait'us naudojimui visam metodui.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // List'as kiekvieno ieškomo žodžio rezultatams/prekiu pavadinimams talpinti
        List<String> productList1 = new ArrayList<>();
        List<String> productList2 = new ArrayList<>();
        List<String> productList3 = new ArrayList<>();

        // UŽSUKAM CIKLĄ:
        // Ciklo metu atliks veiksmus su kiekvienu masyvo nariu "iteracijom"
        for (String title : searchTitles) {
            // Driver'is nunaviguoja į puslapį "Ruta.lt"
            driver.get("https://www.ruta.lt/");

            // Susiras paieškos laukelį ir įves pradžioje pirmą iteraciją, antro ciklo metu antrąją įteraciją/reikšmę
            // ir taip eis iš eilės per visas mąsyvo reikšmes.
            WebElement searchBox = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
            searchBox.sendKeys(title);
            searchBox.submit();

            // Kuriam dar vieną List'ą, kuriame saugosim paieškos prekių pavadinimų rezultatus.
            List<WebElement> productTitles = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link" +
                    ".woocommerce-loop-product__link"));

            // List'o kūrimo procesas:
            // List'as kuris savyje "laiko" string tipo reikšmes. "null"- pradinė reikšmė yra nulinė/tuščia.
            List<String> productList = null;
            // Priskiriam po sąrašą kiekvienam paieškos žodžiui/iteracijai iš masyvo
            if (title.equals("traškučiai")) {
                productList = productList1;
            } else if (title.equals("dražė")) {
                productList = productList2;
            } else if (title.equals("apelsinų")) {
                productList = productList3;
            }
            // Ir Jeigu Tikriname ar prekių pavadinimai yra lygūs paieškos rezultatams.
            // Nusistatom, kad pradinė reikšmė yra teisinga - "true" ir priskiriam ją kintamajam
            boolean allTitlesContainWord = true;
            for (WebElement productTitle : productTitles) {// Ciklas eina per kiekvieną rezultato pavadinimą ir tikrina
                String productName = productTitle.getText();// ir "ištraukia" textą String kintamojo tipu.
                if (!productName.contains(title)) { // Jei produkto pavadinimas NEturi savyje ieškomo žodžio - "false".
                    allTitlesContainWord = false;
                    break;
                } else {
                    productList.add(productName); // Jei produkto pavadinime yra žodis kurio ieškome tuomet jis bus
                    // pridedamas į jau prieš tai nurodytą List'ą
                }
            }
            // Išvedame patikros rezultatus į konsole
            if (allTitlesContainWord) {
                System.out.println("Word:  '" + title + "' is in every title in the list.");
            } else {
                System.out.println("Word:  '" + title + "' is NOT in every title in the list.");
            }
        }
        try {
            // Darome sceenshot'us:
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