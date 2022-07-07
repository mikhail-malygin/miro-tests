package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.CareersPage;
import pages.MainPage;
import pages.VacancyPage;

public class TestBase {

    MainPage mainPage = new MainPage();
    CareersPage careersPage = new CareersPage();
    VacancyPage vacancyPage = new VacancyPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://miro.com";
        Configuration.browserSize = "1920x1080";
        // The page https://miro.com/careers/ is loading very long, more than default load timeout in Selenide framework.
        // It looks like a bug of Miro web page. The next configuration allows to avoid timeout error in tests
        Configuration.pageLoadTimeout = 100000;
    }
}
