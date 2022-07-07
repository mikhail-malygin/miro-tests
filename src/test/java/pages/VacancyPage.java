package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class VacancyPage {

    protected static final SelenideElement titleJobVacancy = $(".careers-inner-header__title");
    protected static final SelenideElement applyNowButton = $("[href='#apply']");
    protected static final SelenideElement firstNameInput = $("#first_name");
    protected static final SelenideElement lastNameInput = $("#last_name");
    protected static final SelenideElement emailInput = $("#email");
    protected static final SelenideElement phoneInput = $("#phone");
    protected static final SelenideElement submitApplicationButton = $("#submit_app");
    protected static final SelenideElement resumeCVField = $("[data-field='resume']");

    public VacancyPage openVacancyPage(String id) {
        open("/careers/vacancy/" + id + "/");

        return this;
    }


    public VacancyPage goToApplyForm() {
        applyNowButton.click();

        return this;
    }

    public VacancyPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public VacancyPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        
        return this;
    }


    public VacancyPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public VacancyPage setPhone(String phoneNumber) {
        phoneInput.setValue(phoneNumber);

        return this;
    }

    public void submitApplication() {
        submitApplicationButton.click();
    }

    public void validationErrorCVIsRequired() {
        resumeCVField.$("#validate_resume_error").shouldHave(text("Resume/CV is required."));
    }
}
