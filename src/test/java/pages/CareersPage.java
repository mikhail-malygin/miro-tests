package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CareersPage {

    protected static final SelenideElement careersMiroBanner = $(".careers-header-1");
    protected static final SelenideElement careersSearchPlaceholder = $(".careers-header-1 [placeholder='Job title or keywords']");

    public void openCareersPage() {
        open("/careers/");

        careersMiroBanner.shouldBe(visible);
        careersSearchPlaceholder.shouldBe(visible);
    }
}
