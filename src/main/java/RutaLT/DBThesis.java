package RutaLT;
import java.sql.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DBThesis extends BasePage{


    private static final String DB_URL = "jdbc:postgresql://localhost:5432/DBThesis";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Amerika12";
    private static Connection connection = null;

    public DBThesis() {
        super(driver);
    }
    public static void main(String[] args) throws SQLException {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected succsessfuly.");
            createTable(); // Sukuriam lentele
            searchAndInsert("traškučiai");
            searchAndInsert("dražė");
            searchAndInsert("apelsinų");

        } catch (SQLException e) {
            System.out.println(e.getMessage());// e.printStackTrace(); // Su Duomenu baze. Tikrinam info duomenu bazeje
            // , ne is Javos.
        }
    }

    public static void createTable() throws SQLException {


        //Lenteles kurimas jei noriu siūsti į Input laukelį pvz. pavadinimus "traskuciai, dražė, apelsinų":
        String sql = "CREATE TABLE IF NOT EXISTS array_words (\n" // "IF NOT EXISTS" - Patikrinimas, jei neegzistuoja
                // tada ją sukurs.
                + "id SERIAL PRIMARY KEY, \n"
                + "term TEXT NOT NULL, \n"
                + "count INT \n"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table : 'Array_words' created successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void searchAndInsert(String term) throws SQLException {

        try {
            driver.get("https://www.ruta.lt/");
            WebElement searchBox = driver.findElement(By.name("#woocommerce-product-search-field-0")); // Susirandam Input laukelį
            searchBox.sendKeys(term); // Siunčiam raktažodžius: "zele, traskuciai, saldainiai" priskirtus "term".
            searchBox.submit();
            WebElement resultStats = driver.findElement(By.cssSelector(".box-text.box-text-products"));
            String countText = resultStats.getText().split(" ")[1];  // gaunam rezultatus. "Split" perkels į
            // naują eilutę.
            int count = Integer.parseInt(countText.replaceAll(",", "")); // jeigu ras kableli tada
            // pakeis ji tustuma.
            System.out.println("Search term: " + term + ", Count: " + count);

            // Insert results into database
            String sql = "INSERT INTO array_words(term, count) VALUES (?, ?);"; // Įdedam duomenis į lentelę
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
}
