package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public PersonalInformationPage goToPersonalInformation() {
        driver.findElement(goToPersonalInformationButton()).click();
        return new PersonalInformationPage(driver);
    }

    public String fullName() {
        // TODO: this is common to many pages so should be broken out and made reusable.
        WebElement element = driver.findElement(nameLocator());
        return element.getText();
    }

    private By goToPersonalInformationButton() {
        return By.cssSelector("a[title=Information]");
    }

    private By nameLocator() {
        return By.cssSelector("a[title='View my customer account']>span");
    }
}
