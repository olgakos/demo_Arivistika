package legacy;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Проверка элементов публичной части сайта")
public class FirstTestsNoTestBase {

    @BeforeEach
    public void beforeEach() {
        String browser = System.getProperty("browser", "chrome");
        String size = System.getProperty("size", "1920x1080");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = size;
        Configuration.browser = browser;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Attach.attachAsText("Browser: ", browser);
        Attach.attachAsText("Size: ", size);

        clearBrowserCookies();

        Configuration.baseUrl = "https://arivistika.ru/";
        //open("");
    }

    @AfterEach
    @DisplayName("Формирование артефактов тестирования")
    void addAttachment() {
        Attach.screenshotAs("Last screenshot");
        Attach.addVideo();
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }

    @AfterAll
    public static void afterAll() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Залогин")
    @Tag("loginTests")
    void loginTestFail() {
        open("my-account/");
        $("#username").setValue("test@test.com");
        $("#password").setValue("123");
        $(By.name("login")).click(); //кнопка "Войти"
        $(".woocommerce-error").shouldHave(text("Неверный адрес e-mail"));
    }
    @Test
    @DisplayName("Проверка текста на главной странице")
    @Tag("siteTests")
    void searshTextElement() {
        open("");
        $(".site-branding").shouldHave(text("Школа [ВЭД] Аривистики"));
        $(byText("Тест на профориентацию")).shouldBe(visible);
        $$(".featured-event-type").find(text("Онлайн")).shouldBe(visible);
        //$$(".featured-event-type").find(text("НЕОнлайн")).shouldBe(visible); //negative test
        $(By.linkText("info@arivistika.ru")).isDisplayed();
        $(".footer-address").shouldHave(text("Санкт-Петербург, ул. Гапсальская, д. 5, БЦ «Балтика», офис 801"));
    }

    @Test
    @DisplayName("Отправки формы (заполнены не все поля)")
    @Tag("siteTests")
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
    //$$(".wpcf7-response-output").find(text("При отправке сообщения
    // произошла ошибка")).shouldBe(visible, Duration.ofSeconds(10));


    @Test
    @DisplayName("Проверка оплаты видеоурока \"Курс PRO Декларирование\"")
    @Tag("coursesTests")
    void openCoursePayTest() {
        open("cources-list/");
        $(byText("Курс PRO Декларирование")).isDisplayed();
        $(".buy-course-block a[href*='course-pro-declaration']").click(); //кнопка "Подробнее"
        $(".lp-course-buttons").$(byText("Купить этот курс")).click(); //кнопка
        //Expect:
        $$(".paymentFormTitle").find(text("Оплата")).shouldBe(visible, Duration.ofSeconds(10));
        $(".fieldName").$(byText("Email для чека")).isDisplayed();
    }

    @Disabled ("Этот тест будет пропущен")
    @Test
    @DisplayName("Проверка доступности карточки видеоурока \"Курс PRO ВЭД (Запись)\"")
    @Tag("coursesTests")
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
    @DisplayName("Поиск по странице Расписание")
    @Tag("eventsTests")
    void searchEvents() {
        open("events-list/");
        $(".event-title").shouldHave(text("Что нужно хранить и держать в порядке на случай таможенной проверки"));
    }
}


