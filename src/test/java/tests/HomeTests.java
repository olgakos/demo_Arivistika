package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class HomeTests extends TestBase {
    HomePage homePage = new HomePage();

    String setName = "Olga";
    String setPosition = "QA engineer";
    String setTel = "+7921781хххх";
    String setEmail = "test@test.test";
    String setCompany = "Test Company";
    String setInfo = "Test Info";
    String setGoal = "Test Text Text";

    @Test
    //@Disabled("Этот тест будет пропущен")
    @DisplayName("Проверка текста на главной странице")
    @Tag("siteTests")
    void searshTextElement() {
        open("");
        homePage.checkThatSchoolNameVisible();
        homePage.checkThatProfessionalTestVisible();
        homePage.checkThatTextOnlineTestVisible();
        homePage.checkLinkTextTestVisible();
        homePage.checkAddressTestVisible();
    }

    @Test
    @DisplayName("Заполнение формы регистрации")
    @Tag("siteTests")
    void fillFormTest() {
        open("");
        homePage.setNameInput(setName);
        homePage.setPositionInput(setPosition);
        //homePage.setTelInput(setTel); //поле не заполено с целью получения ошибки
        homePage.setEmailInput(setEmail);
        homePage.setCompanyInput(setCompany);
        //homePage.setInfoInput(setInfo); //поле не заполено с целью получения ошибки
        homePage.setGoalInput(setGoal); //текстовое поле
        homePage.buttonLoginPressTest();
    }

    // TODO: 16.05.2022
    //  Добавить ограничения по формату ввода (например для телефона = int)
    //  Выделить обязательные поля, если обязательны не все.
    //  Добавить понятный текст причины ошибки регистрации ("введены не все данные...")
    //Expect:
    //$$(".wpcf7-response-output").find(text("При отправке сообщения произошла ошибка")).shouldBe(visible, Duration.ofSeconds(10));

    @Test
    @Disabled("Этот тест будет пропущен (пример)")
    @Tag("eventsTests")
    @DisplayName("Проверка текста на стр.Расписание")
    void searchEvents() {
        open("events-list/");
        $(".event-title").shouldHave(text("Что нужно хранить и держать в порядке на случай таможенной проверки"));
    }
}
