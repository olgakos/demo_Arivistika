package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class HomePage {


    // locators
    //Ниже: пример использования PageObjects для Форм
    //$("input[placeholder='Ваше имя']")
    private SelenideElement nameInput = $("input[placeholder='Ваше имя']");
    private SelenideElement positionInput = $("input[placeholder='Должность']");
    private SelenideElement telInput = $("input[placeholder='Контактный телефон']");
    private SelenideElement emailInput = $("input[placeholder='Ваш email']");
    private SelenideElement companyInput = $("input[placeholder='Название компании']");
    private SelenideElement infoInput = $("input[placeholder='Откуда узнали']");
    private SelenideElement goalInput = $("textarea[placeholder='Опишите цель обучения']");
    //Ниже: пример использования PageObjects для текст.локаторов
    private SelenideElement textSchoolName = $(".site-branding");
    private SelenideElement textThatProfessional = $(byText("Тест на профориентацию"));
    private ElementsCollection textOnline = $$(".featured-event-type"); //важно, $$
    //private SelenideElement textOnline = $$(".featured-event-type").get(0); //?
    private SelenideElement textLink = $(By.linkText("info@arivistika.ru"));
    private SelenideElement textAdress = $(".footer-address");
    //Ниже: пример использования PageObjects для кнопок
    private SelenideElement buttonLog = $("input[value='Зарегистрироваться']");

    // actions
    public void setNameInput(String username) {
        nameInput.setValue(username);
    }

    public void setPositionInput(String position1) {
        positionInput.setValue(position1);
    }

    public void setTelInput(String tel1) {
        telInput.setValue(tel1);
    }

    public void setEmailInput(String email1) {
        emailInput.setValue(email1);
    }

    public void setCompanyInput(String company1) {
        companyInput.setValue(company1);
    }

    public void setInfoInput(String info1) {
        infoInput.setValue(info1);
    }

    public void setGoalInput(String goal1) {
        goalInput.setValue(goal1);
    }

    //Ниже: пример использования PageObjects для текст.локаторов
    public void checkThatSchoolNameVisible() {
        textSchoolName.shouldHave(text("Школа [ВЭД]"));
    }

    public void checkThatProfessionalTestVisible() {
        textThatProfessional.shouldBe(visible);
    }

    public void checkThatTextOnlineTestVisible() {
        textOnline.find(text("Онлайн")).shouldBe(visible); //важно, $$
    }

    public void checkLinkTextTestVisible() {
        textLink.isDisplayed();
    }

    public void checkAddressTestVisible() {
        textAdress.shouldHave(text("Санкт-Петербург, ул. Гапсальская, д. 5, БЦ «Балтика», офис 801"));
    }

    //Ниже: пример использования PageObjects для кнопок
    public void buttonLoginPressTest() {
        buttonLog.click();
    }

}
