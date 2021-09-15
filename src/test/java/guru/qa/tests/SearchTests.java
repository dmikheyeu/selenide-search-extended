package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void selenideSearchTest(){
        //Open "https://google.com"
        open("https://google.com");

        //Enter "Selenide" in the search field
        $("[name=q]").setValue("Selenide").pressEnter();

        //Check that "selenide.org" appears in search results
        $("#search").shouldHave(text("selenide.org"));
    }
}