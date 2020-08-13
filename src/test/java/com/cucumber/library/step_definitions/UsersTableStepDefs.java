package com.cucumber.library.step_definitions;

import com.cucumber.library.pages.UsersPage;
import com.cucumber.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UsersTableStepDefs {
    UsersPage usersPage = new UsersPage();

    @When("I search for {string}")
    public void i_search_for(String searchString) {
        BrowserUtils.waitForClickability(usersPage.search, 5);
        usersPage.search.sendKeys(searchString.toLowerCase());
        BrowserUtils.wait(2);//it's a dynamic search
        //every time key up-->refresh page
        //that's why we use wait
    }

    @Then("table should contain rows with {string}")
    public void table_should_contain_rows_with(String searchString) {
        int size = usersPage.allUserIds.size();
        System.out.println("size = " + size);

        for (int i = 0; i < size; i++) {
            assertTrue(
                    usersPage.allUserIds.get(i).getText().toLowerCase().contains(searchString) |
                            usersPage.allFullNames.get(i).getText().contains(searchString) |
                            usersPage.allEmails.get(i).getText().contains(searchString));
        }

        System.out.println("usersPage = " + usersPage.allEmails.size());
        //    boolean found = id.contains(expectedString) ||
//  name.contains(expectedString) ||
//  email.contains(expectedString);
//  assertTrue("Expected string was not found in table test: "+ expectedString, found);

    }

    @Then("table should have following columns names:")
    public void table_should_have_following_columns_names(List<String> expColumnsNames) {
        List<String> actualColumnNames = BrowserUtils.getElementsText(usersPage.columnNames);
        System.out.println("actualColumnNames = " + actualColumnNames);
        System.out.println("columnsNames = " + expColumnsNames);
        Assert.assertEquals("Actual column names are not as expected" + actualColumnNames, expColumnsNames, actualColumnNames);
    }

    @Then("table should contain this data")
    public void table_should_contain_this_data(Map<String, String > user) {

        String userID = user.get("userID");
        String fullName=user.get("fullName");
        String email = user.get("email");
        List<String> elementsText = BrowserUtils.getElementsText(usersPage.allRows);
    boolean found = false;
        for(String row:elementsText){
        found=(row.contains(userID) &&
                row.contains(fullName) &&
                row.contains(email));
        if(found){
            break;
        }
//            if(!found){ --> but change initial value to true
//                continue;
//            }
//            assertTrue(found);
    }

        assertTrue(userID + " information was not found", found);
    }
    @Then("Each User ID should be unique")
    public void each_User_ID_should_be_unique() {
       usersPage.getShowRecords().selectByValue("500");
       BrowserUtils.wait(1);
        List<String> list = BrowserUtils.getElementsText(usersPage.allUserIds);
        Set<String> uniqueId=new HashSet<>(list);
        System.out.println("uniqueId.size() = " + uniqueId.size());
       // uniqueId.addAll(list);
        System.out.println(uniqueId.size());
        System.out.println(list.size());
        assertEquals(list.size(), uniqueId.size());

    }
    @Then("{string} default value should be {string}")
    public void default_value_should_be(String dropdown, String defaultValue) {
       
    }


}
