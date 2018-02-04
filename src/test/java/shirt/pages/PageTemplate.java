package shirt.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageTemplate {
    protected WebDriver driver;
    protected String baseUrl;
    protected String url;
    Logger log = LogManager.getLogger("com.peppermintspencer");

    public PageTemplate(WebDriver driver, String baseUrl, String path) {
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
