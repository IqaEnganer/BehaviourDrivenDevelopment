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

    public static class CardInfo {

        String numberCard1;
        String numberCard2;

        public CardInfo(String numberCard1, String numberCard2) {
            this.numberCard1 = numberCard1;
            this.numberCard2 = numberCard2;
        }

        public String getNumberCard1() {
            return numberCard1;
        }

        public String getNumberCard2() {
            return numberCard2;
        }

        public void setNumberCard1(String numberCard1) {
            this.numberCard1 = numberCard1;
        }

        public void setNumberCard2(String numberCard2) {
            this.numberCard2 = numberCard2;
        }
    }

    public static CardInfo getCardInfo() {
        return new CardInfo("5559 0000 0000 0001", "5559 0000 0000 0002");
    }
}