package test;

import com.codeborne.selenide.Configuration;
import data.DataHelper;
import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage1;

import static com.codeborne.selenide.Selenide.open;

public class TestingApi {

    @BeforeEach
    void setup() {
        Configuration.headless = true;
        open("http://localhost:9999/");


    }

    @Name("")
    @Test
    void should() {
        var loginPage = new LoginPage1();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationInfo = DataHelper.getCodeVerify(authInfo);
        var DashboardPage = verificationPage.validVerify(verificationInfo);
    }



}
// install:
//         - chmod +x gradlew
//         - java -jar artifacts/app-ibank.jar -P:profile=test &
//
//         build_script:
//         - ./gradlew test --info -Dselenide.headless=true