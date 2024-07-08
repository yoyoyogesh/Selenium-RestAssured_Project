package utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class WebAdapter {
     WebDriver driver;


    public WebAdapter(WebDriver driver)
    {
        this.driver = driver;
    }

    //Common methods
    public void lanunchApp(String url)
    {
        driver.get(url);
    }

    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }

    public void implicitWait(long waitTime)
    {
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    public void scrolldown()
    {
     Actions actions = new Actions(driver);
     actions.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB).build().perform();
    }

    public void closeBrowser()
    {
        driver.quit();
    }

}
