package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shirt.utilities.ConfigReader;

public class HomePage extends PageTemplate {
    private final String configPath = "config.json";

    public HomePage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl, "index.php");
    }

    public ProductCategoryPage goToCategory(String category) {
        String categoryId = categoryID(category);
        driver.findElement(topMenuCategory(category)).click();
        return new ProductCategoryPage(driver, baseUrl, categoryId);
    }

    private By topMenuCategory(String category) {
        String selector = String.format("div#block_top_menu>ul>li>a[title=%s]", category);
        return By.cssSelector(selector);
    }

    private String categoryID(String categoryName) {
        // TODO: use dependency injection to avoid reading the file again here.
        ConfigReader configReader = new ConfigReader(configPath);
        return configReader.getId("categories", categoryName);
    }
}
