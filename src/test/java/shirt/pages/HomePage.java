package shirt.pages;

import org.openqa.selenium.WebDriver;
import shirt.utilities.ConfigReader;

public class HomePage extends PageTemplate {
    private final String configPath = "config.json";

    public HomePage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl, "index.php");
    }

    public ProductCategoryPage goToCategory(String category) {
        Integer categoryId = categoryID(category);
        return new ProductCategoryPage(driver, baseUrl, categoryId);
    }

    private Integer categoryID(String categoryName) {
        // TODO: use dependency injection to avoid reading the file again here.
        ConfigReader configReader = new ConfigReader(configPath);
        return configReader.getId("categories", categoryName);
    }
}
