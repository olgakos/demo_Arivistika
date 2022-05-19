package legacyCode.TestsAndPageObjects3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    // locators



    //$("input[placeholder='Ваше имя']")
    private SelenideElement nameInput = $("input[placeholder='Ваше имя']");
    private SelenideElement positionInput = $("input[placeholder='Должность']");
    private SelenideElement telInput = $("input[placeholder='Контактный телефон']");
    private SelenideElement emailInput = $("input[placeholder='Ваш email']");
    private SelenideElement companyInput = $("input[placeholder='Название компании']");
    private SelenideElement infoInput = $("input[placeholder='Откуда узнали']");
    private SelenideElement goalInput = $("textarea[placeholder='Опишите цель обучения']");

    //Ниже: пример использования PageObjects для текст.локатора (не Best Practice)
    private SelenideElement locator_byText_shouldBe_visible = $(byText("Тест на профориентацию"));

    // actions
    public void setNameInput (String username) {
        nameInput.setValue(username);
    }

    public void setPositionInput (String position1) {
        positionInput.setValue(position1);
    }

    public void setTelInput (String tel1) {
        telInput.setValue(tel1);
    }

    public void setEmailInput (String email1) {
        emailInput.setValue(email1);
    }

    public void setCompanyInput (String company1) {
        companyInput.setValue(company1);
    }

    public void setInfoInput (String info1) {
        infoInput.setValue(info1);
    }

    public void setGoalInput (String goal1) {
        goalInput.setValue(goal1);
    }

    //Ниже: пример использования PageObjects для текст.локатора (не Best Practice)
    public void byText_shouldBe_visible (String locator1) {
        locator_byText_shouldBe_visible.shouldBe(visible);
    }
}
