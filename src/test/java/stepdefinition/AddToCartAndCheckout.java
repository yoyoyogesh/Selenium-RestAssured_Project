package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AddtoCartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import utility.WebAdapter;

public class AddToCartAndCheckout {
    private WebDriver driver;
    private String endPoint ="https://www.saucedemo.com/";

    @Given("^user is ready with required details like \"([^\"]*)\", \"([^\"]*)\"$")
    public void user_is_ready_with_required_details_like(String userName, String password) throws Throwable {
        //Browser setup
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("useAutomationExtension",false);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        //Enter Username, password and login
        WebAdapter webAdapter = new WebAdapter(driver);
        LoginPage loginPage = new LoginPage(driver);
        webAdapter.lanunchApp(endPoint);
        webAdapter.implicitWait(3000);
        webAdapter.maximizeWindow();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickbtn();
        webAdapter.implicitWait(3000);
    }

    @When("^user is able to add couple of products \"([^\"]*)\" in the cart and checkout by providing details like \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_is_able_to_add_couple_of_products_in_the_cart_and_checkout_by_providing_details_like_and(String countOfProduct, String firstName, String lastName, String postalCode) throws Throwable {
        WebAdapter webAdapter = new WebAdapter(driver);
        AddtoCartPage addtoCartPage = new AddtoCartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        //Add products in the cart
        addtoCartPage.selectproduct1();
        addtoCartPage.selectproduct2();
        addtoCartPage.clickCart();
        webAdapter.implicitWait(3000);
        //Verify the total number of products added in the cart
        String productCount = addtoCartPage.cartValue();
        Assert.assertEquals("product count is not correct",countOfProduct,productCount);
        webAdapter.scrolldown();
        addtoCartPage.clickCheckoutBtn();
        webAdapter.implicitWait(3000);
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);
    }

    @Then("^verify that order is placed successfully with message \"([^\"]*)\"$")
    public void verify_that_order_is_placed_successfully_with_message(String message) throws Throwable {
        //Verify that order placed successfully
        WebAdapter webAdapter = new WebAdapter(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickContinueBtn();
        webAdapter.implicitWait(3000);
        checkoutPage.clickFinishBtn();
        webAdapter.implicitWait(3000);
        String strMessage = checkoutPage.getMessage();
        Assert.assertEquals("Order is not placed",message,strMessage);
        webAdapter.closeBrowser();
    }


}
