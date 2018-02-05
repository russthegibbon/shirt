package shirt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String orderReference() {
        // TODO: make this work with orders that use payment methods other than bank wire.
        String summaryText = driver.findElement(summaryBlock()).getText();
        Pattern pattern = Pattern.compile("order reference ([^\\s]+)");
        Matcher matcher = pattern.matcher(summaryText);
        matcher.find();
        String reference = null;
        try {
            reference = matcher.group(1);
        } catch (IllegalStateException e) {
            log.fatal("Could not find order reference on confirmation page:");
            log.fatal(e.getMessage());
        }
        return reference;
    }

    private By summaryBlock() {
        return By.cssSelector("div.box");
    }
}
