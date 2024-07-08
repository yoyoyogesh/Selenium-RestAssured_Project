package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    //Identify webelements
    @FindBy(id ="first-name")
    private WebElement firstname;

    @FindBy(id ="last-name")
    private WebElement lastname;

    @FindBy(id ="postal-code")
    private WebElement postalcode;

    @FindBy(id ="continue")
    private WebElement continuebtn;

    @FindBy(id ="finish")
    private WebElement finishbtn;

    @FindBy(xpath ="//h2[normalize-space()=\"Thank you for your order!\"]")
    private WebElement ordermessage;


    //Methods to interact with webelements
    public void enterFirstName(String strFirstName)
    {
        firstname.sendKeys(strFirstName);
    }

    public void enterLastName(String strLastName)
    {
        lastname.sendKeys(strLastName);
    }

    public void enterPostalCode(String strPostalCode)
    {
        postalcode.sendKeys(strPostalCode);
    }

    public void clickContinueBtn()
    {
        continuebtn.click();
    }

    public void clickFinishBtn()
    {
        finishbtn.click();
    }

    public String getMessage()
    {
        return ordermessage.getText();
    }

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
