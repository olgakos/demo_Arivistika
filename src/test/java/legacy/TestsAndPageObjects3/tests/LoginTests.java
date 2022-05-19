package legacy.TestsAndPageObjects3.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends TestBase {

    @Test
    @Tag("loginTests")
    @DisplayName("Залогин")
    void loginTestFail() {
        open("my-account/");

        //$("#username").setValue("test@test.com");
        new LoginPage().setNameInput("test@test.test");
        new LoginPage().setPasswordInput("123");
        $(By.name("login")).click(); //кнопка "Войти"

        $(".woocommerce-error").shouldHave(text("Неверный адрес e-mail"));
    }
}
