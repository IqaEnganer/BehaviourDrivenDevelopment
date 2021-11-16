package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DepositWithdrawal {
    private ElementsCollection topUp = $$("[data-test-id='action-deposit']  .button__text");
    private SelenideElement amount = $("[data-test-id='amount'] .input__control");
    private SelenideElement where = $("[data-test-id='from'] .input__control");
    private SelenideElement topUpAmount = $("[data-test-id='action-transfer'] .button__text");

    public DepositWithdrawal() {
    }

    public void setTopUp1(int numberCard,String sum) {
        topUp.get(numberCard).click();
        amount.setValue(sum);
        where.setValue(DataHelper.getCardInfo().getNumberCard2());
        topUpAmount.click();
    }
    public void setTopUp2(int numberCard,String sum) {
        topUp.get(numberCard).click();
        amount.setValue(sum);
        where.setValue(DataHelper.getCardInfo().getNumberCard1());
        topUpAmount.click();
    }

    public class CurrentBalance {
        private int card1 = 10000;
        private int card2 = 10000;

        public CurrentBalance(int card1, int card2) {
            this.card1 = card1;
            this.card2 = card2;
        }

        public CurrentBalance(int card1) {
            this.card1 = card1;
        }

        public void setCard1(int card1) {
            this.card1 = card1;
        }

        public void setCard2(int card2) {
            this.card2 = card2;
        }

        public int getCard1() {
            return card1;
        }

        public int getCard2() {
            return card2;
        }
    }

    // Метод для подсчета баланса для последующего сравнения с текущим на сайте
    public CurrentBalance transferCard1(int sumScore, int sumTransfer) {
        int balance = sumScore + sumTransfer;
        int balance1 = sumScore - sumTransfer;
        return new CurrentBalance(balance, balance1);
    }

    public CurrentBalance transferCard2(int sumScore, int sumTransfer) {
        int balance = sumScore - sumTransfer;
        int balance1 = sumScore + sumTransfer;
        return new CurrentBalance(balance, balance1);
    }
}
