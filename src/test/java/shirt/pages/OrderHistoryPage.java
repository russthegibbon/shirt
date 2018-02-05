package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends OpenablePage {
    public OrderHistoryPage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl, "index.php?controller=history");
    }

    public Boolean orderExists(String orderReference) {
        return driver.findElements(orderReferenceLink(orderReference)).size() > 0;
    }

    private By orderReferenceLink(String orderReference) {
        return By.xpath(String.format("//table[@id='order-list']//td/a[contains(text(),'%s')]", orderReference));
    }
}
