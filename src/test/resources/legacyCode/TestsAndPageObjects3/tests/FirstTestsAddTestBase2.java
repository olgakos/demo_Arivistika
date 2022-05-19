package legacyCode.TestsAndPageObjects3.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Проверка элементов публичной части сайта")

public class FirstTestsAddTestBase2 extends TestBase {

    @Tag("loginTests")
    @DisplayName("Залогин")
    @Test
    void loginTestFail() {
        open("my-account/");
        $("#username").setValue("test@test.test");
        $("#password").setValue("123");
        $(By.name("login")).click(); //кнопка "Войти"
        $(".woocommerce-error").shouldHave(text("Неверный адрес e-mail"));
    }

    @Tag("siteTests")
    @DisplayName("Проверка текста на главной странице")
    @Test
    void searshTextElement() {
        open("");
        $(".site-branding").shouldHave(text("Школа [ВЭД] Аривистики"));
        $(byText("Тест на профориентацию")).shouldBe(visible);
        $$(".featured-event-type").find(text("Онлайн")).shouldBe(visible);
        //$$(".featured-event-type").find(text("НЕОнлайн")).shouldBe(visible); //negative test
        $(By.linkText("info@arivistika.ru")).isDisplayed();
        $(".footer-address").shouldHave(text("Санкт-Петербург, ул. Гапсальская, д. 5, БЦ «Балтика», офис 801"));
    }
    @Tag("siteTests")
    @DisplayName("Отправки формы (заполнены не все поля)")
    @Test
    void fillFormTest() {
        open("");
        $("input[placeholder='Ваше имя']").setValue("Olga");
        $("input[placeholder='Должность']").setValue("QA engineer");
        //$("input[placeholder='Контактный телефон']").setValue("+7921781хххх");
        $("input[placeholder='Ваш email']").setValue("test@test.test");
        $("input[placeholder='Название компании']").setValue("Test Company");
        //$("input[placeholder='Откуда узнали']").setValue("Test Info");
        $("textarea[placeholder='Опишите цель обучения']").setValue("Test"); //текстовое поле
        $("input[value='Зарегистрироваться']").click(); //вараинт
    }

    // TODO: 16.05.2022
    //  Добавить ограничения по формату ввода (например для телефона = int)
    //  Выделить обязательные поля, если обязательны не все.
    //  Добавить понятный текст причины ошибки регистрации ("введены не все данные...")
    //Expect:
   //$$(".wpcf7-response-output").find(text("При отправке сообщения произошла ошибка")).shouldBe(visible, Duration.ofSeconds(10));

    @Tag("coursesTests")
    @DisplayName("Проверка оплаты видеоурока \"Курс PRO Декларирование\"")
    @Test
    void openCoursePayTest() {
        open("cources-list/");
        $(byText("Курс PRO Декларирование")).isDisplayed();
        $(".buy-course-block a[href*='course-pro-declaration']").click(); //кнопка "Подробнее"
        $(".lp-course-buttons").$(byText("Купить этот курс")).click(); //кнопка
        //Expect:
        $$(".paymentFormTitle").find(text("Оплата")).shouldBe(visible, Duration.ofSeconds(10));
        $(".fieldName").$(byText("Email для чека")).isDisplayed();
    }

    @Tag("coursesTests")
    @DisplayName("Проверка доступности карточки видеоурока \"Курс PRO ВЭД (Запись)\"")
    @Test
    void openCourseCardTest() {
        open("cources-list/");
        $(byText("Курс PRO ВЭД (Запись)")).isDisplayed();
        $(".buy-course-block a[href*='proved-lessons-recording']").click(); //кнопка "Подробнее"
        $$("body").find(text("Декларации на товары и их виды")).shouldBe(visible);
        //$$("body").find(text("Расписание")).shouldBe(visible); //negative test
    }

    // TODO: 16.05.2022, запрос на улучшение:  Привести ссылки на странице cources-list к единому стилю
    //<a class="btn go-to-course" href="/course/proved-lessons-recording">Подробнее</a>
    //<a class="btn go-to-course" href="/course/код-тн-вэд/">Подробнее</a>
    //<a class="btn go-to-course" href="/course/business-process/">Подробнее</a>
    //<a class="btn go-to-course" href="http://arivistika.ru/course/course-pro-declaration/">Подробнее</a>

    // TODO: 16.05.2022, запрос на улучшение: адрес страницы сделать "courses-list" (сейчас "cources-list")


    @Test
    @Disabled ("Этот тест будет пропущен")
    @Tag("eventsTests")
    @DisplayName("Проверка текста на стр.Расписание")
    void searchEvents() {
        open("events-list/");
        $(".event-title").shouldHave(text("Что нужно хранить и держать в порядке на случай таможенной проверки"));
    }
}



