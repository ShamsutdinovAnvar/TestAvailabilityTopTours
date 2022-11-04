package com.wegotrip;

import com.codeborne.selenide.Configuration;
import com.wegotrip.pages.ToursPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;

public class AvailableTest {

    ToursPage toursPage = new ToursPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://wegotrip.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @ParameterizedTest(name = "Проверка доступности топ-20 туров")
    @CsvFileSource(resources = "/tours.csv")
    void checkAvailableTest(String testData) {
        open(testData);
        toursPage.goCheckout_1()
                .waiting()
                .goCheckout_2()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setPhone()
                .goPayment()
                .checkResult()
                .clear();

    }

}