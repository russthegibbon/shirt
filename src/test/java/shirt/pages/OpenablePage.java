package shirt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OpenablePage extends BasePage {
    protected String baseUrl;
    protected String url;

    public OpenablePage(WebDriver driver, String baseUrl, String path) {
        // TODO: fail gracefully when the page requires the user to be logged in before opening.
        super(driver);
        this.driver = driver;
        this.baseUrl = baseUrl;
        String urlTemplate = "%s/%s";
        this.url = String.format(urlTemplate, baseUrl, path);
        log.info("URL for " + this.getClass().getName() + " is: " + url);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
    }
}
