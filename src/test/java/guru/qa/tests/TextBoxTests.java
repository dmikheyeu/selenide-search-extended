package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/text-box");

        $("#userName").setValue("Dennis");
        $("#userEmail").setValue("Egoroff@mail.ru");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 2");

        //Scrolls down to #botton-text-10
        SelenideElement scrollsToElement = $("#botton-text-10");
        actions().moveToElement(scrollsToElement).perform();

        $("#submit").click();

        $("#name").shouldHave(text("Dennis"));
        $("#email").shouldHave(text("Egoroff@mail.ru"));
        $("#currentAddress",1).shouldHave(text("Some street 1"));
        $("#permanentAddress",1).shouldHave(text("Another street 2"));

    }
}