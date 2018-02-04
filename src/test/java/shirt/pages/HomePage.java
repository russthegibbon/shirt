package shirt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageTemplate {
    public HomePage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl,"index.php");
    }
}
