package legacy.TestsAndPageObjects3.tests;

import legacy.TestsAndPageObjects3.pages.HomePage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeTests extends TestBase {

    //@Disabled("Этот тест будет пропущен")
    @Test
    @Tag("siteTests")
    @DisplayName("Проверка текста на главной странице")
    void searshTextElement() {
        open("");
        $(".site-branding").shouldHave(text("Школа [ВЭД] Аривистики"));
        //Ниже: пример использования PageObjects для текст.локатора (не Best Practice)
        //new HomePage().byText_shouldBe_visible("Тест на профориентацию");
        //homePage.checkThatProfessionalTestVisible(); //in work
        $(byText("Тест на профориентацию")).shouldBe(visible);
        $$(".featured-event-type").find(text("Онлайн")).shouldBe(visible);
        $(By.linkText("info@arivistika.ru")).isDisplayed();
        $(".footer-address").shouldHave(text("Санкт-Петербург, ул. Гапсальская, д. 5, БЦ «Балтика», офис 801"));
    }

    @Test
    @Tag("siteTests")
    @DisplayName("Заполнение формы регистрации. Заполнены не все поля.")
    void fillFormTest() {
        open("");
        //$("input[placeholder='Ваше имя']").setValue("Olga");
        new HomePage().setNameInput("Olga");
        new HomePage().setPositionInput("QA engineer");
        //new HomePage().setTelInput("+7921781хххх");
        new HomePage().setEmailInput("test@test.test");
        new HomePage().setCompanyInput("Test Company");
        //new HomePage().setInfoInput("Test Info");
        new HomePage().setGoalInput("Test Text Text"); //текстовое поле
        $("input[value='Зарегистрироваться']").click();
        }

    // TODO: 16.05.2022
    //  Добавить ограничения по формату ввода (например для телефона = int)
    //  Выделить обязательные поля, если обязательны не все.
    //  Добавить понятный текст причины ошибки регистрации ("введены не все данные...")
    //Expect:
    //$$(".wpcf7-response-output").find(text("При отправке сообщения произошла ошибка")).shouldBe(visible, Duration.ofSeconds(10));


    @Test
    @Disabled ("Этот тест будет пропущен")
    @Tag("eventsTests")
    @DisplayName("Проверка текста на стр.Расписание")
    void searchEvents() {
        open("events-list/");
        $(".event-title").shouldHave(text("Что нужно хранить и держать в порядке на случай таможенной проверки"));
    }

}
