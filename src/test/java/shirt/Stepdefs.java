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
import org.json.simple.JSONObject;
import shirt.pages.*;
import org.apache.logging.log4j.LogManager;
import shirt.utilities.ConfigReader;

import java.util.concurrent.TimeUnit;

public class Stepdefs {
    private final WebDriver driver = new ChromeDriver();
    private String baseUrl;
    private String orderReference;
    private final String configPath = "./config.json";
    private final ConfigReader configReader = new ConfigReader(configPath);
    private Logger log = LogManager.getLogger("com.peppermintspencer");

    @Before()
    public void configure() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JSONObject environment = configReader.getValue("environment");
        String protocol = (String) environment.get("protocol");
        String host = (String) environment.get("host");
        String baseUrlTemplate = "%s://%s";
        baseUrl = String.format(baseUrlTemplate, protocol, host);
        log.info("Base URL is: " + baseUrl);
        driver.get(baseUrl);
    }

    @Given("^I am on the shop website$")
    public void I_am_on_the_shop_website() throws Exception {
        HomePage homePage = new HomePage(driver, baseUrl);
        homePage.open();
    }

    @When("^I order a t-shirt$")
    public void i_order_a_t_shirt() throws Exception {
        String tShirtId = configReader.getId("products", "T-shirt");
        ProductPage productPage = new ProductPage(driver, baseUrl, tShirtId);
        productPage.open();
        productPage.addToCart();
        CartSummaryPage cartSummaryPage = productPage.proceedToCheckout();
        AuthenticationPage authenticationPage = cartSummaryPage.proceedToCheckout();
        JSONObject user = configReader.getValue("user");
        String email = (String)user.get("email");
        String password = (String)user.get("password");
        AddressesPage addressesPage = authenticationPage.signIn(email, password);
        ShippingPage shippingPage = addressesPage.proceedToCheckout();
        shippingPage.agreeToTerms();
        PaymentPage paymentPage = shippingPage.proceedToCheckout();
        OrderSummaryPage orderSummaryPage = paymentPage.payByBankWire();
        OrderConfirmationPage orderConfirmationPage = orderSummaryPage.confirmOrder();
        orderReference = orderConfirmationPage.orderReference();
        log.info("Order reference is: " + orderReference);
    }

    @Then("^I should see the order in my order history$")
    public void i_should_see_the_order_in_my_order_history() throws Exception {
//        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver, baseUrl);
//        This step does not need to test navigation, so going directly to the URL will save time.
//        orderHistoryPage.open();
//        Assert.assertTrue("Order does not exist in history.", orderHistoryPage.orderExists(orderReference));
        throw new PendingException();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
