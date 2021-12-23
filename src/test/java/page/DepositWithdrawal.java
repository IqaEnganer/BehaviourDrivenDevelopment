package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DepositWithdrawal {

    public DepositWithdrawal() {
    }

    private static ElementsCollection topUp = $$("[data-test-id='action-deposit']  .button__text");
    private static SelenideElement amount = $("[data-test-id='amount'] .input__control");
    private static SelenideElement where = $("[data-test-id='from'] .input__control");
    private static SelenideElement topUpAmount = $("[data-test-id='action-transfer'] .button__text");

    public static void moneyTransfer(DataHelper.CardInfo cardInfo, String sum) {
        topUp.get(0).click();
        amount.doubleClick().sendKeys("BACKSPACE");
        amount.setValue(sum);
        where.setValue(cardInfo.getNumberCard2());
        topUpAmount.click();

    }

    public static void moneyTransfer1(DataHelper.CardInfo cardInfo, String sum) {
        topUp.get(1).click();
        amount.doubleClick().sendKeys("BACKSPACE");
        amount.setValue(sum);
        where.setValue(cardInfo.getNumberCard1());
        topUpAmount.click();

    }


}
