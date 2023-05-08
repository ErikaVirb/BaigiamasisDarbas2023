package RutaLT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
public class ArraySearchProduct extends BasePage {


    private static final By searchInput = By.cssSelector("");

    public ArraySearchProduct() {
        super(driver);
    }

    private static void searchByPartOfTitle() {
//        String titles;
        String[] searchTitles = {"traškučiai", "želė", "užkandžiai"};
        WebElement searchBox = driver.findElement(By.xpath(""));
//        for (int i = 0; i < searchTitles.length; i++) {
//            titles = searchTitles[i];
        // kitas "for" variantas, kuris atlieka lygiai ta pati ir nebereikia kintamojo "String titles;" :
             for (String term : searchTitles){
                 searchBox.sendKeys(term);
                 searchBox.submit();
                 String expectedValue = term + "Prekes pavadinimas";
                 String realValue = driver.getTitle();

                 assertEquals(expectedValue,realValue);
             }


    }
}