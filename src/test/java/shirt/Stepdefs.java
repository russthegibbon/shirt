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
import shirt.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import shirt.pages.ProductCategoryPage;
import shirt.utilities.ConfigReader;

public class Stepdefs {
    private final WebDriver driver = new ChromeDriver();
    private String baseUrl = new String();
    private String orderReference = new String();

    @Before()
    public void configure() {
        Logger log = LogManager.getLogger("com.peppermintspencer");
        String configPath = "config.json";
        ConfigReader configReader = new ConfigReader(configPath);
        JSONObject environment = configReader.getId("environment");
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
        HomePage homePage = new HomePage(driver, baseUrl);
        ProductCategoryPage tShirtPage = homePage.goToCategory("T-shirts");
//        tShirtPage.addItemToCart(tShirtId);
//        CartSummaryPage cartSummaryPage = tShirtPage.proceedToCheckout();
//        AuthenticationPage authenticationPage = cartSummaryPage.proceedToCheckout();
//        AddressesPage addressesPage = authenticationPage.signIn(user);
//        ShippingPage shippingPage = addressesPage.proceedToCheckout();
//        shippingPage.agreeToTerms();
//        PaymentPage paymentPage = shippingPage.proceedToCheckout();
//        OrderSummaryPage orderSummaryPage = paymentPage.payByBankWire();
//        OrderConfirmationPage orderConfirmationPage = orderSummaryPage.confirmOrder();
//        orderReference = orderConfirmationPage.orderReference();
//        log.info("Order reference is: " + orderReference);
        throw new PendingException();
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
