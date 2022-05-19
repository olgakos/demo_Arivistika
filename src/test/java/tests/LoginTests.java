package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage();

    String login = "test@test.test";
    String password = "123";

    @Test
    @Tag("loginTests")
    @DisplayName("Залогин")
    void loginTestFail() {
        open("my-account/");
        loginPage.setNameInput(login);
        loginPage.setPasswordInput(password);
        loginPage.buttonSignInPressTest();
        loginPage.checkErrorAlert();
    }
}
