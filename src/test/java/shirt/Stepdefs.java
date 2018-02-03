package shirt;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stepdefs {
    private final WebDriver driver = new ChromeDriver();

    @Given("^I am on the shop website$")
    public void I_am_on_the_shop_website() throws Throwable {
        System.out.println("Hello world");
        driver.get("http://automationpractice.com");
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
