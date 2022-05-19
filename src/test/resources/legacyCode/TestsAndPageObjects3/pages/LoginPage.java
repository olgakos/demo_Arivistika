package legacyCode.TestsAndPageObjects3.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    // locators
    //$("#username").
    private SelenideElement nameInput = $("#username");
    //$("#password")
    private SelenideElement passwordInput = $("#password");

    //$(By.name("login"))
    //private SelenideElement buttonInput = $(By.name("login"));

    // actions
    //.setValue("test@test.com");
    public void setNameInput (String username) {
        nameInput.setValue(username);
    }

    //.setValue("123");
    public void setPasswordInput (String password) {
        passwordInput.setValue(password);
    }
}
