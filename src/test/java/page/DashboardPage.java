package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id='dashboard']");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    public SelenideElement card1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    public SelenideElement card2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public int getInitialBalanceOfCard1() {
        var text = card1.text();
        return exctractBalance(text);
    }

    public int getInitialBalanceOfCard2() {
        var text = card2.text();
        return exctractBalance(text);
    }

    public int exctractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public class CardsBalance {
        int card1Balance;
        int card2Balance;

        public void setCard1Balance(int card1Balance) {
            this.card1Balance = card1Balance;
        }

        public void setCard2Balance(int card2Balance) {
            this.card2Balance = card2Balance;
        }

        public int getCard1Balance() {
            return card1Balance;
        }

        public int getCard2Balance() {
            return card2Balance;
        }

    }
}
