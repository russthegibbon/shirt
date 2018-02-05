package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends OpenablePage {
    public ProductPage(WebDriver driver, String baseUrl, String productID) {
        super(driver, baseUrl, String.format("index.php?id_product=%s&controller=product", productID));
    }

    public void addToCart() {
        driver.findElement(addToCartButton()).click();
        WebDriverWait wait = new WebDriverWait(driver, explicitWaitTimeout);
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton()));
    }

    public CartSummaryPage proceedToCheckout() {
        driver.findElement(proceedToCheckoutButton()).click();
        return new CartSummaryPage(driver);
    }

    private By addToCartButton() {
        return By.cssSelector("p#add_to_cart>button");
    }

    private By proceedToCheckoutButton() {
        return By.cssSelector("a[title='Proceed to checkout']");
    }
}
