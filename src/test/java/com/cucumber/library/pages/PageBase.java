package com.cucumber.library.pages;

import com.cucumber.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {
public PageBase(){
    PageFactory.initElements(Driver.getDriver(), this);
}

@FindBy(xpath = "//span[contains(text(), 'Users')]")
    public WebElement users;

@FindBy(xpath = "//span[.='Books']/..")
    public WebElement books;

    @FindBy(xpath = "//a[@class='nav-link']//span[.='Dashboard']")
    public WebElement dashboard;

@FindBy(tagName = "h3")
    public WebElement pageHeader;

@FindBy(css = "#navbarDropdown>span")
    public WebElement accountHolderName;
}
