package com.cucumber.library.pages;

import com.cucumber.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BooksPage extends PageBase{
    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "table#tbl_users>tbody tr")
    public List<WebElement> allRows;
    @FindBy(css = "input[type='search']")
    public WebElement search;

    @FindBy(css = "[href='tpl/add-book.html']")
    public WebElement addBook;

    @FindBy(name = "name")
    public WebElement bookName;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(name = "year")
    public WebElement year;

    @FindBy(xpath = "//input[@placeholder='Author']")
    public WebElement author;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(id = "book_group_id")
    public WebElement categoryElement;

    @FindBy(id="book_categories")
    public WebElement mainCategoryElement;

    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public Select categoryList() {
        return new Select(categoryElement);
    }
    public Select mainCategoryList (){
        return new Select(mainCategoryElement);
    }

}
