package data;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import org.checkerframework.checker.units.qual.A;

import static com.codeborne.selenide.Selenide.$;

public class DataHelper {
    private DataHelper() {
    }


    public static class AuthInfo {
        String login;
        String password;

        public AuthInfo(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo() {
        return new AuthInfo("vasili", "123qwerty");
    }

    public static class Verification {
        String code;

        public Verification(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public static Verification getCodeVerify(AuthInfo authInfo) {
        return new Verification("12345");
    }

    public static Verification getCodeVerifyNotValid(AuthInfo authInfo) {
        return new Verification("12347");
    }


      /*  private ElementsCollection cards = $$(".list__item");
        private final String balanceStart = "баланс: ";
        private final String balanceFinish = " р.";

        public Dashboard() {
        }

        public int getCardBalance(String id) {
            // TODO: перебрать все карты и найти по атрибуту data-test-id
            return extractBalance(text);
        }

        private int extractBalance(String text) {
            val start = text.indexOf(balanceStart);
            val finish = text.indexOf(balanceFinish);
            val value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }*/

}
