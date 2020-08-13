package com.cucumber.library.step_definitions;

import com.cucumber.library.pages.DashboardPage;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class DashboardStepDefs {
    DashboardPage dashboardPage = new DashboardPage();

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedName) {
        String actualName = dashboardPage.accountHolderName.getText();
        assertEquals("Account holder name does not match", expectedName, actualName);
    }

}
