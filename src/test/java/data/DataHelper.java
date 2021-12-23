package data;

import lombok.NoArgsConstructor;
import lombok.Value;


public class DataHelper {

    public DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getNotValidAuthInfo() {
        return new AuthInfo("vasili", "123qwerty");
    }

    @Value
    public static class Verification {
        String code;
    }

    public static Verification getCodeVerify(AuthInfo authInfo) {
        return new Verification("12345");
    }

    public static Verification getCodeVerifyNotValid(AuthInfo authInfo) {
        return new Verification("12347");
    }

    @Value
    public static class CardInfo {

        String numberCard1;
        String numberCard2;

    }

    public static CardInfo getCardInfo() {
        return new CardInfo("5559 0000 0000 0001", "5559 0000 0000 0002");
    }
}