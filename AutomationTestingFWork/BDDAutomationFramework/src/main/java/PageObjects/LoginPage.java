package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;
import org.junit.Assert;

public class LoginPage extends CommonFunctions  {

    public LoginPage(WebDriver driver)
    {

        PageFactory.initElements(driver, this);

    }

    @FindBy(id="loginEmail")
    public WebElement email;

    @FindBy(id="loginPassword")
    public WebElement password;


    @FindBy(xpath="//*[@id=\"loginForm\"]/div[4]/div/button")
    public WebElement signInButton;

    //Here myAccount link name is "Sign in"
    public void validateMyAccountLink()
    {

        driver.findElement(By.xpath("//*[@id=\"menuBarTop\"]/div[4]/a")).click();
    }

    public void inputEmailField(String emailID)
    {
        inputField(email,emailID);
    }

    public void inputPasswordField(String passwordField)
    {
        inputField(password,passwordField);
        ScrollPage(0,500);
        waitForTime(10);
    }

    public void signInBtnClick()
    {
        signInButton.click();
        waitForTime(20);
    }

    public void ProfilePageLink()
    {

        driver.findElement(By.xpath("//*[@id=\"menuBarTop\"]/div[5]/a")).click();
        waitForTime(30);
        Assert.assertEquals("Welcome back, Yogita",driver.findElement(By.xpath("//div[contains(text(), 'Welcome')]")).getText());

    }


}
