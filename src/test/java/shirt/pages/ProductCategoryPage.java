package shirt.pages;

import org.openqa.selenium.WebDriver;

public class ProductCategoryPage extends OpenablePage {
    public ProductCategoryPage(WebDriver driver, String baseUrl, String categoryID) {
        super(driver, baseUrl, String.format("index.php?controller=category&id_category=%s", categoryID));
    }
}
