package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressesPage extends BasePage{
    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    public ShippingPage proceedToCheckout() {
        driver.findElement(proceedToCheckoutButton()).click();
        return new ShippingPage(driver);
    }

    private By proceedToCheckoutButton() {
        return By.cssSelector("button[name=processAddress");
    }
}
