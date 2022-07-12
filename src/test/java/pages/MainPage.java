package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    protected static final SelenideElement miroBanner = $(".com-sec-feature-3__back--workshops-color-yellow");
    protected static final SelenideElement careersHref = $("[href='/careers/']");

    public void openMainPage() {
        open(Configuration.baseUrl);

        miroBanner.shouldBe(visible);
        careersHref.shouldBe(visible);
    }
}
