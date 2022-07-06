package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.CareersPage;
import pages.MainPage;

public class TestBase {

    MainPage mainPage = new MainPage();
    CareersPage careersPage = new CareersPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://miro.com";
        Configuration.browserSize = "1920x1080";
    }
}
