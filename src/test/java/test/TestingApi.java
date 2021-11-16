package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.DepositWithdrawal;
import page.LoginPage1;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestingApi {
    private SelenideElement heading = $("[data-test-id='dashboard']");

    DepositWithdrawal depositWithdrawal = new DepositWithdrawal();


    @BeforeEach
    void setup() {
        // Configuration.headless = true;
        open("http://localhost:9999/");


    }

    @Name("Проверка успешного перевода на первую карту")
    @Test
    void should() {
        var loginPage = new LoginPage1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationInfo = DataHelper.getCodeVerify(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationInfo);
        depositWithdrawal.setTopUp1(0, "5000");
        heading.shouldBe(Condition.visible);
        int card1 = dashboardPage.getInitialBalanceOfCard1();
        int card12 = depositWithdrawal.transferCard1(10000, 5000).getCard1();
        assertEquals(card12, card1);
    }

    @Name("Проверка успешного перевода на вторую  карту")
    @Test
    void should2() {
        var loginPage = new LoginPage1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationInfo = DataHelper.getCodeVerify(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationInfo);
        depositWithdrawal.setTopUp2(1, "5000");
        heading.shouldBe(Condition.visible);
        int actual = dashboardPage.getInitialBalanceOfCard2();
        int expected = depositWithdrawal.transferCard2(10000, 5000).getCard2();
        assertEquals(expected, actual);


    }
}
