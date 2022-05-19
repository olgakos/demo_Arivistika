package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VideoPage extends TestBase {

    // locators
    private SelenideElement buttonMoreAboutVEDRec = $(".buy-course-block a[href*='proved-lessons-recording']");
    private SelenideElement buttonMoreDeclarant = $(".buy-course-block a[href*='course-pro-declaration']");
    private SelenideElement buttonBay = $($(".lp-course-buttons").$(byText("Купить этот курс")));
    private SelenideElement textHeaderDeclarant = $(byText("Курс PRO Декларирование"));
    private SelenideElement textHeaderVed = $(byText("Курс PRO ВЭД (Запись)"));

    private ElementsCollection textBodyCheck = $$("body"); //важно, $$

    // actions

    public void setButtonMoreAboutVEDRec() {
        buttonMoreAboutVEDRec.click();
    } //кнопка "Подробнее" (в блоке "Курс PRO ВЭД (Запись)")

    public void setButtonMoreAboutDeclarant() {
        buttonMoreDeclarant.click();
    } //кнопка "Подробнее" (в блоке Декларант

    public void setButtonBay() {
        buttonBay.click();
    } //кнопка Купить

    public void courseHeaderDeclarantVisible() {
        textHeaderDeclarant.isDisplayed();
    }

    public void courseHeaderVedVisible() {
        textHeaderVed.isDisplayed();
    }


    public void checkTextInBody() {
        textBodyCheck.find(text("Декларации на товары и их виды")).shouldBe(visible);
    } //важно, $$

}
