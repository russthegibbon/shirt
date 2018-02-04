package shirt.pages;

import org.openqa.selenium.WebDriver;

public class ProductCategoryPage extends PageTemplate {
    public ProductCategoryPage(WebDriver driver, String baseUrl, Integer category) {
        super(driver, baseUrl, String.format("index.php?controller=category&id_category=%d", category));
    }
}
