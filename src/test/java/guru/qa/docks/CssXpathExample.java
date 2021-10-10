package guru.qa.docks;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExample {

    void cssXpathExample() {

        $("[data-testid=royal_email]");
        $(by("data-testid", "royal-email"));

        $("#email");
        $("[id=email]");
        $(byId("#email"));
        $(By.id("#email"));
        $("input#email");
        $x("//*[@id='email']");

        //<input type="email' class="inputtext login_form_input_box">

        $(byClassName("login_form_input_box"));
        $(".login_form_input_box");
        $("inputtext.login_form_input_box");
        $("input.inputtext.login_form_input_box");
        $x("//*[@class='login_form_input_box']");

        //<div type="email' class="inputtext">
        //      <input class="login_form_input_box">
        //</div>
        $("input.inputtext .login_form_input_box");
    }
}
