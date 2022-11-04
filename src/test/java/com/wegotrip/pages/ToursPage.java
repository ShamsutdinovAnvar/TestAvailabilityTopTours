package com.wegotrip.pages;

import com.codeborne.selenide.Selenide;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ToursPage {
    public ToursPage goCheckout_1() {

//        $(".TimeslotsVariant__button").click();
        $(".Button--stroked").shouldBe(visible).click();
        return this;
    }

    public ToursPage waiting() {
//        sleep(2000);
        $(".Variant__header").shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    public ToursPage goCheckout_2() {
        sleep(2000);
        $(".Button--main").shouldBe(visible).click();
        return this;
    }

    public ToursPage setFirstName() {
        $("input[name='customer.firstName']").setValue("Anvar");
        return this;
    }

    public ToursPage setLastName() {
        $("input[name='customer.lastName']").setValue("Shamsutdinov");
        return this;
    }

    public ToursPage setEmail() {
        $("input[name='customer.email']").setValue("a.shamsutdinov@wegotrip.com");
        return this;
    }

    public ToursPage setPhone() {
        $("input[name='customer.phone']").setValue("79244850378");
        return this;
    }

    public ToursPage goPayment() {
        $("button[type='submit']").shouldBe(visible, Duration.ofSeconds(5));
        $("button[type='submit']").shouldBe(visible).click();

        return this;
    }

    public ToursPage checkResult() {

        $("button[type='submit']").shouldBe(visible, Duration.ofSeconds(5));
        $("button[type='submit']").shouldHave(text("Pay"));

        return this;
    }
    public ToursPage clear() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        return this;
    }
}