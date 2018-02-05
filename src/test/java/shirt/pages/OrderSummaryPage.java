package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends BasePage {
    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmationPage confirmOrder() {
        driver.findElement(confirmOrderButton()).click();
        return new OrderConfirmationPage(driver);
    }

    private By confirmOrderButton() {
        return By.xpath("//button/span[text()='I confirm my order']/..");
    }
}
