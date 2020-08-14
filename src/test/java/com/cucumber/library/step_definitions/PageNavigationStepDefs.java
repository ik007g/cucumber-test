package com.cucumber.library.step_definitions;

import com.cucumber.library.pages.BooksPage;
import com.cucumber.library.pages.DashboardPage;
import com.cucumber.library.pages.LoginPage;
import com.cucumber.library.pages.UsersPage;
import com.cucumber.library.utilities.BrowserUtils;
import com.cucumber.library.utilities.ConfigurationReader;
import com.cucumber.library.utilities.Driver;
import com.cucumber.library.utilities.LibraryConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PageNavigationStepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    UsersPage usersPage = new UsersPage();
    BooksPage booksPage = new BooksPage();
    LoginPage loginPage=new LoginPage();

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        link = link.toLowerCase();
        switch (link) {
            case LibraryConstants.DASHBOARD:
                dashboardPage.dashboard.click();
                break;
            case LibraryConstants.USERS:
                dashboardPage.users.click();
                break;
            case LibraryConstants.BOOKS:
                dashboardPage.books.click();
                break;
        }
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String page) {
        BrowserUtils.wait(2);
        page = page.toLowerCase();
        assertTrue(Driver.getDriver().getCurrentUrl().endsWith(page));
        switch (page) {
            case "users":
                String actual = usersPage.pageHeader.getText();
                String expected = "User Management";
                assertEquals(expected, actual);
                break;
            case "books":
                actual = booksPage.pageHeader.getText();
                expected = "Book Management";
                assertEquals(expected, actual);
                break;

        }
    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer defaultValue) {
        String actDefault = usersPage.getShowRecords().getFirstSelectedOption().getText();
        //String expDefault = "" + defaultValue;
        assertEquals("Default value is not as expected", actDefault, defaultValue.toString());
    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
//        System.out.println("size of dropdown: " + options.size());
//        System.out.println(options);
        List<WebElement> dropDownOptions = usersPage.getShowRecords().getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(dropDownOptions);
        assertEquals(options, elementsText);

    }

    @When("I select Show {int} records")
    public void i_select_Show_records(Integer option) {
        usersPage.getShowRecords().selectByValue(option.toString());
        BrowserUtils.wait(2);
    }

    @Then("table must display {int} records")
    public void table_must_display_records(int expectedCount) {
        BrowserUtils.wait(1);
        int actualCount = usersPage.allRows.size();
        assertEquals("Number of rows are not as expected", expectedCount, actualCount);
    }
    @When("I go/navigate/open/access to {string} page")
    public void i_go_to_page(String page) {
        page = page.toLowerCase();
        switch (page) {
            case LibraryConstants.DASHBOARD:
                dashboardPage.dashboard.click();
                break;
            case LibraryConstants.USERS:
                dashboardPage.users.click();
                break;
            case LibraryConstants.BOOKS:
                dashboardPage.books.click();
                break;
        }
    }

    @Given("I access {string} page as a {word}")
    public void i_access_page_as_a_librarian(String page, String user) throws Exception {
       Driver.getDriver().get(ConfigurationReader.getProperty("url"));
       user=user.toLowerCase();
       page=page.toLowerCase();
       String email=null, password=null;
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
        switch (page){
            case LibraryConstants.USERS:
                dashboardPage.users.click();
                break;
            case LibraryConstants.BOOKS:
                dashboardPage.books.click();
                break;

        }
    }
}



