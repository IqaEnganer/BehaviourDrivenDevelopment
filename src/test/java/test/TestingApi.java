package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import jdk.jfr.Name;
import org.junit.jupiter.api.*;
import page.DashboardPage;
import page.DepositWithdrawal;
import page.LoginPage1;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestingApi {
    private SelenideElement heading = $("[data-test-id='dashboard']");




    @BeforeEach
     void setUp() {
        //Configuration.headless = true;
        open("http://localhost:9999/");
        var loginPage1 = new LoginPage1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage1.signIn(authInfo);
        var verificationCode = DataHelper.getCodeVerify(authInfo);
        verificationPage.validVerify(verificationCode);
        var getCard = new DashboardPage();
        var transfer = new DepositWithdrawal();
        var balanceFirstCard = getCard.getFirstCardBalance();
        var balanceSecondCard = getCard.getSecondCardBalance();
        var countSecondCard = balanceSecondCard - 10_000;
        var countFirstCard = balanceFirstCard - 10_000;
        String changeStringFirstCard = String.valueOf(countFirstCard);
        String changeStringSecondCard = String.valueOf(countSecondCard);
        if (balanceFirstCard == balanceSecondCard) {
            System.out.println("The balances are equal");
        }
        if (balanceFirstCard < 10000) {
            transfer.moneyTransfer(DataHelper.getCardInfo(), changeStringSecondCard);
        } else {
            transfer.moneyTransfer1(DataHelper.getCardInfo(), changeStringFirstCard);
        }
    }


    @Name("Successful transfer to the first card")
    @Test
    void shouldSuccessfulTransactionCardFirst() {
        var getCard = new DashboardPage();
        var transfer = new DepositWithdrawal();
        var expected = getCard.getFirstCardBalance() + 2000;
        transfer.moneyTransfer(DataHelper.getCardInfo(), "2000");
        var actual = getCard.getFirstCardBalance();
        assertEquals(expected, actual);
    }

    @Name("Successful transfer to the second card")
    @Test
    void shouldSuccessfulTransactionCardSecond() {
        var getCard = new DashboardPage();
        var transfer = new DepositWithdrawal();
        var expected = getCard.getSecondCardBalance() + 2000;
        transfer.moneyTransfer1(DataHelper.getCardInfo(), "2000");
        var actual = getCard.getSecondCardBalance();
        assertEquals(expected, actual);
    }

    @Name("Transfer of the amount more than on the balance of the first card")
    @Test
    void shouldNotSuccessfulTransactionWithLargeAmountFirstCard() {
        var getCard = new DashboardPage();
        var transfer = new DepositWithdrawal();
        var expected = getCard.getFirstCardBalance();
        transfer.moneyTransfer(DataHelper.getCardInfo(), "15000");
        var actual = getCard.getFirstCardBalance();
        assertEquals(expected, actual);
        System.out.println(actual);

    }

    @Name("Transfer of the amount more than on the balance of the second card")
    @Test
    void shouldNotSuccessfulTransactionWithLargeAmountSecondCard() {
        var getCard = new DashboardPage();
        var transfer = new DepositWithdrawal();
        var expected = getCard.getSecondCardBalance();
        transfer.moneyTransfer1(DataHelper.getCardInfo(), "30000");
        var actual = getCard.getSecondCardBalance();
        assertEquals(expected, actual);
    }

}
