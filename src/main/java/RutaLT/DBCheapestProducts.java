package RutaLT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DBCheapestProducts extends BasePage{
    private static final String DB_URL = "jdbc://postgresql://localhost:5432/DBCheapestProducts";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Amerika12";
    private static Connection connection = null;

    public DBCheapestProducts() {
        super(driver);
    }

    public static void main(String[] args) throws SQLException { // Kadangi statiniai metodai - nereikia kurti objecto.


        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected succsessfuly.");
            createTable(); // Sukuriam lentele
            searchAndInsert("masina");
            searchAndInsert("kede");
            searchAndInsert("kaktusas");

        } catch (SQLException e) {
            System.out.println(e.getMessage());// e.printStackTrace(); // Su Duomenu baze. Tikrinam info duomenu bazeje
            // , ne is Javos.
        }

    }

    public static void createTable() throws SQLException {

        //Lenteles kurimas jei noriu siūsti į Input laukelį pvz. pavadinimus "zele, traskuciai, saldainiai":
        String sql = "CREATE TABLE IF NOT EXISTS search_results (\n" // "IF NOT EXISTS" - Patikrinimas, jei neegzistuoja
                // tada ją sukurs.
                + "id SERIAL PRIMARY KEY, \n"
                + "term TEXT NOT NULL, \n"
                + "count INT \n"
                + ");";
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Man reikia, jei noriu tik susikurti lentel:
//        public static void cheapestProduktTable() throws SQLException {
//        String productsTable = "CREATE TABLE IF NOT EXISTS all_products " + // "IF NOT EXISTS" - Patikrinimas, jei
//        neegzistuoja tada ją sukurs.
//                "(id SERIAL PRIMARY KEY, " +
//                "product_title TEXT NOT NULL, " +
//                "price INT, )";
//
//
//        try(Statement stmt = connection.createStatement()){
//            stmt.execute(productsTable);
//            System.out.println("Table all_products created successfully!");
//
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table search_results created successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void searchAndInsert(String term) throws SQLException {
        // CHROME:
        System.setProperty("webdriver.chrome.driver", "D:/Mano/Mokslai/IT mokymai/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://www.ruta.lt/");
            WebElement searchBox = driver.findElement(By.name("q")); // Susirandam Input laukelį
            searchBox.sendKeys(term); // Siunčiam raktažodžius: "zele, traskuciai, saldainiai" priskirtus "term".
            searchBox.submit();
            WebElement resultStats = driver.findElement(By.id("result-stats"));
            String countText = resultStats.getText().split(" ")[1];  // gaunam rezultatus. "Split" perkels į
            // naują eilutę.
            int count = Integer.parseInt(countText.replaceAll(",", "")); // jeigu ras kableli tada
            // pakeis ji tustuma.
            System.out.println("Search term: " + term + ", Count: " + count);

            // Insert results into database
            String sql = "INSERT INTO search_results(term, count) VALUES (?, ?);"; // Įdedam duomenis į lentelę
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, term);
                pstmt.setInt(2, count);
                pstmt.executeUpdate();
                System.out.println("Data was inserted succsessfuly");

            } catch (SQLException e) {
                System.out.println(e.getMessage()); //e.getMessage - tiksli vieta kur yra klaida Javoj.
                //Pranes vartotojui, kad tie duomenys buvo sekmingai patalpinti
            }
        }finally {
            driver.quit();
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}