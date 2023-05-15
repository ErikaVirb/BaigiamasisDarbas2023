package RutaLT;

import org.openqa.selenium.WebDriver;

public class SuzinotaButinaPasilikt extends BasePage{
    public SuzinotaButinaPasilikt() {
        super(driver);
    }
    public static void pavyzdziai(){


 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        System.out.println("PRODUCT LIST 1 'TRAŠKUČIAI' : ");
//        for (String product : productList1) {
//            System.out.println(product);
//        }
//
//        System.out.println("PRODUCT LIST 2 'DRAŽĖ' : ");
//        for (String product : productList2) {
//            System.out.println(product);
//        }
//
//        System.out.println("PRODUCT LIST 3 'APELSINŲ' : ");
//        for (String product : productList3) {
//            System.out.println(product);
//        }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        String[] searchTitles = {"traškučiai", "dražė", "apelsinų"};
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-LoopProduct-" +
//                "link.woocommerce-loop-product__link")));
//
//        List<String> productList1 = new ArrayList<>();
//        List<String> productList2 = new ArrayList<>();
//        List<String> productList3 = new ArrayList<>();
//
//        for (String title : searchTitles) {
//            driver.get("https://www.ruta.lt/");
//
//            WebElement searchBox = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
//            searchBox.sendKeys(title);
//            searchBox.submit();
//
//            List<WebElement> productTitles = driver.findElements(By.cssSelector(".woocommerce-LoopProduct" +
//                    "-link.woocommerce-loop-product__link"));
//            for (WebElement productTitle : productTitles) {
//                String productName = productTitle.getText();
//                if (productName.contains(title)) {
//                    if (title.equals("traškučiai")) {
//                        productList1.add(productName);
//                    } else if (title.equals("dražė")) {
//                        productList2.add(productName);
//                    } else if (title.equals("apelsinų")) {
//                        productList3.add(productName);
//                    }
//                }
//            }
//        }
//
//        // Compare each search title to its corresponding list
//        for (int i = 0; i < searchTitles.length; i++) {
//            String title = searchTitles[i];
//            if (title.equals("traškučiai")) {
//                System.out.println("PRODUCT LIST 1 'TRAŠKUČIAI' : ");
//                for (String product : productList1) {
//                    if (product.toLowerCase().contains(title.toLowerCase())) {
//                        System.out.println(product + " contains '" + title + "'");
//                    } else {
//                        System.out.println(product + " does not contain '" + title + "'");
//                    }
//                }
//            } else if (title.equals("dražė")) {
//                System.out.println("PRODUCT LIST 2 'DRAŽĖ' : ");
//                for (String product : productList2) {
//                    if (product.toLowerCase().contains(title.toLowerCase())) {
//                        System.out.println(product + " contains '" + title + "'");
//                    } else {
//                        System.out.println(product + " does not contain '" + title + "'");
//                    }
//                }
//            } else if (title.equals("apelsinų")) {
//                System.out.println("PRODUCT LIST 3 'APELSINŲ' : ");
//                for (String product : productList3) {
//                    if (product.toLowerCase().contains(title.toLowerCase())) {
//                        System.out.println(product + " contains '" + title + "'");
//                    } else {
//                        System.out.println(product + " does not contain '" + title + "'");
//                    }
//                }
//            }
//        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//        String[] searchTitles = {"traškučiai", "dražė", "apelsinų"};
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-LoopProduct-" +
//                "link.woocommerce-loop-product__link")));
//
//        List<String> productList1 = new ArrayList<>();
//        List<String> productList2 = new ArrayList<>();
//        List<String> productList3 = new ArrayList<>();
//
//        for (String title : searchTitles) {
//            driver.get("https://www.ruta.lt/");
//
//            WebElement searchBox = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
//            searchBox.sendKeys(title);
//            searchBox.submit();
//            List<WebElement> productTitles = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link." +
//                    "woocommerce-loop-product__link"));
//
//            for (WebElement productTitle : productTitles) {
//                String productName = productTitle.getText();
//                if (productName.contains(title)) {
//                    if (title.equals("traškučiai")) {
//                        productList1.add(productName);
//                    } else if (title.equals("dražė")) {
//                        productList2.add(productName);
//                    } else if (title.equals("apelsinų")) {
//                        productList3.add(productName);
//                    }
//                }
//            }
//        }
//        for (String title : searchTitles) {
//            System.out.println("PRODUCTS FOR SEARCH TERM '" + title.toUpperCase() + "' :");
//            if (title.equals("traškučiai")) {
//                for (String product : productList1) {
//                    if (product.contains(title)) {
//                        System.out.println(product);
//                    }
//                }
//            } else if (title.equals("dražė")) {
//                for (String product : productList2) {
//                    if (product.contains(title)) {
//                        System.out.println(product);
//                    }
//                }
//            } else if (title.equals("apelsinų")) {
//                for (String product : productList3) {
//                    if (product.contains(title)) {
//                        System.out.println(product);
//                    }
//                }
//            }
//            System.out.println();
//        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        // Sukuria tris listus ir sudeda visų tryjų ieškomų žodžių paieškų rezultatus į tris atskirus listus:
//        String[] searchTitles = {"traškučiai", "dražė", "apelsinų"};
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-LoopProduct-" +
//                "link.woocommerce-loop-product__link")));
//
//        List<String> productList1 = new ArrayList<>();
//        List<String> productList2 = new ArrayList<>();
//        List<String> productList3 = new ArrayList<>();
//
//        for (String title : searchTitles) {
//            driver.get("https://www.ruta.lt/");
//
//            WebElement searchBox = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
//            searchBox.sendKeys(title);
//            searchBox.submit();
//
//            List<WebElement> productTitles = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link." +
//                    "woocommerce-loop-product__link"));
//            for (WebElement productTitle : productTitles) {
//                String productName = productTitle.getText();
//                if (productName.contains(title)) {
//                    if (title.equals("traškučiai")) {
//                        productList1.add(productName);
//                    } else if (title.equals("dražė")) {
//                        productList2.add(productName);
//                    } else if (title.equals("apelsinų")) {
//                        productList3.add(productName);
//                    }
//                }
//            }
//        }
//        System.out.println("PRODUCT LIST 1 'TRAŠKUČIAI' : ");
//        for (String product : productList1) {
//            System.out.println(product);
//        }
//
//        System.out.println("PRODUCT LIST 2 'DRAŽĖ' : ");
//        for (String product : productList2) {
//            System.out.println(product);
//        }
//
//        System.out.println("PRODUCT LIST 3 'APELSINŲ' : ");
//        for (String product : productList3) {
//            System.out.println(product);
//        }
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        // Sukuria vieną listą ir sudeda visų tryjų ieškomų žodžių paieškų rezultatus:
//        String[] searchTitles = {"traškučiai", "dražė", "apelsinų"};
//        try {
//
//            for (String searchTitle : searchTitles) {
//                driver.get("https://www.ruta.lt/");
//
//                WebElement searchInput = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
//                searchInput.sendKeys(searchTitle);
//                searchInput.submit();
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-LoopProduct-" +
//                        "link.woocommerce-loop-product__link")));
//
//                // Extract the product titles from the search results
//                List<WebElement> productElements = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-" +
//                        "link.woocommerce-loop-product__link"));
//
////                System.out.println("SEARCH RESULTS FOR: " + searchTitle);
//                for (WebElement productElement : productElements) {
//                    String productTitle = productElement.getText();
//                    System.out.println(productTitle);
//                }
//
////                System.out.println("SEARCH RESULTS FOR: " + searchTitle + "  SEARCH RESULTS LIST. ");
////                System.out.println(driver.getTitle());
//            }
//        }catch (Exception k){
//            System.out.println("List not found");
//        }
//        driver.quit();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //PAVADINIMAI. Veikia, ir viską sukelia į vieną array Listą.
//        try {
//            List<String> productNames = new ArrayList<>();
//            List<WebElement> products = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link. +
//            woocommerce-loop-product__link"));
//
//            for (WebElement product : products) {
//                String productName = product.getText();
//                productNames.add(productName);
//            }
//            System.out.println("Titles: " + productNames);
//        }catch (Exception e){
//            System.out.println("");
//        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
