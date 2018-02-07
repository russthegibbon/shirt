package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shirt.utilities.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalInformationPage extends BasePage {
    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    public void updateFirstName(String firstName) {
        WebElement firstNameTextBox = driver.findElement(firstNameTextbox());
        firstNameTextBox.clear();
        firstNameTextBox.sendKeys(firstName);
    }

    public MyAccountPage saveWithoutChangingPassword() {
        String password = User.getUser().password();
        driver.findElement(oldPasswordTextbox()).sendKeys(password);
        driver.findElement(saveButton()).click();
        return new MyAccountPage(driver);
    }

    public String lastName() {
        WebElement element = driver.findElement(lastNameTextbox());
        String lastNameElementText = element.getAttribute("value");
        log.debug("Last name element text is: " + lastNameElementText);
        Pattern pattern = Pattern.compile("^\\[?(\\w+)\\]?$");
        Matcher matcher = pattern.matcher(lastNameElementText);
        matcher.find();
        return matcher.group(1);
    }

    private By firstNameTextbox() {
        return By.id("firstname");
    }

    private By lastNameTextbox() {
        return By.id("lastname");
    }

    private By oldPasswordTextbox() {
        return By.id("old_passwd");
    }

    private By saveButton() {
        return By.cssSelector("button[name=submitIdentity]");
    }
}
