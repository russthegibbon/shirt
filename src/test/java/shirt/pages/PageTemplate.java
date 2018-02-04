package shirt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageTemplate {
    protected WebDriver driver;
    protected String url;

    public PageTemplate(WebDriver driver, String baseUrl, String path) {
        this.driver = driver;
        String urlTemplate = "%s/%s";
        this.url = String.format(urlTemplate, baseUrl, path);
        System.out.println("URL is: " + url);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(url);
        try {
            Thread.sleep(9000);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
