package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartSummaryPage extends BasePage {
    public CartSummaryPage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage proceedToCheckout() {
        driver.findElement(proceedToCheckoutButton()).click();
        return new AuthenticationPage(driver);
    }

    private By proceedToCheckoutButton() {
        return By.cssSelector("p.cart_navigation>a[title='Proceed to checkout']");
    }
}
