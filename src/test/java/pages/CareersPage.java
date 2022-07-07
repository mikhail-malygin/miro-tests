package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.VacancyPage.applyNowButton;
import static pages.VacancyPage.titleJobVacancy;

public class CareersPage {

    protected static final SelenideElement careersMiroBanner = $(".careers-header-1");
    protected static final SelenideElement careersSearchPlaceholder = $(".careers-header-1 input[type='text']");
    protected static final SelenideElement foundVacancy = $(".careers-filters-2__item-job:not(.hidden)");
    protected static final SelenideElement notFoundVacancy = $(".careers-filters-2__empty-jobs:not(.hidden)");

    public void openCareersPage() {
        open("/careers/");

        careersMiroBanner.shouldBe(visible);
        careersSearchPlaceholder.shouldBe(visible);
    }

    public boolean searchVacancyCareersPage(String jobTitle) {
        careersSearchPlaceholder.setValue(jobTitle).pressEnter();

        if (notFoundVacancy.isDisplayed()) {
            notFoundVacancy.$("h2").shouldHave(text("There are no open positions for this specific location or team"));
            return false;
        } else {
            foundVacancy.shouldBe(visible);
            return true;
        }
    }

    public void openVacancyPage(String jobTitle) {
        if (searchVacancyCareersPage(jobTitle)) {
            foundVacancy.click();

            titleJobVacancy.shouldBe(visible);
            applyNowButton.shouldBe(visible);
        } else {
            System.out.println("There are no open positions for this specific location or team");
        }
    }
}


