package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {

    private WebDriver driver;

    //Identify webelements
    @FindBy(id ="add-to-cart-sauce-labs-backpack")
    private WebElement product1;

    @FindBy(id ="add-to-cart-sauce-labs-bike-light")
    private WebElement product2;

    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    private WebElement cartIcon;

    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]/span")
    private WebElement cartValue;

    @FindBy(id ="checkout")
    private WebElement checkout;

    public void selectproduct1()
    {
        product1.click();
    }

    public void selectproduct2()
    {
        product2.click();
    }

    public void clickCart()
    {
        cartIcon.click();
    }

    public String cartValue()
    {
        return cartValue.getText();
    }

    public void clickCheckoutBtn()
    {
        checkout.click();
    }

    public AddtoCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
