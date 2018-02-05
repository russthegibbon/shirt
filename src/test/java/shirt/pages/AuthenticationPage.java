package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends BasePage {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public AddressesPage signIn(String email, String password) {
        log.info("Signing in as " + email + " with password " + password);
        driver.findElement(emailTextbox()).sendKeys(email);
        driver.findElement(passwordTextbox()).sendKeys(password);
        driver.findElement(signInButton()).click();
        return new AddressesPage(driver);
    }

    private By emailTextbox() {
        return By.id("email");
    }

    private By passwordTextbox() {
        return By.id("passwd");
    }

    private By signInButton() {
        return By.id("SubmitLogin");
    }
}
