package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id='dashboard']");
    private ElementsCollection cards = $$("[class='list__item']");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(visible);
    }

   // public int getFirstCardBalance() {
   //     val text = cards.first().text();
   //     return extractBalance(text);
   // }
//
   // private int extractBalance(String text) {
   //     val start = text.indexOf(balanceStart);
   //     val finish = text.indexOf(balanceFinish);
   //     val value = text.substring(start + balanceStart.length(), finish);
   //     return Integer.parseInt(value);
   // }

}

