package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpPage {

    protected static final SelenideElement titleSignUpPage = $("h1.signup__title-form");
    protected static final SelenideElement nameInput = $("#name");
    protected static final SelenideElement emailInput = $("#email");
    protected static final SelenideElement passwordInput = $("#password");
    protected static final SelenideElement agreePrivacyPolicyCheckbox = $("[for='signup-terms']:not(#termsError)");
    protected static final SelenideElement getStartedNowButton = $(".signup__submit");
    protected static final SelenideElement enterPasswordHint = $(".js-empty-password");

    public SignUpPage openSignUpPage() {
        open("/signup/");

        titleSignUpPage.shouldHave(text("Get started free today"));
        nameInput.shouldBe(visible);
        emailInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        getStartedNowButton.shouldBe(visible);

        return this;
    }

    public SignUpPage setName(String firstName) {
        nameInput.setValue(firstName);

        return this;
    }

    public SignUpPage setWorkEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public SignUpPage agreePrivacyPolicy() {
        agreePrivacyPolicyCheckbox.click();

        return this;
    }

    public void submit() {
        getStartedNowButton.click();

        enterPasswordHint.shouldBe(visible);
    }

    public void checkValidationErrorEnterYourPassword() {
        enterPasswordHint.shouldBe(visible);
    }
}
