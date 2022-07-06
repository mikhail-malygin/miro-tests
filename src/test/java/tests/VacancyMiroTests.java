package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class VacancyMiroTests extends TestBase{

    @Test
    void openMiroMainPage() {
        step("Open a main page and check necessary elements of the page", () -> {
            mainPage.openMainPage();
        });
    }

    @Test
    void openMiroCareersPage() {
        step("Open a careers page and check necessary elements of the page", () -> {
            careersPage.openCareersPage();
        });
    }
}
