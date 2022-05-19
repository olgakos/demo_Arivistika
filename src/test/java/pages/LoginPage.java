package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    // locators
    //Ниже: пример использования PageObjects для Форм
    //$("#username").
    private SelenideElement nameInput = $("#username");
    //$("#password")
    private SelenideElement passwordInput = $("#password");

    //Ниже: пример использования PageObjects для кнопок
    //$(By.name("login"))
    private SelenideElement buttonLog = $(By.name("login"));

    //Ниже: пример использования PageObjects для текст.локаторов
    private SelenideElement textError = $(".woocommerce-error");

    // actions
    //Ниже: пример использования PageObjects для Форм
    //.setValue("test@test.com");
    public void setNameInput(String username) {
        nameInput.setValue(username);
    }

    //.setValue("123");
    public void setPasswordInput(String password) {
        passwordInput.setValue(password);
    }

    //Ниже: пример использования PageObjects для кнопок
    public void buttonSignInPressTest() {
        buttonLog.click();
    }

    //Ниже: пример использования PageObjects для текст.локаторов
    public void checkErrorAlert() {
        textError.shouldHave(text("Неверный адрес e-mail"));
    }
}
