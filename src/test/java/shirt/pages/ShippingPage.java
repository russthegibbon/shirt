package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage extends BasePage {
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public void agreeToTerms() {
        WebElement checkbox = driver.findElement(agreeToTermsCheckbox());
        if(!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public PaymentPage proceedToCheckout() {
        // TODO: create CheckoutPage class below BasePage and move this method there.
        driver.findElement(proceedToCheckoutButton()).click();
        return new PaymentPage(driver);
    }

    private By agreeToTermsCheckbox() {
        return By.id("cgv");
    }

    private By proceedToCheckoutButton() {
        return By.cssSelector("button[name=processCarrier]");
    }
}
