package legacy.TestsAndPageObjects3.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.VideoPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class VideoTests extends TestBase {

    @Test
    @Tag("coursesTests")
    @DisplayName("Проверка оплаты видеоурока \"Курс PRO Декларирование\"")
    void openCoursePayTest() {
        open("cources-list/");
        $(byText("Курс PRO Декларирование")).isDisplayed();
        new VideoPage().setButtonMoreAboutDeclarant(); //кнопка "Подробнее"
        new VideoPage().setButtonBay();

        //Expect:
        $$(".paymentFormTitle").find(text("Оплата")).shouldBe(visible, Duration.ofSeconds(10));
        $(".fieldName").$(byText("Email для чека")).isDisplayed();
    }

    @Test
    @Tag("coursesTests")
    @DisplayName("Проверка доступности карточки видеоурока \"Курс PRO ВЭД (Запись)\"")
    void openCourseCardTest() {
        open("cources-list/");
        $(byText("Курс PRO ВЭД (Запись)")).isDisplayed();
        new VideoPage().setButtonMoreAboutVEDRec(); //кнопка "Подробнее"
        $$("body").find(text("Декларации на товары и их виды")).shouldBe(visible);
    }

    // TODO: 16.05.2022, запрос на улучшение:  Привести ссылки на странице cources-list к единому стилю
    //<a class="btn go-to-course" href="/course/proved-lessons-recording">Подробнее</a>
    //<a class="btn go-to-course" href="/course/код-тн-вэд/">Подробнее</a>
    //<a class="btn go-to-course" href="/course/business-process/">Подробнее</a>
    //<a class="btn go-to-course" href="http://arivistika.ru/course/course-pro-declaration/">Подробнее</a>

    // TODO: 16.05.2022, запрос на улучшение: адрес страницы сделать "courses-list" (сейчас "cources-list")

}
