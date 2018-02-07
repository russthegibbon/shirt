package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends OpenablePage {
    public SignInPage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl, "index.php?controller=authentication");
    }


    public MyAccountPage signIn(String email, String password) {
        // TODO: check whether signing in leads to different pages depending on context.
        // TODO: check commonality with sign in process during purchase and re-use code if possible.
        log.info("Signing in as " + email + " with password " + password);
        driver.findElement(emailTextbox()).sendKeys(email);
        driver.findElement(passwordTextbox()).sendKeys(password);
        driver.findElement(signInButton()).click();
        return new MyAccountPage(driver);
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
