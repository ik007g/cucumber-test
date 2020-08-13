package com.cucumber.library.step_definitions;

import com.cucumber.library.pages.BooksPage;
import com.cucumber.library.pojos.Book;
import com.cucumber.library.utilities.BrowserUtils;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BooksTableStepDefs {
    BooksPage booksPage = new BooksPage();

    @Then("books table should contain result matching {}")
    public void books_table_should_contain_result_matching(String book) {
        List<String> actualRows = BrowserUtils.getElementsText(booksPage.allRows);
        System.out.println("actualRows.size() = " + actualRows.size());
        boolean found = true;
        for (String each : actualRows) {
            if (!each.contains(book)) {
                found = false;
                break;
            }
        }
        assertTrue(book + " was not found in book table ", found);
    }

    @When("I edit book {}")
    public void i_edit_book_The_kiterunner(String book) {
        BrowserUtils.waitForClickability(booksPage.search, 5).sendKeys(book);
        BrowserUtils.waitForClickability(booksPage.editBook(book), 5).click();

    }

    @DataTableType
    public Book convertBook(Map<String, String> dataTable){
        Book book=new Book(dataTable.get("name"),
                dataTable.get("author"),
                dataTable.get("year"));
        return book;
    }
    @Then("I verify book information")
    public void i_verify_book_information(Book book) {
        System.out.println("Name of the book "+book.getName());
        String actualAuthor = booksPage.author.getAttribute("value");
        String actualBookName = booksPage.bookName.getAttribute("value");
        String actualYear = booksPage.year.getAttribute("value");

        System.out.println("actualAuthor = " + actualAuthor);
        System.out.println("actualBookName = " + actualBookName);
        System.out.println("actualYear = " + actualYear);

        assertEquals("Author does not match",book.getAuthor(),actualAuthor);
            assertEquals("Book name does not match",book.getName(),actualBookName);
        assertEquals("Year does not match",book.getYear(),actualYear);

    }



}
