package RutaLT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseCheapestProducts extends BasePage{


    private static final By listOfProducts = By.className("shop-container");

    public ChooseCheapestProducts() {
        super(driver);
    }
    public static void list(){

        List<WebElement> linkElements = driver.findElements(listOfProducts);
        for (WebElement title : linkElements) {
            String myTitle = title.getText();
            System.out.println(myTitle);
        }
        driver.quit();
    }
}
