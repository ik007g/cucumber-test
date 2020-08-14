package com.cucumber.library.step_definitions;

import com.cucumber.library.pages.AddUserPage;
import com.cucumber.library.pages.UsersPage;
import com.cucumber.library.pojos.User;
import com.cucumber.library.utilities.BrowserUtils;
import com.cucumber.library.utilities.LibraryConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddUserStepDef {
    UsersPage usersPage = new UsersPage();
    AddUserPage addUserPage=new AddUserPage();
    User user=new User();
       

//    @When("I click on Add User")
//    public void i_click_on_Add_User() {
//        usersPage.addUserLink.click();
//    }
    @When("I click on {} button")
    public void i_click_on_Add_User(String button) {
        button=button.toLowerCase();
        switch (button){
            case LibraryConstants.ADD_USER:
                BrowserUtils.wait(1);
                usersPage.addUserLink.click();
                break;
            case LibraryConstants.CLOSE:
                addUserPage.closeBtn.click();
                break;
            case LibraryConstants.SAVE_CHANGES:
                addUserPage.saveChangesBtn.click();
                addUserPage.successMsg.getText();
                System.out.println(addUserPage.successMsg.getText());
                assertEquals("The user has been created.",addUserPage.successMsg.getText() );
        }

    }

    @Then("dialog fields must have matching placeholder")
    public void dialog_fields_must_have_matching_placeholder(Map<String, String> fields) {
        System.out.println(fields.entrySet());
//        for(String key:fields.keySet()){
//            System.out.println("key= "+key);
//            System.out.println("value= "+fields.get(key));
//            System.out.println();
//        }
        String actFullName=addUserPage.fullName.getAttribute("Placeholder");
        String actPassword=addUserPage.password.getAttribute("Placeholder");
        String actEmail=addUserPage.email.getAttribute("Placeholder");
        //String expAddress = fields.get("address");
        String actualAddress = addUserPage.address.getAttribute("placeholder");

        Assert.assertEquals("",actualAddress);
      //  assertTrue("Address placeholder must be empty",usersPage.address.getAttribute("placeholder").isEmpty());
        boolean match=actFullName.equals(fields.get("fullname")) &&
                actEmail.equals(fields.get("email")) &&
                actPassword.equals(fields.get("password"));
        System.out.println("Actual values "+actFullName +" "+actEmail+" "+ actPassword);
        assertTrue("Placeholder don't match "+actFullName
                +" "+actEmail+" "+ actPassword,match);
//        System.out.println("made up: " +usersPage.address.getAttribute("ZZZZZZZZ"));
//        System.out.println("value: " +usersPage.address.getAttribute("value"));
//        System.out.println("placeholder: " +usersPage.address.getAttribute("placeholder"));

    }

    @Then("start date should be today's date")
    public void start_date_should_be_today_s_date() {
        BrowserUtils.waitForClickability(addUserPage.startDate,2);
        String actualDate = addUserPage.startDate.getAttribute("value");
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        assertEquals("Actual start date does not match expected:",expectedDate,actualDate);

    }

    @Then("end date should be one month from today")
    public void end_date_should_be_one_month_from_today() {
        BrowserUtils.waitForClickability(addUserPage.endDate,2);
        String actualDate = addUserPage.endDate.getAttribute("value");
        LocalDate localDate = LocalDate.now();
        String expectedDate = localDate.plusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        System.out.println("actualDate = " + actualDate);
//        System.out.println("expectedDate = " + expectedDate);
        assertEquals("Actual end date does not match expected:",expectedDate,actualDate);

    }
    @Given("I enter new user information with random email")
    public void i_enter_new_user_information_with_random() {
        user.setFullName();
        user.setEmail();
        user.setPassword();
        user.setAddress();
       addUserPage.fullName.sendKeys(user.getFullName());
       addUserPage.email.sendKeys(user.getEmail());
       addUserPage.password.sendKeys(user.getPassword());
       addUserPage.address.sendKeys(user.getAddress());
    }

    @Then("the users table should not contain user with that email")
    public void the_users_table_should_not_contain_user_with_that_email() {
       BrowserUtils.waitForClickability(usersPage.search,3);
        usersPage.search.sendKeys(user.getEmail());
        BrowserUtils.wait(2);
        System.out.println("usersPage.allEmails.size() = " + usersPage.allEmails.size());
        assertEquals("Table contain User with given email:",usersPage.allEmails.size(), 0);
    }

    @When("the users table must contain the correct user information")
    public void the_users_table_must_contain_the_correct_user_information() {
        BrowserUtils.waitForClickability(usersPage.search,3);
        usersPage.search.sendKeys(user.getFullName());
        BrowserUtils.wait(2);
//       BrowserUtils.getElementsText(usersPage.allFullNames);
//       BrowserUtils.getElementsText(usersPage.allEmails);
        System.out.println("addUserPage.getId(user.getFullName()).getText() = " + addUserPage.getId(user.getFullName()).getText());


    }


}
