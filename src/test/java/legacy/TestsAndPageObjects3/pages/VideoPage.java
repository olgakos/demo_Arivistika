package legacy.TestsAndPageObjects3.pages;

import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VideoPage extends TestBase {

    // locators
    private SelenideElement buttonMoreAboutVEDRec = $(".buy-course-block a[href*='proved-lessons-recording']");
    private SelenideElement buttonMoreDeclarant = $(".buy-course-block a[href*='course-pro-declaration']");
    private SelenideElement buttonBay = $($(".lp-course-buttons").$(byText("Купить этот курс")));

    // actions
    //кнопка "Подробнее" (в блоке "Курс PRO ВЭД (Запись)")
    public void setButtonMoreAboutVEDRec() {
        buttonMoreAboutVEDRec.click();
    }

    //кнопка "Подробнее" (в блоке Декларант)
    public void setButtonMoreAboutDeclarant() {
        buttonMoreDeclarant.click();
    }

    //кнопка Купить
    public void setButtonBay() {
        buttonBay.click();
    }
}
