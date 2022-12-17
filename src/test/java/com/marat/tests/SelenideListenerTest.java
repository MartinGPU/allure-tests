package com.marat.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideListenerTest {

    @Test
    public void testGitHub() {
        SelenideLogger.addListener("Allure", new AllureSelenide());

        open("http://github.com");
        $(".header-search-input").as("Поисковая строка").click();
        $(".header-search-input").as("Поисковая строка").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").as("Поисковая строка").submit();
        $(linkText("eroshenkoam/allure-example")).as("Ссылка репозитория").click();
        $(partialLinkText("Issues")).as("Клик по Issues").click();
        $(byText("#952")).as("Наличие искомого элемента").should(Condition.visible);
    }
}
