package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.VideoPage;
import pages.PaymentPage;

import static com.codeborne.selenide.Selenide.*;

public class VideoTests extends TestBase {
    VideoPage videoPage = new VideoPage();
    PaymentPage paymentPage = new PaymentPage();

    @Test
    @DisplayName("Проверка оплаты видеоурока \"Курс PRO Декларирование\"")
    @Tag("coursesTests")
    void openCoursePayTest() {
        open("cources-list/");
        videoPage.courseHeaderDeclarantVisible();
        videoPage.setButtonMoreAboutDeclarant(); //кнопка "Подробнее"
        videoPage.setButtonBay();
        paymentPage.checkPaymentFormTitle();
        paymentPage.checkFieldName();
    }

    @Test
    @DisplayName("Проверка доступности карточки видеоурока \"Курс PRO ВЭД (Запись)\"")
    @Tag("coursesTests")
    void openCourseCardTest() {
        open("cources-list/");
        videoPage.courseHeaderVedVisible();
        videoPage.setButtonMoreAboutVEDRec();
        videoPage.checkTextInBody();
    }

    // TODO: 16.05.2022, запрос на улучшение:  Привести ссылки на странице cources-list к единому стилю
    //<a class="btn go-to-course" href="/course/proved-lessons-recording">Подробнее</a>
    //<a class="btn go-to-course" href="/course/код-тн-вэд/">Подробнее</a>
    //<a class="btn go-to-course" href="/course/business-process/">Подробнее</a>
    //<a class="btn go-to-course" href="http://arivistika.ru/course/course-pro-declaration/">Подробнее</a>

    // TODO: 16.05.2022, запрос на улучшение: адрес страницы сделать "courses-list" (сейчас "cources-list")

}
