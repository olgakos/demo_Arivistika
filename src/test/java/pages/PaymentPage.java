package pages;

import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage extends TestBase {

    // locators
    private SelenideElement textPaymentFormTitle = $(".paymentFormTitle");
    private SelenideElement textfieldName = $(".fieldName");

    // actions
    public void checkPaymentFormTitle() {
        textPaymentFormTitle.shouldBe(visible);
    }
    public void checkFieldName() {
        textfieldName.isDisplayed();
    }
}
