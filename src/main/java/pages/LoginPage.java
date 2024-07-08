package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    //Identify webelements
    @FindBy(id ="user-name")
    private WebElement username;

    @FindBy(id ="password")
    private WebElement password;

    @FindBy(id ="login-button")
    private WebElement loginbutton;

    //Methods to interact with webelements
    public void enterUsername(String strUserName)
    {
        username.sendKeys(strUserName);
    }

    public void enterPassword(String strPassword)
    {
        password.sendKeys(strPassword);
    }

    public void clickbtn()
    {
       loginbutton.click();
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
