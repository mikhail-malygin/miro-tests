package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    protected static final SelenideElement learnMiroHref = $(".show-for-large #Learn-about-Miro-Enterprise");
    protected static final SelenideElement careersHref = $("[href='/careers/']");

    public void openMainPage() {
        open(Configuration.baseUrl);

        learnMiroHref.shouldBe(visible);
        careersHref.shouldBe(visible);
    }
}
