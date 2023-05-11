package RutaLT;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
public class ArraySearchProduct extends BasePage {


    private static final By searchInput = By.cssSelector("#woocommerce-product-search-field-0");

    public ArraySearchProduct() {
        super(driver);
    }

    static void searchByTitle() {


        // Ims po vieną žodį ir kels į search ir tikrins ar tą reikšmę gavo.
//        try {
//           String[] searchTitles = {"traškučiai", "želė", "užkandžiai"};
//            WebElement searchInput = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
//            searchInput.sendKeys("žėlė");
//            WebElement search1 = driver.findElement(By.cssSelector("div.flex-right:nth-child(4) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(1)"));
//            search1.click();

//            String titles;
//            for (int i = 0; i < searchTitles.length; i++) {
//                titles = searchTitles[i]; // term

        // kitas "for" variantas, kuris atlieka lygiai ta pati ir nebereikia kintamojo "String titles;" :

//                for (String titles : searchTitles) {
//                    searchInput.sendKeys(titles);
//                    searchInput.submit();
//
//                    String expectedValue = titles + ""; // expectedValue
//                    String realValue = driver.getTitle();                 //
//
//                    assertEquals(expectedValue, realValue); // "assert" (assert true or false) - kaip "if. Lyginam dvi reikšmes:
//                                                            // "expectedValue" su "realValue".
//                    searchInput.clear();
//                }
//                driver.quit();
//            }
//        } catch (Exception e) {
//            System.out.println("SearchInput not found");
//        }
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        String[] searchTitles = {"traškučiai", "želė", "triufeliai"};
//        List<WebElement> productTitles = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link.woocommerce-loop-product__link"));
//        List<WebElement> chipsTitles = driver.findElements(By.className(".woocommerce-LoopProduct-link.woocommerce-loop-product__link"));
//        List<WebElement> trufflesTitles = driver.findElements(By.className(".woocommerce-LoopProduct-link.woocommerce-loop-product__link"));
//
//        for (WebElement title : productTitles) {
//            String productTitle = title.getText();
//            boolean isSuccessful = false;
//            for (String search : searchTitles) {
//                if (productTitle.contains(search)) {
//                    System.out.println("Search was successful for product title: " + productTitle);
//                    isSuccessful = true;
//                    break;
//                }
//            }
//            if (!isSuccessful) {
//                System.out.println("Search was unsuccessful for product title: " + productTitle);
//            } else {
//                WebElement searchInput = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
//                searchInput.clear();
//            }
//        }
//        driver.quit();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Define array of search terms
//        String[] searchTitles = {"traškučiai", "želė", "užkandžiai"};
//
//        // Find search input and search button
//        WebElement searchInput = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
//
//        // Find product lists
//        List<WebElement> productTitles;
//        List<WebElement> chipsTitles;
//        List<WebElement> trufflesTitles;
//
//        for (String searchTerm : searchTitles) {
//            // Enter search term and submit
//            searchInput.sendKeys(searchTerm);
//            searchInput.submit();
//
//            // Wait for product titles to load
//            productTitles = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link.woocommerce-loop-product__link"));
//            chipsTitles = driver.findElements(By.className(".woocommerce-LoopProduct-link.woocommerce-loop-product__link"));
//            trufflesTitles = driver.findElements(By.className(".woocommerce-LoopProduct-link.woocommerce-loop-product__link"));
//
//            // Assert that each product title contains the search term
//            boolean allTitlesContainSearchTerm = true;
//            for (WebElement title : productTitles) {
//                if (!title.getText().toLowerCase().contains(searchTerm.toLowerCase())) {
//                    allTitlesContainSearchTerm = false;
//                    break;
//                }
//            }
//
//            // Send message to console based on assertion result
//            if (allTitlesContainSearchTerm) {
//                System.out.println("Word " + searchTerm + " is in every title in the list");
//            } else {
//                System.out.println("Word " + searchTerm + " is not in every title in the list");
//            }
//
//            // Clear search input
//            searchInput.clear();
//        }

        // Close browser
//        driver.quit();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//        String[] searchTitles = {"traškučiai", "želė", "užkandžiai"};


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // array of search titles
        String[] searchTitles = {"traškučiai", "želė", "užkandžiai"};


        for (String title : searchTitles) {
            WebElement searchInput = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
            searchInput.sendKeys(title);

            WebElement searchIcon = driver.findElement(By.tagName("button"));
            searchIcon.click();

//            Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class);

            List<WebElement> productTitles = driver.findElements(By.className(".woocommerce-LoopProduct-link.woocommerce-loop-product__link"));
            //jeigu bent vienas žodis prekės pavadinime yra masyvo elementą atitinkantis žodis:
            boolean allTitlesContainSearchTitle = true;
            for (WebElement productTitle : productTitles) {
                if (!productTitle.getText().toLowerCase().contains(title.toLowerCase())) {
                    allTitlesContainSearchTitle = false;
                    break;
                }
                // Apsirašau iš kur imsiu

            WebElement searchInput1 = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
            searchInput1.clear();
            }
            // Siunčiu pranešimą į konsolę ar atitinka search
            if (allTitlesContainSearchTitle) {
                System.out.println("Word:  '" + title + "' is in every title in the list.");
            } else {
                System.out.println("Word:  '" + title + "' is NOT in every title in the list.");
            }

        }
        // close browser
        driver.quit();
    }
}