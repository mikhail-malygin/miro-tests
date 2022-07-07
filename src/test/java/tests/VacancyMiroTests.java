package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class VacancyMiroTests extends TestBase{

    @Test
    @DisplayName("Open a main page of Miro")
    void openMiroMainPageTest() {
        step("Open a main page by url https://miro.com and check visibility of necessary elements on the page", () ->
                mainPage.openMainPage());
    }

    @Test
    @DisplayName("Open a careers page of Miro")
    void openMiroCareersPageTest() {
        step("Open a careers page https://miro.com/careers/ and check visibility of necessary elements on the page", () ->
                careersPage.openCareersPage());
    }


    @ValueSource(strings = {"qa automation", "engineer", "1С"})
    @ParameterizedTest(name = "Searching for a vacancy {0}")
    @DisplayName("Search a vacancy on careers page")
    void searchVacancyMiroCareersPageTest(String jobTitle) {
        step("Open a careers page https://miro.com/careers/", () ->
                careersPage.openCareersPage());

        step("Search a vacancy", () -> {
            careersPage.searchVacancyCareersPage(jobTitle);
        });
    }

    @ValueSource(strings = {"qa automation", "engineer", "1С"})
    @ParameterizedTest(name = "Open a vacancy {0} page")
    @DisplayName("Open a vacancy page")
    void openVacancyPageTest(String jobTitle) {
        step("Open a careers page https://miro.com/careers/", () ->
                careersPage.openCareersPage());

        step("open a vacancy page", () ->
                careersPage.openVacancyPage(jobTitle));
    }

    @Test
    @DisplayName("Fill in a vacancy form without CV and check validation error resume/CV is required")
    void applyVacancyTest() {
        step("Fill in a vacancy form without CV", () ->
                vacancyPage.openVacancyPage(ID_JOB_TITLE)
                           .goToApplyForm()
                           .setFirstName(FIRST_NAME)
                           .setLastName(LAST_NAME)
                           .setEmail(EMAIL)
                           .setPhone(PHONE_NUMBER)
                           .submitApplication());

        step("Check validation error resume/CV is required", () ->
                vacancyPage.validationErrorCVIsRequired());
    }

}
