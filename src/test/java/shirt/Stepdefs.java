package shirt;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.json.simple.JSONObject;
import shirt.pages.*;
import org.apache.logging.log4j.LogManager;
import shirt.utilities.ConfigReader;
import shirt.utilities.User;

import java.util.concurrent.TimeUnit;

public class Stepdefs {
    private final WebDriver driver = new ChromeDriver();
    private String baseUrl;
    private String orderReference;
    private final String configPath = "./config.json";
    private final ConfigReader configReader = new ConfigReader(configPath);
    private Logger log;

    @Before()
    public void configure() {
        log = LogManager.getLogger("com.peppermintspencer");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JSONObject environment = configReader.getValue("environment");
        String protocol = (String) environment.get("protocol");
        String host = (String) environment.get("host");
        String baseUrlTemplate = "%s://%s";
        baseUrl = String.format(baseUrlTemplate, protocol, host);
        log.info("Base URL is: " + baseUrl);
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
        User user = User.getUser();
        AddressesPage addressesPage = authenticationPage.signIn(user.email(), user.password());
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
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver, baseUrl);
//        This step does not need to test navigation, so going directly to the URL will saveWithoutChangingPassword time.
        orderHistoryPage.open();
        Assert.assertTrue(String.format("Order %s does not exist in history.", orderReference), orderHistoryPage.orderExists(orderReference));
    }

    @Given("^I am signed into the shop website$")
    public void i_am_signed_into_the_shop_website() throws Exception {
        SignInPage signInPage = new SignInPage(driver, baseUrl);
        signInPage.open();
        // TODO: implement dependency injection so that the personal information page returned by the next line can be passed to the next step.
        User user = User.getUser();
        signInPage.signIn(user.email(), user.password());
    }

    @When("^I update my first name$")
    public void i_update_my_first_name() throws Exception {
        User user = User.getUser();
        user.updateFirstName();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        PersonalInformationPage personalInformationPage = myAccountPage.goToPersonalInformation();
        personalInformationPage.updateFirstName(user.firstName());
        // Store the last name on the user object if we don't already have it.
        if (user.lastName() == null) {
            user.setLastName(personalInformationPage.lastName());
        }
        personalInformationPage.saveWithoutChangingPassword();
    }

    @Then("^I should see my updated first name in the header bar$")
    public void i_should_see_my_updated_name_in_the_header_bar() throws Exception {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals("Mismatched name:", User.getUser().fullName(), myAccountPage.fullName());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
