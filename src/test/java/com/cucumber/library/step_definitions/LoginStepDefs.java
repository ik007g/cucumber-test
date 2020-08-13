package com.cucumber.library.step_definitions;

import com.cucumber.library.pages.LoginPage;
import com.cucumber.library.utilities.ConfigurationReader;
import com.cucumber.library.utilities.Driver;
import com.cucumber.library.utilities.LibraryConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Map;


public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.out.println("Going to login page");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("I login as librarian")
    public void i_login_as_librarian() {
        System.out.println("Logging as a librarian");
        String email = ConfigurationReader.getProperty("librarian_email");
        String password = ConfigurationReader.getProperty("librarian_password");
        loginPage.login(email, password);
    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        System.out.println("Verifying dashboard page");
        String expectedUrl = "dashboard";
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        String currentUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue("Url does not match :" + currentUrl, currentUrl.endsWith(expectedUrl));
        Driver.closeDriver();//TODO
    }


    @When("I login as student")
    public void i_login_as_a_student() {
        System.out.println("Logging as a student");
        String student_email = ConfigurationReader.getProperty("student_email");
        String student_password = ConfigurationReader.getProperty("student_password");
        loginPage.login(student_email, student_password);

    }

    @Then("student dashboard should be displayed")
    public void student_dashboard_should_be_displayed() {
        System.out.println("Verifying student dashboard page");
        String expectedUrl = "books";
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        String currentUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue("Url does not match :" + currentUrl, currentUrl.endsWith(expectedUrl));

    }

    @When("I login as an admin")
    public void i_login_as_an_admin() {
        System.out.println("Logging as an admin");
    }

    @Given("I login using following credentials:")
    public void i_login_using_following_credentials(Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        loginPage.login(email, password);
    }

    @Then("I login to application as a {word}")
    public void i_login_to_application_as_a(String user) throws Exception {
        String email = null;
        String password = null;
        user = user.toLowerCase();
        switch (user) {
            case LibraryConstants.STUDENT:
                email = ConfigurationReader.getProperty("student_email");
                password=ConfigurationReader.getProperty("student_password");
                break;
            case LibraryConstants.LIBRARIAN:
                email = ConfigurationReader.getProperty("librarian_email");
                password=ConfigurationReader.getProperty("librarian_password");
                break;
            default:
               // Assert.fail("Wrong user type is provided "+user);
                throw new Exception("Wrong user type is provided "+user);
        }
        loginPage.login(email,password);
    }

}