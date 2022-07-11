package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CareersPage;
import pages.MainPage;
import pages.SignUpPage;
import pages.VacancyPage;

import static java.lang.String.format;

public class TestBase {

    MainPage mainPage = new MainPage();
    CareersPage careersPage = new CareersPage();
    VacancyPage vacancyPage = new VacancyPage();
    SignUpPage signUpPage = new SignUpPage();

    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAll() {
        String login = config.login();
        String password = config.password();

        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true); // включение потовокого вещание видео
        capabilities.setCapability("enableVideo", true); // запись видео теста, записывается на сервер селеноида
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.baseUrl = "https://miro.com";

        // The page https://miro.com/careers/ is loading very long, more than default load timeout in Selenide framework.
        // It looks like a bug of Miro web page. The next configuration allows to avoid timeout error in tests
        Configuration.pageLoadTimeout = 100000;

        Configuration.remote = format("https://%s:%s@%s", login, password, System.getProperty("selenoidStand"));

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
