import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormAutotest {
    @BeforeAll
    static void setUpConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test

    void successfulFillingOutTheForm() {

        String firstName = "Max";
        String lastName = "Modern";
        String userEmail = "max@modern.com";
        String userNumber = "9816541832";
        String currentAddress = "My Current Address";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--008").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").sendKeys("Co");
        $(byText("Computer Science")).click();
        $(byText("Reading")).click();
        File file = $("#uploadPicture").uploadFile(new File("src/test/resources/picture_1.jpg"));
        $("[placeholder=\"Current Address\"]").setValue(currentAddress);
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("Student name"), text(firstName +" "+ lastName));
        $(".table").shouldHave(text("Student Email"), text(userEmail));
        $(".table").shouldHave(text("Gender"), text("Male"));
        $(".table").shouldHave(text("Mobile"), text(userNumber));
        $(".table").shouldHave(text("Date of Birth"), text("08 November,1989"));
        $(".table").shouldHave(text("Subjects"), text("Computer Science"));
        $(".table").shouldHave(text("Hobbies"), text("Reading"));
        $(".table").shouldHave(text("Picture"), text("picture_1.jpg"));
        $(".table").shouldHave(text("Address"), text(currentAddress));
        $(".table").shouldHave(text("State and City"), text("Haryana Panipat"));
        $("#closeLargeModal").click();

    }
}
