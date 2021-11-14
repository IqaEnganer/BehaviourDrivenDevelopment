package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {


    private SelenideElement codeField = $("[data-test-id='code'] .input__control");
    private SelenideElement codeButton = $("[data-test-id='action-verify'] .button__content");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public DashboardPage validVerify(DataHelper.Verification verification) {
        codeField.setValue(verification.getCode());
        codeButton.click();
        return new DashboardPage();
    }


}
