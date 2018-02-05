package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public OrderSummaryPage payByBankWire() {
        driver.findElement(payByBankWireButton()).click();
        return new OrderSummaryPage(driver);
    }

    private By payByBankWireButton() {
        return By.cssSelector("a[title='Pay by bank wire']");
    }
}
