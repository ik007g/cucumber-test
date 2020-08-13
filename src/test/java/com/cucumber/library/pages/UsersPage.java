package com.cucumber.library.pages;

import com.cucumber.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class UsersPage extends PageBase {
    @FindBy(name = "tbl_users_length")
    public WebElement showRecords;
    @FindBy(css = "table#tbl_users>tbody tr")
    public List<WebElement> allRows;
    @FindBy(css = "input[type='search']")
    public WebElement search;
    @FindBy(xpath = "//table/tbody//td[2]")
    public List<WebElement> allUserIds;
    @FindBy(xpath = "//table/tbody//td[3]")
    public List<WebElement> allFullNames;
    @FindBy(xpath = "//table/tbody//td[4]")
    public List<WebElement> allEmails;

    @FindBy(xpath = "//table/thead//th")
    public List<WebElement> columnNames;

    @FindBy(css = "a.btn-lg")
    public WebElement addUserLink;

    @FindBy(name="full_name")
    public WebElement fullName;
    @FindBy(name="password")
    public WebElement password;
    @FindBy(name="email")
    public WebElement email;

    @FindBy(id="address")
    public WebElement address;

    @FindBy(xpath = "//a[@class='page-link' and not(@title)]")
    public List<WebElement> pageList;

    @FindBy(id="user_groups")
    public WebElement userGroup;

    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public Select getShowRecords() {
        return new Select(showRecords);
    }
    public Select getUserGroup(){
        return new Select(userGroup);
    }

}
