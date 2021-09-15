package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest(){
        open("/automation-practice-form");

        //Name
        $("#firstName").setValue("Dennis");
        $("#lastName").setValue("Mikheyeu");

        //Email
        $("#userEmail").setValue("dm@mail.ru");

        //Gender
        $("#genterWrapper").find(byText("Male")).click();

        //Mobile
        $("#userNumber").setValue(("0123456789"));

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("June")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1994")).click();
        $(".react-datepicker__month").find(byText("17")).click();



        //Subjects
        $("#subjectsInput").setValue("Mat");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue("Physics");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue("Computer Science");
        $("#subjectsInput").pressEnter();

        //Hobbies
        $("#hobbiesWrapper").find(byText("Reading")).click();

        //Picture
        $("#uploadPicture").setValue("/Users/2k4k/Pictures/Фон/Background_56.jpg");

        //Close Ad
        $("#close-fixedban").click();

        //Navigation to click button
        $("#submit").hover();

        //Current Address
        $("#currentAddress").setValue("Belarus, Minsk");

        //State and City
        $("#state").click();
        $("#state").find(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").find(byText("Jaipur")).click();

        //Press submit
        $("#submit").click();

        //Check that Test worked correctly
        $(".modal-content").shouldHave(text("Thanks for submitting the form"), text("Dennis Mikheyeu"),
                text("dm@mail.ru"), text("Male"), text("0123456789"), text("17 June,1994"),
                text("Maths, Physics, Computer Science"), text("Reading"), text("Belarus, Minsk"),
                text("Rajasthan Jaipur"));
    }
}