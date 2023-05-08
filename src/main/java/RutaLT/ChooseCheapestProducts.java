package RutaLT;

import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ChooseCheapestProducts extends BasePage{


    private static final By listOfProducts = By.className("shop-container");

    public ChooseCheapestProducts() {
        super(driver);
    }
    public static void list() throws IOException {

        List<WebElement> linkElements = driver.findElements(listOfProducts);
        for (WebElement title : linkElements) {
            String myTitle = title.getText();
            System.out.println(myTitle);
        }
        driver.quit();
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("sreenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);
    }
}
