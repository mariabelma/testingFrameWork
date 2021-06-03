package stepsDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.CommonFunctions;


public class LoginSteps extends CommonFunctions {
    //public static String thisMenu;

    LoginPage loginPage=new LoginPage(driver);


    @Given("I'm on Home Page")
    public void i_m_on_home_page() throws Exception {

        driver.get(readProperty("urlDev"));
        waitForTime(20);
    }

    @When("I click My Account icon")
    public void i_click_my_account_icon() {
        loginPage.validateMyAccountLink();
        waitForTime(20);

    }
    @When("I enter registered {string} in username text field")
    public void i_enter_registered_in_username_text_field(String emailIDString) throws Exception {
        loginPage.inputEmailField(emailIDString);

    }
    @When("I enter registered {string} in password text field")
    public void i_enter_registered_in_password_text_field(String stringPassword) throws Exception {
        loginPage.inputPasswordField(stringPassword);
        waitForTime(20);
    }
    @When("I click sign in button")
    public void i_click_sign_in_button() throws Exception {
        loginPage.signInBtnClick();
    }

    @Then("I should be re-directed to profile page")
    public void i_should_be_re_directed_to_profile_page() throws Exception {
        loginPage.ProfilePageLink();

    }

    @When("I enter registered invalid {string} in username text field")
    public void i_enter_registered_invalid_in_username_text_field(String invalidEmail) throws Exception {
        loginPage.inputEmailField(invalidEmail);
    }
    @When("I enter registered invalid {string} in password text field")
    public void i_enter_registered_invalid_in_password_text_field(String invalidPassword) throws Exception{
        loginPage.inputPasswordField(invalidPassword);
    }

    @Then("I should be get warning message")
    public void i_should_be_get_warning_message() throws Exception {
        String expectedValue="Your email address or password is incorrect. Please try again";
        Assert.assertEquals(expectedValue,driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div")).getText());

    }



}
