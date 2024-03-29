package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
    @DisplayName("Open a signup page of Miro")
    @Tag("signup")
    @Disabled
    void openMiroSignUpPageTest() {
        step("Open a signup page by url https://miro.com/signup/ and check visibility of necessary elements on the page", () ->
                signUpPage.openSignUpPage());
    }

    @Test
    @DisplayName("Fill in a sign up form without password and check validation error Enter your password")
    @Tag("signup")
    void signUpTest() {
        step("Open a signup page by url https://miro.com/signup/ " +
                   "and fill in name, work email and agreement of Privacy Policy", () ->
                signUpPage.openSignUpPage()
                          .setName(FIRST_NAME)
                          .setWorkEmail(EMAIL)
                          .agreePrivacyPolicy()
                          .submit());

        step("check validation error Enter your password", () ->
                signUpPage.checkValidationErrorEnterYourPassword());
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
    @Tag("vacancy")
    void openVacancyPageTest(String jobTitle) {
        step("Open a careers page https://miro.com/careers/", () ->
                careersPage.openCareersPage());

        step("open a vacancy page", () ->
                careersPage.openVacancyPage(jobTitle));
    }

    @Test
    @DisplayName("Fill in a vacancy form without CV and check validation error resume/CV is required")
    @Tag("vacancy")
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

    @Test
    @AllureId("12328")
    @DisplayName("[Manual] Authorization via Google")
    @Owner("allure8")
    void authViaGoogle() {
        step("Open web page https://miro.com/");
        step("Click button Sign up for free", () -> {
            step("Choose authorization via Google");
            step("Agree with all conditions. Click Continue to sign up");
            step("Choose test google account ", () -> {
                step("user: test_user@gmail.com, password:qwer1234");
                step("Click Ok");
            });
            step("Check:", () -> {
                step("There is a popup Please create a team");
                step("There is test profile with email: Press button Sign up for free");
                step("Screenshot:");
                        step("");
            });
        });
    }

}
