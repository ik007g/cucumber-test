package com.cucumber.library.pages;

import com.cucumber.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends PageBase{

    @FindBy(name ="start_date")
    public WebElement startDate;

    @FindBy(name ="end_date")
    public WebElement endDate;

    @FindBy(name = "full_name")
    public WebElement fullName;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(name="email")
    public WebElement email;

    @FindBy(id="address")
    public WebElement address;

    @FindBy(xpath = "//button[@type='cancel']")
    public WebElement closeBtn;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChangesBtn;

    @FindBy(css = "#toast-container>div>div")
    public WebElement successMsg;

    public WebElement getId(String fullName){
        String xpath= "//table/tbody/tr/td[3][.='"+fullName+"']/../td[2]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
}
