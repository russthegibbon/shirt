package shirt;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import shirt.pages.HomePage;
import org.apache.logging.log4j.LogManager;

public class Stepdefs {
    private final WebDriver driver = new ChromeDriver();
    private final String configPath = "config.json";
    private String baseUrl = new String();

    @Before()
    public void getConfig() {
        Logger log = LogManager.getLogger("com.peppermintspencer");
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader(configPath));
            JSONObject jsonObject = (JSONObject) object;
            JSONObject environment = (JSONObject) jsonObject.get("environment");
            String protocol = (String) environment.get("protocol");
            String host = (String) environment.get("host");
            String baseUrlTemplate = "%s://%s";
            baseUrl = String.format(baseUrlTemplate, protocol, host);
            log.info("Base URL is: " + baseUrl);
            driver.get(baseUrl);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Given("^I am on the shop website$")
    public void I_am_on_the_shop_website() throws Throwable {
        HomePage homePage = new HomePage(driver, baseUrl);
        homePage.open();
    }

    @When("^I order a t-shirt$")
    public void i_order_a_t_shirt() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see the order in my order history$")
    public void i_should_see_the_order_in_my_order_history() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
